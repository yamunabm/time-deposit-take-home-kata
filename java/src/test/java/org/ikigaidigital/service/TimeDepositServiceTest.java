package org.ikigaidigital.service;

import org.ikigaidigital.calculator.TimeDepositCalculator;
import org.ikigaidigital.entity.TimeDepositEntity;
import org.ikigaidigital.mapper.TimeDepositMapper;
import org.ikigaidigital.model.PlanType;
import org.ikigaidigital.model.TimeDepositDto;
import org.ikigaidigital.repository.TimeDepositRepository;
import org.ikigaidigital.service.impl.TimeDepositServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TimeDepositServiceTest {
    @Spy
    @InjectMocks
    private TimeDepositServiceImpl timeDepositServiceImpl;

    @Mock
    private TimeDepositRepository repository;

    @Mock
    private TimeDepositCalculator timeDepositCalculator;


    @Test
    void testRecalculateAllBalances() {
        TimeDepositDto timeDepositDto = TimeDepositDto.builder()
                .id(1)
                .planType(PlanType.BASIC)
                .balance(BigDecimal.valueOf(1000))
                .days(60)
                .build();

        TimeDepositEntity timeDepositEntity = TimeDepositEntity.builder()
                .id(1)
                .planType(PlanType.BASIC.name())
                .balance(BigDecimal.valueOf(1000))
                .days(60)
                .build();

        List<TimeDepositDto> dtoList = List.of(timeDepositDto);
        List<TimeDepositEntity> entityList = List.of(timeDepositEntity);

        // Stub getAll() method on spy
        doReturn(dtoList).when(timeDepositServiceImpl).getAll();

        // Mock static method of TimeDepositMapper
        try (MockedStatic<TimeDepositMapper> mocked = mockStatic(TimeDepositMapper.class)) {
            mocked.when(() -> TimeDepositMapper.of(dtoList)).thenReturn(entityList);

            timeDepositServiceImpl.recalculateAllBalances();

            verify(timeDepositCalculator).updateBalance(dtoList);
            verify(repository).saveAll(entityList);
        }
    }

    @Test
    public void testGetAll() {
        TimeDepositEntity td1 = TimeDepositEntity.builder()
                .id(1)
                .planType(PlanType.BASIC.name())
                .days(60)
                .balance(new BigDecimal("1000.00"))
                .build();

        TimeDepositEntity td2 = TimeDepositEntity.builder()
                .id(2)
                .planType(PlanType.PREMIUM.name())
                .days(180)
                .balance(new BigDecimal("8000.00"))
                .build();

        when(repository.findAll()).thenReturn(Arrays.asList(td1, td2));

        assertThat(timeDepositServiceImpl.getAll()).hasSize(2);
    }
}

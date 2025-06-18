package org.ikigaidigital.controller;

import org.ikigaidigital.model.PlanType;
import org.ikigaidigital.model.TimeDepositDto;
import org.ikigaidigital.service.TimeDepositService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class TimeDepositControllerTest {

    @Mock
    private TimeDepositService timeDepositService;

    @InjectMocks
    private TimeDepositController timeDepositController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // important to initialize mocks
    }

    @Test
    void testGetAll_Success() {
        // Given
        TimeDepositDto dto1 = TimeDepositDto.builder()
                .id(1)
                .planType(PlanType.BASIC)
                .balance(BigDecimal.valueOf(1000))
                .days(60)
                .build();

        TimeDepositDto dto2 = TimeDepositDto.builder()
                .id(2)
                .planType(PlanType.PREMIUM)
                .balance(BigDecimal.valueOf(8000))
                .days(180)
                .build();

        List<TimeDepositDto> expectedList = Arrays.asList(dto1, dto2);
        when(timeDepositService.getAll()).thenReturn(expectedList);

        // When
        ResponseEntity<List<TimeDepositDto>> response = timeDepositController.getAll();

        // Then
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).hasSize(2).containsExactly(dto1, dto2);
        verify(timeDepositService, times(1)).getAll();
    }

    @Test
    void testGetAll_Exception() {
        // Given
        when(timeDepositService.getAll()).thenThrow(new RuntimeException("DB error"));

        // When
        ResponseEntity<List<TimeDepositDto>> response = timeDepositController.getAll();

        // Then
        assertThat(response.getStatusCodeValue()).isEqualTo(500);
        assertThat(response.getBody()).isNull();
        verify(timeDepositService, times(1)).getAll();
    }

    @Test
    void testCalculateBalances_Success() {
        // When
        ResponseEntity<Void> response = timeDepositController.calculateBalances();

        // Then
        verify(timeDepositService, times(1)).recalculateAllBalances();
        assertThat(response.getStatusCodeValue()).isEqualTo(204); // NO_CONTENT
    }

    @Test
    void testCalculateBalances_Exception() {
        // Given
        doThrow(new RuntimeException("Service error")).when(timeDepositService).recalculateAllBalances();

        // When
        ResponseEntity<Void> response = timeDepositController.calculateBalances();

        // Then
        verify(timeDepositService, times(1)).recalculateAllBalances();
        assertThat(response.getStatusCodeValue()).isEqualTo(500); // INTERNAL_SERVER_ERROR
    }
}

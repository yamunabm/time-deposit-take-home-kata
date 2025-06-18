package org.ikigaidigital.mapper;

import org.ikigaidigital.entity.TimeDepositEntity;
import org.ikigaidigital.model.PlanType;
import org.ikigaidigital.model.TimeDepositDto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TimeDepositMapper {
    public static TimeDepositDto of(TimeDepositEntity entity) {
        return TimeDepositDto.builder()
                .id(entity.getId())
                .planType(PlanType.valueOf(entity.getPlanType()))
                .days(entity.getDays())
                .balance(entity.getBalance())
                .withdrawals(entity.getWithdrawals() == null ? Collections.emptyList() : WithdrawalMapper.of(entity.getWithdrawals()))
                .build();
    }

    public static TimeDepositEntity of(TimeDepositDto dto) {
        return TimeDepositEntity.builder()
                .id(dto.getId())
                .planType(dto.getPlanType().name())
                .days(dto.getDays())
                .balance(dto.getBalance())
                .build();
    }

    public static List<TimeDepositEntity> of(List<TimeDepositDto> allDeposits) {
        return allDeposits.stream()
                .map(TimeDepositMapper::of)
                .collect(Collectors.toList());
    }
}

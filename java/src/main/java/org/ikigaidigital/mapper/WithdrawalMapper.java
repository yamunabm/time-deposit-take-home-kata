package org.ikigaidigital.mapper;

import org.ikigaidigital.entity.WithdrawalEntity;
import org.ikigaidigital.model.WithdrawalDto;

import java.util.List;
import java.util.stream.Collectors;

public class WithdrawalMapper {
    public static WithdrawalDto of(WithdrawalEntity entity) {
        return WithdrawalDto.builder()
                .id(entity.getId())
                .amount(entity.getAmount())
                .date(entity.getDate())
                .timeDepositId(entity.getTimeDeposit().getId())
                .build();
    }

    public static List<WithdrawalDto> of(List<WithdrawalEntity> entities) {
        return entities.stream()
                .map(WithdrawalMapper::of)
                .collect(Collectors.toList());
    }
}

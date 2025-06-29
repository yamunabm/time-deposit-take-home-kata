package org.ikigaidigital.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeDepositDto {
    private int id;
    private PlanType planType;
    private BigDecimal balance;
    private int days;
    private List<WithdrawalDto> withdrawals;
}

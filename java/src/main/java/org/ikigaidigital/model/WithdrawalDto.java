package org.ikigaidigital.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawalDto {
    private Integer id;
    private Integer timeDepositId;
    private BigDecimal amount;
    private LocalDate date;
}

package org.ikigaidigital.calculator;

import org.ikigaidigital.model.TimeDepositDto;

import java.math.BigDecimal;

public interface InterestCalculator {
    BigDecimal calculateInterest(TimeDepositDto deposit);
}

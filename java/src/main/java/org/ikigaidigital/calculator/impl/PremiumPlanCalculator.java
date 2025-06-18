package org.ikigaidigital.calculator.impl;

import org.ikigaidigital.calculator.InterestCalculator;
import org.ikigaidigital.model.TimeDepositDto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PremiumPlanCalculator implements InterestCalculator {

    private static final BigDecimal RATE = new BigDecimal("0.05");
    private static final int NO_INTEREST_DAYS = 45;
    private static final int MONTHS_IN_YEAR = 12;

    @Override
    public BigDecimal calculateInterest(TimeDepositDto deposit) {

        BigDecimal interest = BigDecimal.ZERO;

        if (deposit.getDays() > NO_INTEREST_DAYS) {
            interest = deposit.getBalance()
                    .multiply(RATE)
                    .divide(BigDecimal.valueOf(MONTHS_IN_YEAR), 10,                                  // scale: number of decimal places to keep
                            RoundingMode.DOWN);
        }
        return interest.setScale(2, RoundingMode.HALF_UP);
    }
}
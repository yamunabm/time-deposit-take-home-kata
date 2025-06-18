package org.ikigaidigital.calculator.impl;

import org.ikigaidigital.calculator.InterestCalculator;
import org.ikigaidigital.model.TimeDepositDto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StudentPlanCalculator implements InterestCalculator {

    private static final BigDecimal RATE = new BigDecimal("0.03");
    private static final int INTEREST_DAYS = 365;
    private static final int NO_INTEREST_DAYS_IN_FIRST_YEAR = 30;
    private static final int MONTHS_IN_YEAR = 12;

    @Override
    public BigDecimal calculateInterest(TimeDepositDto deposit) {

        int days = deposit.getDays();
        BigDecimal interest = BigDecimal.ZERO;

        if (days > NO_INTEREST_DAYS_IN_FIRST_YEAR && days <= INTEREST_DAYS) {

            interest = deposit.getBalance()
                    .multiply(RATE)
                    .divide(BigDecimal.valueOf(MONTHS_IN_YEAR), 10,                                  // scale: number of decimal places to keep
                            RoundingMode.DOWN);
        }
        return interest.setScale(2, RoundingMode.HALF_UP);
    }
}
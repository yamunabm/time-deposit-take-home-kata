package org.ikigaidigital.calculator;

import org.ikigaidigital.model.TimeDepositDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TimeDepositCalculator {

    public BigDecimal computeInterest(TimeDepositDto deposit) {
        InterestCalculator calculator = InterestCalculatorFactory.getCalculator(deposit.getPlanType());
        return calculator.calculateInterest(deposit);
    }

    public void updateBalance(List<TimeDepositDto> timeDeposits) {
        timeDeposits.forEach(timeDeposit -> {
            BigDecimal interest = computeInterest(timeDeposit);
            timeDeposit.setBalance(timeDeposit.getBalance().add(interest));
        });
    }
}

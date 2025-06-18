package org.ikigaidigital.Calculator;

import org.ikigaidigital.calculator.TimeDepositCalculator;
import org.ikigaidigital.model.PlanType;
import org.ikigaidigital.model.TimeDepositDto;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TimeDepositCalculatorTest {
    @Test
    public void updateBalance_basicPlanWithInterest() {
        TimeDepositCalculator calc = new TimeDepositCalculator();

        //given
        TimeDepositDto basic = new TimeDepositDto(1, PlanType.BASIC, new BigDecimal("1234567.00"), 45);
        List<TimeDepositDto> plans = List.of(basic);

        //when
        calc.updateBalance(plans);

        //then
        assertEquals(new BigDecimal("1235595.81"), basic.getBalance());
    }

    @Test
    public void updateBalance_basicPlanWithoutInterest() {
        TimeDepositCalculator calc = new TimeDepositCalculator();
        //given
        TimeDepositDto basic = new TimeDepositDto(1, PlanType.BASIC, new BigDecimal("1234567.00"), 30);
        List<TimeDepositDto> plans = List.of(basic);

        //when
        calc.updateBalance(plans);

        //then
        assertEquals(new BigDecimal("1234567.00"), basic.getBalance());
    }

    @Test
    public void updateBalance_studentPlanWithInterest() {
        TimeDepositCalculator calc = new TimeDepositCalculator();
        //given

        TimeDepositDto basic = new TimeDepositDto(1, PlanType.STUDENT, new BigDecimal("3000.00"), 40);
        List<TimeDepositDto> plans = List.of(basic);

        //when
        calc.updateBalance(plans);

        //then
        assertEquals(new BigDecimal("3007.50"), basic.getBalance());
    }

    @Test
    public void updateBalance_studentPlanWithoutInterest() {
        TimeDepositCalculator calc = new TimeDepositCalculator();
        //given
        TimeDepositDto basic = new TimeDepositDto(1, PlanType.STUDENT, new BigDecimal("3000.00"), 30);
        List<TimeDepositDto> plans = List.of(basic);

        //when
        calc.updateBalance(plans);

        //then
        assertEquals(new BigDecimal("3000.00"), basic.getBalance());
    }

    @Test
    public void updateBalance_premiumPlanWithInterest() {
        TimeDepositCalculator calc = new TimeDepositCalculator();
        //given
        TimeDepositDto basic = new TimeDepositDto(1, PlanType.PREMIUM, new BigDecimal("9000.00"), 46);
        List<TimeDepositDto> plans = List.of(basic);

        //when
        calc.updateBalance(plans);

        //then
        assertEquals(new BigDecimal("9037.50"), basic.getBalance());
    }

    @Test
    public void updateBalance_premiumPlanWithoutInterest() {
        TimeDepositCalculator calc = new TimeDepositCalculator();
        //given
        TimeDepositDto basic = new TimeDepositDto(1, PlanType.PREMIUM, new BigDecimal("9000.00"), 45);
        List<TimeDepositDto> plans = List.of(basic);

        //when
        calc.updateBalance(plans);

        //then
        assertEquals(new BigDecimal("9000.00"), basic.getBalance());
    }
}

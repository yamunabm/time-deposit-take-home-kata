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
        TimeDepositDto basic = TimeDepositDto.builder()
                .id(1)
                .planType(PlanType.BASIC)
                .balance(new BigDecimal("1234567.00"))
                .days(45)
                .build();
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
        TimeDepositDto basic = TimeDepositDto.builder()
                .id(1)
                .planType(PlanType.BASIC)
                .balance(new BigDecimal("1234567.00"))
                .days(30)
                .build();
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

        TimeDepositDto student = TimeDepositDto.builder()
                .id(1)
                .planType(PlanType.STUDENT)
                .balance(new BigDecimal("3000.00"))
                .days(40)
                .build();
        List<TimeDepositDto> plans = List.of(student);

        //when
        calc.updateBalance(plans);

        //then
        assertEquals(new BigDecimal("3007.50"), student.getBalance());
    }

    @Test
    public void updateBalance_studentPlanWithoutInterest() {
        TimeDepositCalculator calc = new TimeDepositCalculator();
        //given
        TimeDepositDto student = TimeDepositDto.builder()
                .id(1)
                .planType(PlanType.STUDENT)
                .balance(new BigDecimal("3000.00"))
                .days(30)
                .build();
        List<TimeDepositDto> plans = List.of(student);

        //when
        calc.updateBalance(plans);

        //then
        assertEquals(new BigDecimal("3000.00"), student.getBalance());
    }

    @Test
    public void updateBalance_premiumPlanWithInterest() {
        TimeDepositCalculator calc = new TimeDepositCalculator();
        //given
        TimeDepositDto premium = TimeDepositDto.builder()
                .id(1)
                .planType(PlanType.PREMIUM)
                .balance(new BigDecimal("9000.00"))
                .days(46)
                .build();
        List<TimeDepositDto> plans = List.of(premium);

        //when
        calc.updateBalance(plans);

        //then
        assertEquals(new BigDecimal("9037.50"), premium.getBalance());
    }

    @Test
    public void updateBalance_premiumPlanWithoutInterest() {
        TimeDepositCalculator calc = new TimeDepositCalculator();
        //given
        TimeDepositDto premium = TimeDepositDto.builder()
                .id(1)
                .planType(PlanType.PREMIUM)
                .balance(new BigDecimal("9000.00"))
                .days(45)
                .build();
        List<TimeDepositDto> plans = List.of(premium);

        //when
        calc.updateBalance(plans);

        //then
        assertEquals(new BigDecimal("9000.00"), premium.getBalance());
    }
}

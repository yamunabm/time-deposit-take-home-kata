package org.ikigaidigital.service;

import org.ikigaidigital.model.TimeDeposit;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeDepositCalculatorTest {
    @Test
    public void updateBalance_basicPlanWithInterest() {
        TimeDepositCalculator calc = new TimeDepositCalculator();

        //given
        TimeDeposit basic = new TimeDeposit(1, "basic", 1234567.00, 45);
        List<TimeDeposit> plans = List.of(basic);

        //when
        calc.updateBalance(plans);

        //then
        assertThat(basic.getBalance()).isEqualTo(1235595.81);
    }

    @Test
    public void updateBalance_basicPlanWithoutInterest() {
        TimeDepositCalculator calc = new TimeDepositCalculator();
        //given
        TimeDeposit basic = new TimeDeposit(1, "basic", 1234567.00, 30);
        List<TimeDeposit> plans = List.of(basic);

        //when
        calc.updateBalance(plans);

        //then
        assertThat(basic.getBalance()).isEqualTo(1234567.0);
    }

    @Test
    public void updateBalance_studentPlanWithInterest() {
        TimeDepositCalculator calc = new TimeDepositCalculator();
        //given
        TimeDeposit basic = new TimeDeposit(1, "student", 3000.00, 40);
        List<TimeDeposit> plans = List.of(basic);

        //when
        calc.updateBalance(plans);

        //then
        assertThat(basic.getBalance()).isEqualTo(3007.5);
    }

    @Test
    public void updateBalance_studentPlanWithoutInterest() {
        TimeDepositCalculator calc = new TimeDepositCalculator();
        //given
        TimeDeposit basic = new TimeDeposit(1, "student", 3000.00, 30);
        List<TimeDeposit> plans = List.of(basic);

        //when
        calc.updateBalance(plans);

        //then
        assertThat(basic.getBalance()).isEqualTo(3000.0);
    }

    @Test
    public void updateBalance_premiumPlanWithInterest() {
        TimeDepositCalculator calc = new TimeDepositCalculator();
        //given
        TimeDeposit basic = new TimeDeposit(1, "premium", 9000.00, 46);
        List<TimeDeposit> plans = List.of(basic);

        //when
        calc.updateBalance(plans);

        //then
        assertThat(basic.getBalance()).isEqualTo(9037.5);
    }

    @Test
    public void updateBalance_premiumPlanWithoutInterest() {
        TimeDepositCalculator calc = new TimeDepositCalculator();
        //given
        TimeDeposit basic = new TimeDeposit(1, "premium", 9000.00, 45);
        List<TimeDeposit> plans = List.of(basic);

        //when
        calc.updateBalance(plans);

        //then
        assertThat(basic.getBalance()).isEqualTo(9000.0);
    }
}

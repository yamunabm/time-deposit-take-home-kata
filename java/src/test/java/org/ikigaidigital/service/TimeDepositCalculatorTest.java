package org.ikigaidigital;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeDepositCalculatorTest {
    @Test
    public void updateBalance_Test() {
        TimeDepositCalculator calc = new TimeDepositCalculator();
        TimeDeposit basic = new TimeDeposit(1, "basic", 1234567.00, 45);

        List<TimeDeposit> plans = List.of(basic);
        calc.updateBalance(plans);

        assertThat(basic.getBalance()).isEqualTo(1235595.81);
    }
}

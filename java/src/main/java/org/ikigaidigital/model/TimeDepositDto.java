package org.ikigaidigital.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TimeDepositDto {
    private int id;
    private PlanType planType;
    private BigDecimal balance;
    private int days;

    public TimeDepositDto(int id, PlanType planType, BigDecimal balance, int days) {
        this.id = id;
        this.planType = planType;
        this.balance = balance;
        this.days = days;
    }

    public int getId() { return id; }

    public PlanType getPlanType() {
        return planType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public int getDays() {
        return days;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

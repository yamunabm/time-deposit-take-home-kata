package org.ikigaidigital;

public class TimeDeposit {
    private String planType;
    private Double balance;
    private int days;

    public TimeDeposit(String planType, Double balance, int days) {
        this.planType = planType;
        this.balance = balance;
        this.days = days;
    }

    public String getPlanType() {
        return planType;
    }

    public Double getBalance() {
        return balance;
    }

    public int getDays() {
        return days;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}

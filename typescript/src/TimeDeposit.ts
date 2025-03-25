export class TimeDeposit {
  public planType: string
  public balance: number
  public days: number

  constructor(planType: string, balance: number, days: number) {
    this.planType = planType;
    this.balance = balance;
    this.days = days
  }
}

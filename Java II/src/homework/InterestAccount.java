package homework;

public class InterestAccount extends BankAccount{
	private double interest;
	public InterestAccount(String name, double money, double interest) {
		super(name, money);
		this.interest = interest;
	}
	public void addInterest() {
		deposit(interest * super.getMoney());
	}
	public double getInterest() {
		return interest;
	}
	public String toString() {
		return super.toString() + " and the interest rate is " + interest + "%";
	}
}

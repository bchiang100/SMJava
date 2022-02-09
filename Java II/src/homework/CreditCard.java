package homework;

public class CreditCard extends InterestAccount{
	public CreditCard(String name, double money, double interest) {
		super(name, money, interest);
	}
	public void addInterest() {
		if (getMoney() * (1 + getInterest()) >= 100) {
		super.addInterest();
		super.withdraw(10);
		} else {
			System.out.println("Insufficient money, please deposit more money first");
		}
	}
	public String toString() {
		return super.toString();
	}
}

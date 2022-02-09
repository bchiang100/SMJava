package homework;

public class GreatAccount extends BankAccount{
	private int withdrawalCount = 0;
	private int month = 1;
	public GreatAccount(String name, double money, double interest) {
		super(name, money);
	}
	public void nextMonth() {
		withdrawalCount = 0;
		month++;
		if (month == 13) {
			deposit(getMoney());
			System.out.println("Congrats for not withdrawing for a whole year! Your money is now DOUBLED!!!");
			month = 0;
		}
	}
	public void withdraw(double m) {
		if (withdrawalCount < 3) {
			super.withdraw(m);
			withdrawalCount++;
		} else {
			System.out.println("Unable to withdraw. You have already withdrawn 3 times this month");
		}
	}
	public String toString() {
		return super.toString();
	}
}

package homework;
import java.util.Scanner;

public class BankAccount {
	Scanner input = new Scanner(System.in);
	private String name;
	private double money;
	private double rate;
	private int action;
	private double changeMoney;
	
	public BankAccount () {
		System.out.println("What is your name?");
		this.name = input.nextLine();
		System.out.println("How much $ do you have?");
		this.money = input.nextDouble();
		System.out.println("What is the interest rate (out of 1)?");
		this.rate = input.nextDouble();
		System.out.println("Choose an action:\n1. Deposit\n2. Withdraw\n3. Add Interest");
		action = input.nextInt();
		if (action == 1) {
			System.out.println("How much $ do you want to deposit?");
			changeMoney = input.nextDouble();
			deposit(changeMoney);
			System.out.println("You now have $" + money);
		}
		if (action == 2) {
			System.out.println("How much $ do you want to withdraw?");
			changeMoney = input.nextDouble();
			withdraw(changeMoney);
			System.out.println("You now have $" + money);
		}
		if (action == 3) {
			addInterest();
			System.out.println("You now have $" + money);
		}
	}
	
	public void deposit(double m) {
		money+=m;
	}
	public void withdraw(double m) {
		money-=m;
	}
	public void addInterest() {
		money+=money*rate;
	}
	public String toString() {
		return name + "'s checkings account has a total of $" + money + " and the interest rate is " + rate + "%";
	}
	public static void main(String [] args) {
		BankAccount Kevin = new BankAccount();
		Kevin.deposit(5);
		System.out.println(Kevin);
	}
	
}

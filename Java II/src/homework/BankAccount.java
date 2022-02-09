package homework;
import java.util.Scanner;

public class BankAccount {
	Scanner input = new Scanner(System.in);
	private String name;
	private double money;
	
	public BankAccount (String name, double money) {
		this.name = name;
		this.money = money;
	}
	
	public void deposit(double m) {
		money+=m;
	}
	public void withdraw(double m) {
		money-=m;
	}
	public double getMoney() {
		return money;
	}
	
	public String toString() {
		return name + "'s checkings account has a total of $" + money;
	}
	public static void main(String [] args) {
		// I'm not sure why the toString from each class doesn't run. Shouldn't it automatically run everytime I call the class?
		BankAccount Kevin = new BankAccount("Lester", 362);
		GreatAccount Jake = new GreatAccount("Jake", 200, 0.07);
		InterestAccount Bryan = new InterestAccount("Bryan", 724, 0.06);
		CreditCard Leo = new CreditCard("Leo", 94, 0.06);
		Kevin.deposit(5);
		Jake.nextMonth();
		Jake.nextMonth();
		Jake.withdraw(1);
		Jake.nextMonth();
		Jake.nextMonth();
		Jake.nextMonth();
		Jake.nextMonth();
		Jake.withdraw(2);
		Jake.withdraw(3);
		Jake.nextMonth();
		Jake.nextMonth();
		Jake.nextMonth();
		Jake.withdraw(4);
		Jake.nextMonth();
		Jake.nextMonth();
		//Jake.nextMonth();
		Bryan.addInterest();
		Leo.addInterest();
		Jake.withdraw(6);
		Jake.withdraw(71);
		Jake.withdraw(18);
		Jake.nextMonth();
		Jake.withdraw(32);
	}
	
}

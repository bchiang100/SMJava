package homework;

public class Human {
	private int age;
	private int height;
	private String name;
	
	public Human (int age, int height, String name) {
		this.age = age;
		this.height = height;
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int newAge) {
		age = newAge;
	}
	public void getOlder() {
		age++;
	}
	public int getHeight() {
		return height;
	}
	public void getTaller() {
		height++;
	}
	public void changeName(String newName) {
		name = newName;
	}
	public String canVote(int electionYear) {
		if (electionYear % 4 == 0 && age >= 18) {
			return "This person can vote!";
		} else {
			return "This person cannot vote yet";
		}
	}
	public String toString() {
		return "My name is " + name + " , I am " + age + " years old, and I am " + " meters tall";
	}
	public static void main(String [] args) {
		Human j = new Human(8, 4, "John");
		j.getOlder();
		j.getAge();
		System.out.println(j);
	}
}

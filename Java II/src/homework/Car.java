package homework;

public class Car {
	private String name;
	private int year;
	private int mileage;
	private int distance;
	
	public Car(String name, int year, int mileage) {
		this.name = name;
		this.year = year;
		this.mileage = mileage;
	}
	public void drive(int distance) {
		this.distance = distance;
		mileage+=distance;
		System.out.println("The new mileage is now " + mileage + " miles");
	}
	public int worth() {
		return 30000 - ((2022 - year) * distance);
	}
	public int getMileage() {
		return mileage;
	}
	public String getName() {
		return name;
	}
	public int getYear() {
		return year;
	}
	
}

package homework;

public class Garage {
	private Car[] garage;
	private int totalWorth = 0;
	private int averageMileage = 0;
	
	public Garage(int n) {
		garage = new Car[n];
	}
	
	public void addCar(int i, String name, int year, int mileage) {
		garage[i] = new Car(name, year, mileage);
	}
	
	public void totalWorth() {
		for (Car car : garage) {
			if (car != null) {
				totalWorth += car.worth();
			}
		}
		System.out.println("The total worth is $" + totalWorth);
	}
	
	public void averageMileage() {
		for (Car car : garage) {
			if (car != null) {
				averageMileage += car.getMileage();
			}
		}
		averageMileage /= (garage.length);
		System.out.println("The average mileage is " + averageMileage + " miles");
	}
	
	public void drive(int i, int n) {
		garage[i].drive(n);
		System.out.println(garage[i].getName() + " has driven " + n + " miles");
	}
	
	public String toString(int i) {
		
		return garage[i].getName() + " is valued at $" + garage[i].worth() + ". It is bought in the year " + garage[i].getYear() + " and has a mileage of " + garage[i].getMileage() + " miles";
	
	}
	public static void main (String [] args) {
		Garage g = new Garage(4);
		g.addCar(0, "Chevy", 2019, 1000);
		g.addCar(1, "Honda", 2018, 1250);
		g.addCar(2, "Mercedes", 2021, 1500);
		g.drive(0, 100);
		g.drive(1, 200);
		g.drive(2, 150);
		g.totalWorth();
		g.averageMileage();
		g.toString(0);
	}
}

package homework;

public class Store {
	// number of TOTAL items in a store
	private int items;
	private int customers;
	private int employees;
	public Store(int items, int customers, int employees) {
		this.items = items;
		this.customers = customers;
		this.employees = employees;
	}
	public void restock() {
		items++;
	}
	public int getEmployees() {
		return employees;
	}
	public String toString() {
		return "This store has " + items + " items in stock, there are currently " + customers + " customers, and there are " + employees + " employees";
	}
	public static void main(String [] args) {
		ComputerRepairShop MicroCenter = new ComputerRepairShop("Jake", "Laptop", 1000, 10000, 15, 4, 5);
		MicroCenter.restock();
	}
}

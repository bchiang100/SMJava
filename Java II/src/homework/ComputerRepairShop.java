package homework;

public class ComputerRepairShop extends ElectronicsStore{
	private String repairman;
	public ComputerRepairShop(String repairman, String itemName, int price, int totalPrice, int items, int customers, int employees) {
		super(itemName, price, totalPrice, items, customers, employees);
		this.repairman = repairman;
	}
	public int changeRepairman(String newRepairman) {
		repairman = newRepairman;
		return super.getEmployees()+1;
	}
}

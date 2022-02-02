package homework;

public class ElectronicsStore extends Store{
	private String itemName;
	// the price of the item
	private int price;
	// the total price (price times the number of items) which is typed in by the user
	private int totalPrice;
	public ElectronicsStore(String itemName, int price, int totalPrice, int items, int customers, int employees) {
		super(items, customers, employees);
		this.itemName = itemName;
		this.totalPrice = totalPrice;
	}
	
	public void restock() {
		totalPrice += price;
		super.restock();
	}
	public void changeItemName(String newItemName) {
		itemName = newItemName;
	}
	public void changePrice(int newPrice) {
		price = newPrice;
	}
}

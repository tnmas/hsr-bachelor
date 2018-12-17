
public class Order {

	private final Item[] items;

	public Order(Item[] items) {
		this.items = items;
	}

	// Get Total Order Price
	public double getTotalPrice() {

		double total = 0;
		for (Item item : items) {
			total += item.getPrice();
		}
		return total;
	}
	
	//	Print Order Items
	public void printItems() {
	
		for (Item item : items) {
			item.print();
		}
	}
	
}

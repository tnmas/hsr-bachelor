
public class BundleItem extends Item {

	private double discount;
	private final Item[] items;

	public BundleItem(String description, double discount, Item[] items) {
		super(description);
		this.discount = discount;
		this.items = items;
	}
	
	// Get Items
	public Item[] getItems() {
		return items;
	}
	
	// Get Discount
	public double getDiscount() {
		return discount;
	}
	
	// Set Discount
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getPrice() {
		return getPrice();
	}

	// Get Total Bundle Item Price
	public double getTotalPrice() {

		double total = 0;
		for (Item item : items) {
			total += item.getPrice();
		}
		return total;
	}

	// Get the Discount of Total Bundle Item
	public double getTotalDiscount() {
		double totalPrice = getTotalPrice();
		return totalPrice - (totalPrice * discount / 100);
	}

	// Print Product Items
	public void printItems() {
		for (Item item : items) {
			item.print();
		}
	}

	

	@Override
	public void print() {
		System.out.println(getDescription());
		System.out.println(getPrice());
	}
}

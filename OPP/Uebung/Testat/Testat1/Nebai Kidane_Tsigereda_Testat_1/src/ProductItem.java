
public class ProductItem extends Item {
	private int amount;
	private double pricePerUnit;
	
	public ProductItem(String description, int amount, double pricePerUnit) {
		super(description);
		this.amount = amount;
		this.pricePerUnit = pricePerUnit;
	}

	// Get Product Item Amount
	public int getAmount() {
		return amount;
	}

	// Set Product Item Amount
	public void setAmount(int amount) {
		this.amount = amount;
	}

	// Get Product Item Price Per Unit
	public double getPricePerUnit() {
		return pricePerUnit;
	}

	// Set Product Item Price Per Unit
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	
	
	// Return Total Price of singular Product Item "same totalItemPrice()"
	@Override
	public double getPrice() {
		return pricePerUnit  * amount;
	}
	
	@Override
	public void print() {
		System.out.println("Description: " + getDescription());
		System.out.println("Amount: " + amount);
		System.out.println("Price: " + pricePerUnit);
	}
	
}


public abstract class Item {

	protected final String description;

	public Item(String description) {
		this.description = description;
		
	}

	// Get Item Price
	public abstract double getPrice();
	
	// Print Items
	public abstract void print();

	// Get Item Description
	public String getDescription() {
		return description;
	}

	

}

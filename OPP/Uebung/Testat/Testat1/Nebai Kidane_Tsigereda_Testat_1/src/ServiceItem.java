
public class ServiceItem extends Item {
	public double price;

	public ServiceItem(String description, double price) {
		super(description);
		this.price = price;
	}

	// Set Service Item Price
	public void setPrice(double price) {
		this.price = price;
	}

	

	// Get Service Item Price
	@Override
	public double getPrice() {
		return price;
	}

	//
	@Override
	public void print() {
		 System.out.println(description);
		 System.out.println(price);
	}


}

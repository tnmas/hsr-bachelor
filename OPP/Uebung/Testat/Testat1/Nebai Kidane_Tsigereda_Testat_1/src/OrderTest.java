
public class OrderTest {

	public static void main(String[] args) {
		ProductItem item1 = new ProductItem("Mouse", 5, 40);
		ServiceItem item2 = new ServiceItem("warranty", 10);
		ProductItem item3 = new ProductItem("Monitor", 2, 300);

		Order order = new Order(new Item[] { item1, item2, item3 });

		order.printItems();
		System.out.println("Total Price: " + order.getTotalPrice() + " CHF");
		
	}
}
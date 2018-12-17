
public class BundleItemTest {

	public static void main(String[] args) {
		ProductItem item1 = new ProductItem("Mouse", 3, 40);
		ServiceItem item2 = new ServiceItem("warranty", 10);
		ProductItem item3 = new ProductItem("Notebook", 2, 1100);

		
		BundleItem bundleItem = new BundleItem("", 10, new Item[] { item1, item2, item3 });
		
		bundleItem.printItems();
		
		System.out.println("Total Price: " + bundleItem.getTotalPrice() + " CHF");
		System.out.println("The price after " + bundleItem.getDiscount() + "% discount is "+ bundleItem.getTotalDiscount() + " CHF");
	}

}

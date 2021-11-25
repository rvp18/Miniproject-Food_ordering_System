
public class ShoppingCart {
	
	private items[] cart;
	private double totalprice;
	
	public ShoppingCart() {
		cart = new items[50];
		
	}
	public double calculateTotalPrice() {
		
		for (int i=0;i<cart.length;i++) {
			
			totalprice+= cart[i].getTotalprice();
			
		}
		return totalprice;
	}

}

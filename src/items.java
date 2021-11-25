
public class items {
	private String name;
	private double totalprice;
	private int quantity;
	
	
	public items(String name,int quantity ,double unitprice) {
		
		this.name=name;
		this.quantity=quantity;
		totalprice = quantity*unitprice;
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getTotalprice() {
		return totalprice;
	}


	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	
	
	
	

}

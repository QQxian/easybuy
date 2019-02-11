package vo;

public class Cart {
	private int id;
	private int orderId;
	private int productId;
	private int quantity;  //数量
	private double cost;   			//小计消费
	private int state;
	private int userI;
	
	
	private Cart1 cart;
	
	

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserI() {
		return userI;
	}
	public void setUserI(int userI) {
		this.userI = userI;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cart1 getCart() {
		return cart;
	}
	public void setCart(Cart1 cart) {
		this.cart = cart;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}

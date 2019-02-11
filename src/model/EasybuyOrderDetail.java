package model;

public class EasybuyOrderDetail {
    private Integer id;

    private Integer orderid;

    private Integer productid;

    private Integer quantity;

    private Double cost;

    private Integer type;

    private Integer state;

    private Integer useri;
    
    
    
    public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getUseri() {
		return useri;
	}

	public void setUseri(Integer useri) {
		this.useri = useri;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }



    public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Integer getType() {
        return type;
    }

    public Integer setType(Integer type) {
        this.type = type;
        return type;
    }
}
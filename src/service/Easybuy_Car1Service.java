package service;

import java.util.List;

import model.EasybuyOrder;
import model.EasybuyOrderDetail;
import model.EasybuyProduct;
import model.EasybuyUser;
import vo.Cart;
import vo.Cart1;

public interface Easybuy_Car1Service {
	public boolean del(Integer id);
	public List<Cart> list(Cart cart) ;
	public List<EasybuyOrderDetail> selectDetail(EasybuyOrderDetail easybuyOrderDetail) ;
	public List<EasybuyOrderDetail> list2();
//	
	public int selectOrderId(int userI);
	
	public EasybuyOrderDetail update(EasybuyOrderDetail easybuyOrderDetail);
	
	public EasybuyOrderDetail UpdateQ(EasybuyOrderDetail easybuyOrderDetail);
	
	public EasybuyOrderDetail UpdateOrdreId(EasybuyOrderDetail easybuyOrderDetail);
	
	public EasybuyOrderDetail stateUpdate(EasybuyOrderDetail easybuyOrderDetail);
	public EasybuyOrderDetail add(EasybuyOrderDetail easybuyOrderDetail) ;
	
	public EasybuyProduct select(Integer id) ;
	
//	public EasybuyOrder selectOrder(Integer id);
		
	public EasybuyUser selectUser(String loginName);
	

}

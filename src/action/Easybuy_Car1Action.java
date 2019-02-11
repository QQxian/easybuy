package action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.EasybuyOrder;
import model.EasybuyOrderDetail;
import model.EasybuyProduct;
import model.EasybuyUser;
import service.Easybuy_Car1Service;
import vo.Cart;
import vo.Msg;

@Controller

public class Easybuy_Car1Action {
	@Resource
	private Easybuy_Car1Service easybuy_Car1Service;
	
	@RequestMapping("jia.do")
	@ResponseBody
	public Msg add( Model model) {
		Msg msg = new Msg();
		return msg;
	}
	@RequestMapping("jian.do")
	@ResponseBody
	public Msg jj( Model model) {
		Msg msg = new Msg();
		return msg;
	}
	
	@RequestMapping("/shopping_Cart.do")
	public String list(HttpServletRequest request, Model model) {
		Cart cart=new Cart();
		EasybuyUser easybuyUser =(EasybuyUser)request.getSession().getAttribute("loginUser");
		List<Cart> list = null;
		if(easybuyUser !=null){
			 int userId=easybuy_Car1Service.selectUser(easybuyUser.getLoginname()).getId();			
//			 EasybuyOrder easybuyOrder = easybuy_Car1Service.selectOrder(userId);
//			 if (easybuyOrder != null) {
//				 int orderId=easybuyOrder.getId();
//				 cart.setOrderId(orderId);
//				 list = easybuy_Car1Service.list(cart);
//			 }		
			 cart.setUserI(userId);
			 list = easybuy_Car1Service.list(cart);
		}
		 
		model.addAttribute("list" , list);
		return "shopping_Cart";
	}
	
	@RequestMapping("doDel.do")
	@ResponseBody
	public Msg del(Integer id , Model model) {
		boolean isSuc = easybuy_Car1Service.del(id);
		Msg msg = new Msg();
		if(isSuc) {
			msg.setCode(0);
		} else {
			msg.setCode(1);
		}
		return msg;
	}
	@RequestMapping("up.do")
	@ResponseBody
	public Object up(Integer id,Integer quantity,Double  cost) {
		EasybuyOrderDetail easybuyOrderDetail = new EasybuyOrderDetail();
		easybuyOrderDetail.setId(id);
		easybuyOrderDetail.setQuantity(quantity);
		easybuyOrderDetail.setCost(cost);
		easybuy_Car1Service.update(easybuyOrderDetail);
		return null;
		
	}
	
	@RequestMapping("stateUp.do")
	@ResponseBody
	public Object upp(Integer userI,HttpServletRequest request) {
		EasybuyOrderDetail easybuyOrderDetail = new EasybuyOrderDetail();
		EasybuyOrderDetail easybuyOrderDetail2 = new EasybuyOrderDetail();
		EasybuyOrderDetail easybuyOrderDetail3 = new EasybuyOrderDetail();
		
		easybuyOrderDetail.setUseri(userI);
		easybuy_Car1Service.stateUpdate(easybuyOrderDetail);
		
		EasybuyUser easybuyUser =(EasybuyUser)request.getSession().getAttribute("loginUser");
		int userId=easybuy_Car1Service.selectUser(easybuyUser.getLoginname()).getId();	
//		easybuyOrderDetail2.setUseri(userId);
		int num  = easybuy_Car1Service.selectOrderId(userId);
		
//		int num=0;
//		for(EasybuyOrderDetail a:list){
//			num=a.getOrderid();
//			break;
//		}
		num++;
		easybuyOrderDetail3.setOrderid(num);
		easybuyOrderDetail3.setUseri(userId);
		easybuy_Car1Service.UpdateOrdreId(easybuyOrderDetail3);
		int nun  = easybuy_Car1Service.selectOrderId(userId);
		return "car2.do?orderId="+num;
	}
	
	@RequestMapping("ad.do")	
	public String add(Integer id,HttpServletRequest request) {	
		EasybuyOrderDetail easybuyOrderDetail = new EasybuyOrderDetail();	
		EasybuyOrderDetail easybuyOrderDetail2 = new EasybuyOrderDetail();
		EasybuyOrderDetail easybuyOrderDetail3 = new EasybuyOrderDetail();
		EasybuyUser easybuyUser =(EasybuyUser)request.getSession().getAttribute("loginUser");
		int userId=easybuy_Car1Service.selectUser(easybuyUser.getLoginname()).getId();		
		EasybuyProduct easybuyProduct=easybuy_Car1Service.select(738);
		
		int b=734;
		easybuyOrderDetail2.setUseri(userId);
		List<EasybuyOrderDetail> list = easybuy_Car1Service.selectDetail(easybuyOrderDetail2);
			for(EasybuyOrderDetail a:list){
				int Pro=a.getProductid();
				int oo=a.getQuantity();
				if(b==Pro){
					oo++;
					easybuyOrderDetail3.setUseri(userId);
					easybuyOrderDetail3.setProductid(b);
					easybuyOrderDetail3.setQuantity(oo);
					easybuy_Car1Service.UpdateQ(easybuyOrderDetail3);
					return "shopping_Cart";
				}
			}
			
			int i=1;
			easybuyOrderDetail.setQuantity(i);	
			easybuyOrderDetail.setProductid(b);		
			easybuyOrderDetail.setOrderid(0);				
			easybuyOrderDetail.setState(0);
			easybuyOrderDetail.setUseri(userId);

			String num = String.valueOf(easybuyProduct.getPrice());
			easybuyOrderDetail.setCost(Double.valueOf(num));	
			easybuy_Car1Service.add(easybuyOrderDetail);
	
			return "shopping_Cart";
	}
	
}

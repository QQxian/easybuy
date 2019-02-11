package action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import model.EasybuyOrder;
import model.EasybuyOrderDetail;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.EasybuyCar23Service;
@Controller
public class EasybuyCar23Action {
	@Resource
	private EasybuyCar23Service  easybuyCar2Service;
	@RequestMapping("/car2.do")
	public String list(Integer page , Integer orderid,Integer type ,Model model) {
		if (page == null || page < 1) {
			page = 1;
		}
		
		long total = easybuyCar2Service.count();
		
		long totalPage = total % 4 == 0 ? total / 4 : (total / 4) + 1;
		if (page > totalPage) {
			page = (int)totalPage;
		}
		orderid=1;
		double totalcost=0;
		if(orderid!=null){
			List<EasybuyOrderDetail> list = easybuyCar2Service.list(page,orderid);
			for(EasybuyOrderDetail e:list){
				if(e.getType().equals(1)){
					type=e.getType();
					model.addAttribute("type" , type);
					model.addAttribute("orderid", orderid);
					break;
				}else{
					totalcost=  e.getCost()+totalcost;
					type=e.getType();
					model.addAttribute("type" , type);
					model.addAttribute("list" , list);
					model.addAttribute("page", page);
					model.addAttribute("totalPage", totalPage);
					model.addAttribute("totalcost", totalcost);
					model.addAttribute("orderid", orderid);
				}
			}
			
		}
		

		return "car/car2";
	}	
	@RequestMapping("/car3add.do")
	public String add( String userid,String loginname,String useraddress,Date createtime,String cost, Integer orderid,Model model){
	//	if(userid!=null&&cost!=null&&useraddress!=null&&!userid.trim().equals("")&&!cost.trim().equals("")){
//			int uid = Integer.parseInt(userid);
//			float cs = Integer.parseInt(cost);
			long number=(long)((Math.random()*9+1)*1000000000);
			List<EasybuyOrder> list = easybuyCar2Service.list();
			for (EasybuyOrder i:list) {
				if(i.getSerialnumber()==number){
					 number=(int)((Math.random()*9+1)*1000000000);
			}
			System.out.println("大家啊哦"+number);
			EasybuyOrder easybuyOrder = new EasybuyOrder();
			int uid=2;
			float cs=33f;
		//	String serialnumber="944646444";
			String useraddressa= "喊打喊杀";
			String ln="dd";
			easybuyOrder.setUserid(uid);
			easybuyOrder.setLoginname(ln);
			easybuyOrder.setUseraddress(useraddressa);
			easybuyOrder.setCreatetime(new Date());
			easybuyOrder.setCost(cs);
			easybuyOrder.setSerialnumber(number);
			if(easybuyCar2Service.add(easybuyOrder)){
				System.out.println("成功 ");
				List<EasybuyOrderDetail> typelist = easybuyCar2Service.detailtype(orderid);
				for (EasybuyOrderDetail easybuyOrderDetail:typelist) {
					easybuyOrderDetail.setType(1);
					easybuyCar2Service.state(easybuyOrderDetail);
				}
				model.addAttribute("sn",number);
				model.addAttribute("cs",cs);
				System.out.println(easybuyOrder.getId()+"你好啊");
				return "redirect:car3.do";
			}
		}
		return "car/car3";
		}
	@RequestMapping(value="/car3.do")
	public String car3(){
		return "car/car3";		
	}
	@RequestMapping(value="/order.do")
	public String order(Double cost,Integer orderid){
		
		return "car/car2";		
	}
	
	}

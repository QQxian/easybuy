
package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import model.EasybuyProduct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.IndexService;
import vo.EasybuyAll;

@Controller
public class IndexAction {
	@Resource
	private IndexService indexService;
	@RequestMapping("/proList.do")
	public String list(Integer page ,String name, String orderby, Model model) {
		if (page == null || page < 1) {
			page = 1;
		}

		if(orderby!=null&&!orderby.equals("")){
			if(orderby.equals("asc")){
				model.addAttribute("orderby","desc");
				model.addAttribute("reorder","asc");
			}else {
				model.addAttribute("orderby","asc");
				model.addAttribute("reorder","desc");
			}
		}else{
			model.addAttribute("orderby","asc");
		}
		long total = indexService.count(name);
		
		long totalPage = total % 8 == 0 ? total / 8 : (total / 8) + 1;
		if (page > totalPage) {
			page = (int)totalPage;
		}
		List<EasybuyProduct> list = indexService.list(page , name , orderby);
//		if(list!=null&&list.size()>0){
			model.addAttribute("list" , list);
//		}else{
//			
//		}
		List<EasybuyAll> list2 = indexService.list2();
		model.addAttribute("list2" , list2);	
		
		model.addAttribute("page", page);
		model.addAttribute("total", total);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("name" , name);
		
		return "product/proList";
	}
	
	@RequestMapping("/orderList.do")
	@ResponseBody
	public Object orderList(String orderby) {
		Map<String, Object> map=new HashMap<String, Object>();
		if(orderby!=null&&!orderby.equals("")){
			if(orderby.equals("asc")){
				map.put("order","desc");
			}else {
				map.put("order","asc");
			}
		}else{
			map.put("order","asc");
		}
		return map;
	}
	
	@RequestMapping("/add.do")
	public String add(Integer id,Model model) {
		EasybuyProduct easybuyProduct=indexService.findProById(id);
		Integer ids=easybuyProduct.getId();
		String name=easybuyProduct.getName();
		Float price=easybuyProduct.getPrice();
		String fileName=easybuyProduct.getFilename();
		model.addAttribute("name", name);
		model.addAttribute("ids", ids);
		model.addAttribute("fileName", fileName);
		model.addAttribute("price", price);
		return "cardList";
		
	}
}

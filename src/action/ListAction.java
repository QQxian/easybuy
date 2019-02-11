package action;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import model.EasybuyProduct;
import model.EasybuyProductCategory;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.EasybuyProductCategoryService;
import service.EasybuyProductService;

@Controller
public class ListAction {
	@Resource
	private EasybuyProductCategoryService departmentService;
	@Resource
	private EasybuyProductService easybuyProductServic;
	// @Resource
	// private EnterpriseTalentService enterpriseTalentService;

	@RequestMapping("/index.do")
	public String list(Integer id, Model model) {
		
		EasybuyProductCategory pas=new EasybuyProductCategory();
		pas.setType(1);
		List<EasybuyProductCategory> newsDetail1 = departmentService.list3(pas);
		pas.setType(2);
		List<EasybuyProductCategory> newsDetail2 = departmentService.list3(pas);
		pas.setType(3);
		List<EasybuyProductCategory> newsDetail3 = departmentService.list3(pas);
		model.addAttribute("newsDetail1", newsDetail1);
		model.addAttribute("newsDetail2", newsDetail2);
		model.addAttribute("newsDetail3", newsDetail3);
//		int index[]=new int[9];
//		for(int i=0; i<newsDetail1.size();i++){
//			index[i] =newsDetail1.get(i).getId();
//		}
//		for(int x=0;x<index.length;x++){
//			System.out.println(index[x]);
//		}
//		model.addAttribute("index",index);
		List<EasybuyProduct> newsDetai = easybuyProductServic.list2(
				);
		
//		
//		List<EasybuyProductCategory> newsDetail = departmentService.list1();
//
	model.addAttribute("newsDetai", newsDetai);
		return "Index";

	}

}
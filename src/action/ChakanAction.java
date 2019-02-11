package action;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import model.EasybuyProduct;
import model.EasybuyProductCategory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.EasybuyProductCategoryService;
import service.EasybuyProductService;

@Controller

public class ChakanAction {
	@Resource
	private EasybuyProductService easybuyProductServic;
	@Resource
	private EasybuyProductCategoryService departmentService;

	@RequestMapping("/chakan.do")
	public String chakan(String name, HttpServletRequest request, Integer page,
			Model model, Integer id,Integer categorylevel2id) throws Exception {
		//name = new String(name.getBytes("ISO-8859-1"),"utf-8");	
		String rootPath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + "/"
				+ request.getContextPath() + "/files/";

		if (page == null || page < 1) {
			page = 1;
		}
		int total = easybuyProductServic.count(name,id,categorylevel2id);
		int totalPage = total % 8 == 0 ? total / 8 : (total / 8) + 1;
		if (page > totalPage && totalPage != 0) {
			page = totalPage;
		}
		List<EasybuyProduct> newsDetail = easybuyProductServic.list(page, name,
				id,categorylevel2id);

		// һ������
		int a = 1;
		
		List<EasybuyProductCategory> newsDe = departmentService
				.list2(a);

		if (newsDetail == null || newsDetail.size() <= 0) {
			model.addAttribute("newsDetail", null);
		} else {
			model.addAttribute("newsDetail", newsDetail);
		}
		int aa = newsDetail.size();
		System.out.println(aa + "----------------------------->");
		model.addAttribute("newsDe", newsDe);
		model.addAttribute("id", id);
		model.addAttribute("name",name);
		//model.addAttribute("categorylevel2id",categorylevel2id);
		
		model.addAttribute("aa", aa);
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
		
		
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

		return "chakan2";
	}


}

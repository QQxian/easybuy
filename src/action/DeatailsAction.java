package action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.EasybuyProduct;
import model.EasybuyProductCategory;
import service.DeatailsService;
import service.EasybuyProductService;

@Controller

public class DeatailsAction {
	@Resource
	private DeatailsService deatailsService;
	
	@RequestMapping("/dratails.do")
	public String dratails(Model model) {
		int id = 739;
		EasybuyProduct easybuyProduct =  deatailsService.select(id);
		model.addAttribute("easybuyProduct", easybuyProduct);
		return "Details/Product";
	}
}

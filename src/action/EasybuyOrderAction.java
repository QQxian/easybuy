package action;

import java.util.List;

import javax.annotation.Resource;

import mapper.EasybuyOrderMapper;
import model.EasybuyOrder;
import model.EasybuyOrderExample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.EasybuyorderService;
import vo.Msg;

@Controller
public class EasybuyOrderAction {
	@Resource
	private EasybuyorderService easybuyorderService;
	

	@RequestMapping("/settlement1.do")
	public String commodity(Model model, String name, Integer page) {
		if (page == null || page < 1) {
			page = 1;
		}
		int total = easybuyorderService.count(name);
		int totalpage = total % 6 == 0 ? total / 6 : (total / 6) + 1;
		if (page > totalpage) {
			page = (int) totalpage;
		}
		List<EasybuyOrder> list = easybuyorderService.list(name, page);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("totalpage", totalpage);
		return "settlement1";

	}
	
	
	@RequestMapping("/de.do")
	@ResponseBody
	public Msg del(Integer id) {
		Boolean src = easybuyorderService.dele(id);
		Msg msg = new Msg();
		if (src) {
			msg.setCode(0);
		} else {
			msg.setCode(1);
		}
		return msg;

	}

}
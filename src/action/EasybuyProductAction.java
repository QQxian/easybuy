package action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import model.EasybuyProduct;
import model.EasybuyProductCategory;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import service.EasybuyProductService;
import vo.Msg;

@Controller
@RequestMapping("/backSp")
public class EasybuyProductAction {
	@Resource
	private EasybuyProductService easybuyProductService;

	private Integer i1 = 1;
	private Integer i2 = 2;
	private Integer i3 = 3;

	@RequestMapping("/commodity.do")
	public String commodity(Integer page, String name, Model model) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (name == null || name.trim().equals("")) {
			name = null;
		}
		long total = easybuyProductService.count(name);
		long totalPage = total % 5 == 0 ? total / 5 : (total / 5) + 1;
		if (page > totalPage) {
			page = (int) totalPage;
		}
		if (total > 0) {
			List<EasybuyProduct> list = easybuyProductService.list(page, name);
			model.addAttribute("list", list);
		} else {
			model.addAttribute("list", null);
		}
		List<EasybuyProductCategory> list1 = easybuyProductService.list2(i1);
		model.addAttribute("list1", list1);
		List<EasybuyProductCategory> list2 = easybuyProductService.list2(i2);
		model.addAttribute("list2", list2);
		List<EasybuyProductCategory> list3 = easybuyProductService.list2(i3);
		model.addAttribute("list3", list3);
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("name", name);
		return "back/commodity";
	}

	@RequestMapping("/bumen.do")
	public String bumen(Model model) {
		List<EasybuyProductCategory> list1 = easybuyProductService.list2(i1);
		model.addAttribute("list1", list1);
		return "back/insertCommodity";
	}

	@RequestMapping("/insert.do")
	@ResponseBody
	public Map<String, Object> insert(String name, String price, String stock,
			String categoryLevel1Id, String categoryLevel2Id,
			String categoryLevel3Id, String content, String fileName,
			HttpServletRequest request, Model model) {

//		String sre = request.getParameter("content").trim();

		EasybuyProduct easybuyProduct = new EasybuyProduct();
		easybuyProduct.setName(name);
		easybuyProduct.setDescription(content);
		easybuyProduct.setPrice(Float.valueOf(price));
		easybuyProduct.setStock(Integer.valueOf(stock));
		easybuyProduct.setCategorylevel1id(Integer.valueOf(categoryLevel1Id));
		easybuyProduct.setCategorylevel2id(Integer.valueOf(categoryLevel2Id));
		easybuyProduct.setCategorylevel3id(Integer.valueOf(categoryLevel3Id));
		easybuyProduct.setFilename(fileName);
		boolean boo = easybuyProductService.insert(easybuyProduct);
		// int id = easybuyProductService.selectName().getId();
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("boo", boo);
		// map.put("id", id);
		return map;
	}

	@RequestMapping("/update.do")
	public String update(Integer id, Model model) {
		EasybuyProduct easybuyProduct = easybuyProductService.select(id);
		Integer id1 = easybuyProduct.getCategorylevel1id();
		Integer id2 = easybuyProduct.getCategorylevel2id();
		Integer id3 = easybuyProduct.getCategorylevel3id();
		String name1 = easybuyProductService.selectCategory(id1).getName();
		String name2 = easybuyProductService.selectCategory(id2).getName();
		String name3 = easybuyProductService.selectCategory(id3).getName();
		model.addAttribute("name1", name1);
		model.addAttribute("name2", name2);
		model.addAttribute("name3", name3);
		model.addAttribute("easybuyProduct", easybuyProduct);
		model.addAttribute("id", id);
		return "back/updateCommodity";
	}

	@RequestMapping("/updateAA.do")
	@ResponseBody
	public Msg updateAA(Integer id, String name, String description,
			String price, String stock, Model model) {
		EasybuyProduct easybuyProduct = new EasybuyProduct();
		easybuyProduct.setId(id);
		easybuyProduct.setName(name);
		easybuyProduct.setDescription(description);
		easybuyProduct.setPrice(Float.valueOf(price));
		easybuyProduct.setStock(Integer.valueOf(stock));
		boolean boo = easybuyProductService.update(easybuyProduct);
		Msg msg = new Msg();
		if (boo) {
			msg.setCode(0);
		} else {
			msg.setCode(1);
		}
		return msg;
	}

	@RequestMapping("/upload.do")
	public String upload(Integer id, Model model) {
		// model.addAttribute("id", id);
		return "back/uploadCommodity";
	}

	@RequestMapping("/doUpload.do")
	public String doUpload(Integer id, MultipartFile file,
			HttpServletRequest request, Model model) {
		String path = request.getSession().getServletContext()
				.getRealPath("/files");
		EasybuyProduct easybuyProduct = new EasybuyProduct();
		easybuyProduct.setId(id);
		String filetype = file.getOriginalFilename().substring(
				file.getOriginalFilename().lastIndexOf(".") + 1);
		long cur = System.currentTimeMillis();
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
					path + File.separator + cur + "." + filetype));
		} catch (IOException e) {
			e.printStackTrace();
		}
		easybuyProduct.setFilename(cur + "." + filetype);
		if (easybuyProductService.update(easybuyProduct)) {
			return "back/successful";
		}
		// EasybuyProductPhoto ePhoto = new EasybuyProductPhoto();
		// ePhoto.setPhoto1(cur + "." + filetype);
		// if (easybuyProductService.update(ePhoto)) {
		// return "back/successful";
		// }
		return "back/uploadCommodity";
	}

	@RequestMapping("/delete.do")
	@ResponseBody
	public Msg del(Integer id, Model model) {
		boolean newsDetail = easybuyProductService.deleteNewsDatail(id);
		Msg msg = new Msg();
		if (newsDetail) {
			msg.setCode(0);
		} else {
			msg.setCode(1);
		}
		return msg;
	}

	// @RequestMapping("/list.do")
	// public String list(Integer id , Model model) {
	// List<EasybuyOrderDetail> list = easybuyProductService.list();
	// model.addAttribute("list" , list);
	//
	// return "shopping_Cart";
	// }
	// @RequestMapping("/shopping_Cart.do")
	// public String commodity2(){
	// return "shopping_Cart";
	// }

	@RequestMapping("/indexBack.do")
	public String indexBack(Integer id, Model model) {
		model.addAttribute("id", id);
		return "back/index";
	}

	@RequestMapping("/name1.do")
	@ResponseBody
	public Map<String, Object> name1(String name, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EasybuyProductCategory> list2 = easybuyProductService.list3(i2,
				name);
		String str = String.valueOf(list2.get(0).getId());
		List<EasybuyProductCategory> list3 = easybuyProductService.list3(i3,
				str);
		if (list2.size() > 0) {
			map.put("list2", list2);
		} else {
			map.put("list2", null);
		}
		if (list3.size() > 0) {
			map.put("list3", list3);
		} else {
			map.put("list3", null);
		}
		return map;
	}

	@RequestMapping("/name2.do")
	@ResponseBody
	public Map<String, Object> name2(String name, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EasybuyProductCategory> list3 = easybuyProductService.list3(i3,
				name);
		if (list3.size() > 0) {
			map.put("list3", list3);
		} else {
			map.put("list3", null);
		}
		return map;
	}

	@RequestMapping("/dUpload.do")
	@ResponseBody
	public Map<String, Object> dUpload(MultipartFile file,
			HttpServletRequest request, Model model) {
		String path = request.getSession().getServletContext()
				.getRealPath("/files");
		// EasybuyProduct easybuyProduct = new EasybuyProduct();
		// easybuyProduct.setId(id);
		String filetype = file.getOriginalFilename().substring(
				file.getOriginalFilename().lastIndexOf(".") + 1);
		long cur = System.currentTimeMillis();
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
					path + File.separator + cur + "." + filetype));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		// easybuyProduct.setFilename(cur + "." + filetype);
		// if (easybuyProductService.update(easybuyProduct)) {
		// map.put("bool", true);
		// } else {
		// map.put("bool", false);
		// }
		// EasybuyProductPhoto ePhoto = new EasybuyProductPhoto();
		// ePhoto.setPhoto1(cur + "." + filetype);
		// if (easybuyProductService.update(ePhoto)) {
		// return "back/successful";
		// }
		String name = cur + "." + filetype;
		map.put("name", name);
		return map;
	}
}

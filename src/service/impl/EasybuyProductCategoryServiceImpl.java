package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import mapper.EasybuyProductCategoryMapper;
import model.EasybuyProductCategory;
import model.EasybuyProductCategoryExample;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.EasybuyProductCategoryService;

@Service
@Transactional
public class EasybuyProductCategoryServiceImpl implements
		EasybuyProductCategoryService {
	@Resource
	private EasybuyProductCategoryMapper easybuyProductCategory;

	@Override
	public List<EasybuyProductCategory> list1() {
		EasybuyProductCategoryExample easybuyProductCategoryExample = new EasybuyProductCategoryExample();

		return easybuyProductCategory
				.selectByExample(easybuyProductCategoryExample);
	}

	@Override
	public List<EasybuyProductCategory> list2(Integer type) {
		EasybuyProductCategoryExample easybuyProductCategoryExample = new EasybuyProductCategoryExample();
		if (type != null && type != 0) {
			easybuyProductCategoryExample.createCriteria().andTypeEqualTo(type);
		}
		return easybuyProductCategory
				.selectByExample(easybuyProductCategoryExample);
	}

	@Override
	public List<EasybuyProductCategory> list3(EasybuyProductCategory nasybuy) {
		EasybuyProductCategoryExample easybuyProductCategoryExample = new EasybuyProductCategoryExample();

		easybuyProductCategoryExample.createCriteria().andTypeEqualTo(
				nasybuy.getType());
		return easybuyProductCategory
				.selectByExample(easybuyProductCategoryExample);
	}

	@Override
	public EasybuyProductCategory getById(Integer id) {
		// EasybuyProductCategoryExample easybuyProductCategoryExample = new
		// EasybuyProductCategoryExample();
		EasybuyProductCategory EasybuyProductCategory = easybuyProductCategory
				.selectByPrimaryKey(id);
		return EasybuyProductCategory;
	}

	
}

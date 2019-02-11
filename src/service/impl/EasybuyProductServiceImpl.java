package service.impl;

import java.util.List;

import javax.annotation.Resource;




import mapper.EasybuyOrderDetailMapper;
import mapper.EasybuyOrderMapper;
import mapper.EasybuyProductCategoryMapper;
import mapper.EasybuyProductMapper;
import mapper.EasybuyProductPhotoMapper;
import model.EasybuyOrderDetail;
import model.EasybuyOrderDetailExample;
import model.EasybuyProduct;
import model.EasybuyProductCategory;
import model.EasybuyProductCategoryExample;
import model.EasybuyProductExample;
import model.EasybuyProductPhoto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.EasybuyProductService;

@Service
@Transactional
public class EasybuyProductServiceImpl implements EasybuyProductService {
	@Resource
	private EasybuyOrderDetailMapper easybuyOrderDetailMapper;
	@Resource
	private EasybuyOrderMapper easybuyOrderMapper;
	
	@Resource
	private EasybuyProductMapper easybuyProductMapper;
	@Resource
	private EasybuyProductCategoryMapper easybuyProductCategoryMapper;
	@Resource
	private EasybuyProductPhotoMapper easybuyProductPhotoMapper;
	
	public List<EasybuyProduct> list(int page, String name) {
		EasybuyProductExample easybuyProductExample = new EasybuyProductExample();
		if (name != null && !name.trim().equals("")) {
			easybuyProductExample.createCriteria()
					.andNameLike("%" + name + "%");
		}
		easybuyProductExample.setOrderByClause("id");
		easybuyProductExample.setLimit(5);
		easybuyProductExample.setOffset((page - 1) * 5);
		return easybuyProductMapper.selectByExample(easybuyProductExample);
	}

	public long count(String name) {
		EasybuyProductExample easybuyProductExample = new EasybuyProductExample();
		if (name != null && !name.trim().equals("")) {
			easybuyProductExample.createCriteria()
					.andNameLike("%" + name + "%");
		}
		return easybuyProductMapper.countByExample(easybuyProductExample);
	}

	@Override
	public boolean insert(EasybuyProduct easybuyProduct) {
		int i = easybuyProductMapper.insertSelective(easybuyProduct);
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public EasybuyProduct select(Integer id) {
		return easybuyProductMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean update(EasybuyProduct easybuyProduct) {
		int i = easybuyProductMapper.updateByPrimaryKeySelective(easybuyProduct);
		if (i == 1) {
			return true;
		} else {
			return false;
		}		
	}

	@Override
	public boolean deleteNewsDatail(Integer id) {
		easybuyProductMapper.deleteByPrimaryKey(id);
		return true;
	}

	@Override
	public List<EasybuyProductCategory> list2(Integer i) {
		EasybuyProductCategoryExample easybuyProductCategoryExample = new EasybuyProductCategoryExample();
		easybuyProductCategoryExample.createCriteria().andTypeEqualTo(i);
		return easybuyProductCategoryMapper.selectByExample(easybuyProductCategoryExample);
	}

	@Override
	public List<EasybuyProductCategory> list3(Integer i, String name) {
		EasybuyProductCategoryExample easybuyProductCategoryExample = new EasybuyProductCategoryExample();
		if (name != null && !name.equals("")) {
			easybuyProductCategoryExample.createCriteria().andTypeEqualTo(i).andParentidEqualTo(Integer.valueOf(name));
		} else {
			easybuyProductCategoryExample.createCriteria().andTypeEqualTo(i);
		}
		return easybuyProductCategoryMapper.selectByExample(easybuyProductCategoryExample);
	}

	@Override
	public EasybuyProductCategory selectCategory(Integer id1) {
		return easybuyProductCategoryMapper.selectByPrimaryKey(id1);
	
	}
	@Override
	public List<EasybuyProduct> list(int page, String name, Integer id,Integer categorylevel2id ) {
		

		EasybuyProductExample easybuyProductExample = new EasybuyProductExample();
		easybuyProductExample.setLimit(8);
		easybuyProductExample.setOffset((page - 1) * 8);
		if (id != null && id != 0) {
			easybuyProductExample.createCriteria().andCategorylevel1idEqualTo(
					id);
		}
		if (categorylevel2id != null && categorylevel2id != 0) {
			easybuyProductExample.createCriteria().andCategorylevel2idEqualTo(
					categorylevel2id);
		}
		if (name != null && !name.trim().equals("")) {
			easybuyProductExample.createCriteria()
					.andNameLike("%" + name + "%");
		}
		return easybuyProductMapper.selectByExample(easybuyProductExample);
	}

	@Override
	public int count(String name, Integer id,Integer categorylevel2id ) {
		EasybuyProductExample easybuyProductExample = new EasybuyProductExample();
		if (id != null && id != 0) {
			easybuyProductExample.createCriteria().andCategorylevel1idEqualTo(
					id);
		}
		if (name != null && !name.trim().equals("")) {
			easybuyProductExample.createCriteria()
					.andNameLike("%" + name + "%");
		}
		if (categorylevel2id != null && categorylevel2id != 0) {
			easybuyProductExample.createCriteria().andCategorylevel2idEqualTo(
					categorylevel2id);
		}
		return (int) easybuyProductMapper.countByExample(easybuyProductExample);
	}

	@Override
	public List<EasybuyProduct> list2() {
		EasybuyProductExample easybuyProductExample = new EasybuyProductExample();
		
		
		return easybuyProductMapper.selectByExample(easybuyProductExample);
	}

}

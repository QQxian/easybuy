package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mapper.EasybuyOrderDetailMapper;
import mapper.EasybuyOrderDoMapper;
import mapper.EasybuyProductMapper;
import model.EasybuyOrderDetail;
import model.EasybuyOrderDetailExample;
import model.EasybuyOrderDoExample;
import model.EasybuyProduct;
import model.EasybuyProductExample;
import service.IndexService;
import vo.EasybuyAll;

@Service
@Transactional
public class IndexServiceImpl implements IndexService {
	
	@Resource
	private EasybuyProductMapper easybuyProductMapper;
	
	@Resource
	private EasybuyOrderDoMapper easybuyOrderDoMapper;
	
	@Resource
	private EasybuyOrderDetailMapper easybuyOrderDetailMapper;
	
	public List<EasybuyProduct> list(int page , String name ,String orderby) {
		EasybuyProductExample easybuyProductExample = new EasybuyProductExample();
		if (name != null && !name.trim().equals("")) {
			easybuyProductExample.createCriteria().andNameLike("%"+name+"%");
		}
		if(orderby!=null&&!orderby.equals("")){
			easybuyProductExample.setOrderByClause("price "+orderby);
		}
		easybuyProductExample.setLimit(8);
		easybuyProductExample.setOffset((page - 1) * 8);
		return easybuyProductMapper.selectByExample(easybuyProductExample);
	}
	public long count(String name) {
		EasybuyProductExample easybuyProductExample = new EasybuyProductExample();
		if (name != null && !name.trim().equals("")) {
			easybuyProductExample.createCriteria().andNameLike("%"+name+"%");
		}
		return easybuyProductMapper.countByExample(easybuyProductExample);
	}
	public EasybuyProduct findProById(Integer id) {
		return easybuyProductMapper.selectByPrimaryKey(id);
	}
	
	public List<EasybuyAll> list2() {
		EasybuyOrderDoExample easybuyOrderDoExample = new EasybuyOrderDoExample();
		return easybuyOrderDoMapper.selectAllByExample(easybuyOrderDoExample);
	}
	public List<EasybuyOrderDetail> list3() {
		EasybuyOrderDetailExample easybuyOrderDetailExample = new EasybuyOrderDetailExample();
		return easybuyOrderDetailMapper.selectByExample(easybuyOrderDetailExample);
	}
}

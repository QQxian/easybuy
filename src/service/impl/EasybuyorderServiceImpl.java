package service.impl;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mapper.EasybuyOrderMapper;
import model.EasybuyOrder;
import model.EasybuyOrderExample;
import service.EasybuyorderService;



@Service
@Transactional
public class EasybuyorderServiceImpl implements EasybuyorderService {
    @Resource
	private EasybuyOrderMapper easybuyOrderMapper;
	@Override
	public List<EasybuyOrder> list(String name,Integer page) {
		EasybuyOrderExample easybuyOrderExample=new EasybuyOrderExample();		
		if(name !=null&&!name.trim().equals("")){
			easybuyOrderExample.createCriteria().andSerialnumberLike("%"+name+"%");
		}
		easybuyOrderExample.setOrderByClause("createtime desc");
		easybuyOrderExample.setLimit(6);
		easybuyOrderExample.setOffset((page-1)*6);
		return 	easybuyOrderMapper.selectByExample(easybuyOrderExample);
	}
	@Override
	public boolean dele(Integer id) {
		easybuyOrderMapper.deleteByPrimaryKey(id);
		return true;
	}
	@Override
	public int count(String name) {
		EasybuyOrderExample easybuyOrderExample=new EasybuyOrderExample();		
		if(name !=null&&!name.trim().equals("")){
			easybuyOrderExample.createCriteria().andSerialnumberLike("%"+name+"%");
		}
		
		return (int) easybuyOrderMapper.countByExample(easybuyOrderExample);
	}

	
	
}

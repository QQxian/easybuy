package service.impl;

import java.util.List;

import javax.annotation.Resource;

import mapper.EasybuyProductCategoryMapper;
import mapper.EasybuyProductMapper;
import model.EasybuyProduct;
import model.EasybuyProductCategory;
import model.EasybuyProductCategoryExample;
import model.EasybuyProductExample;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.DeatailsService;
import service.EasybuyProductService;

@Service
@Transactional
public class DeatailsServiceServiceImpl implements DeatailsService {
	@Resource
	private EasybuyProductMapper easybuyProductMapper;

	@Override
	public EasybuyProduct select(Integer id) {
		return easybuyProductMapper.selectByPrimaryKey(id);
	}

}

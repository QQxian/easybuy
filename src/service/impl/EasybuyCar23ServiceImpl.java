
package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.EasybuyCar23Service;
import mapper.EasybuyOrderDetailMapper;
import mapper.EasybuyOrderMapper;
import model.EasybuyOrder;
import model.EasybuyOrderDetail;
import model.EasybuyOrderDetailExample;
import model.EasybuyOrderExample;
@Service
@Transactional
public class EasybuyCar23ServiceImpl implements EasybuyCar23Service {
	@Resource
	private EasybuyOrderDetailMapper easybuyOrderDetailMapper;
	@Resource
	private EasybuyOrderMapper  easybuyOrderMapper;
	public List<EasybuyOrderDetail> list(int page,Integer orderid) {
		EasybuyOrderDetailExample easybuyOrderDetailExample = new EasybuyOrderDetailExample();
		easybuyOrderDetailExample.createCriteria().andOrderidEqualTo(orderid);
		return easybuyOrderDetailMapper.selectByExample(easybuyOrderDetailExample);
	}
	public long count() {
		EasybuyOrderDetailExample easybuyOrderDetailExample = new EasybuyOrderDetailExample();
		EasybuyOrder easybuyOrder=new EasybuyOrder();
		easybuyOrder.setId(2);
		easybuyOrderDetailExample.createCriteria().andOrderidEqualTo(easybuyOrder.getId());
		return easybuyOrderDetailMapper.countByExample(easybuyOrderDetailExample);
	}
	
	@Override
	public boolean add(EasybuyOrder easybuyOrder) {
		 easybuyOrderMapper.insert(easybuyOrder);
		 return true;
	}
	@Override
	public List<EasybuyOrder> list() {
		EasybuyOrderExample easybuyOrderExample = new EasybuyOrderExample();
		return easybuyOrderMapper.selectByExample(easybuyOrderExample);
	}
	@Override
	public List<EasybuyOrderDetail> detailtype(Integer orderid) {
		EasybuyOrderDetailExample easybuyOrderDetailExample = new EasybuyOrderDetailExample();
		easybuyOrderDetailExample.createCriteria().andOrderidEqualTo(orderid).andTypeEqualTo(0);
		return easybuyOrderDetailMapper.selectByExample(easybuyOrderDetailExample);
	}
	@Override
	public void state(EasybuyOrderDetail easybuyOrderDetail) {
		easybuyOrderDetailMapper.modtype(easybuyOrderDetail);
		 
	}
}

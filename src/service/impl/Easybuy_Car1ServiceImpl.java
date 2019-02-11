package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mapper.EasybuyOrderDetailMapper;
import mapper.EasybuyOrderMapper;
import mapper.EasybuyProductMapper;
import mapper.EasybuyUserMapper;
import model.EasybuyOrder;
import model.EasybuyOrderDetail;
import model.EasybuyOrderDetailExample;
import model.EasybuyOrderExample;
import model.EasybuyProduct;
import model.EasybuyUser;
import service.Easybuy_Car1Service;
import vo.Cart;
import vo.Cart1;

@Service
@Transactional
public class Easybuy_Car1ServiceImpl implements Easybuy_Car1Service  {
	
	@Resource
	private EasybuyOrderDetailMapper easybuyOrderDetailMapper;
	@Resource
	private EasybuyProductMapper easybuyProductMapper;
	@Resource
	private EasybuyOrderMapper easybuyOrderMapper;
	@Resource
	private EasybuyUserMapper easybuyUserMapper;
	@Override
	public List<Cart> list(Cart cart) {
	//	Cart cart=new Cart();
		return easybuyOrderDetailMapper.selectAll(cart);

	}

	@Override
	public boolean del(Integer id) {
		easybuyOrderDetailMapper.deleteByPrimaryKey(id);
		return true;
	}

	@Override
	public List<EasybuyOrderDetail> list2() {
		EasybuyOrderDetailExample newsDetailExample = new EasybuyOrderDetailExample();
		// TODO Auto-generated method stub	
		return easybuyOrderDetailMapper.selectByExample(newsDetailExample);
	}

	@Override
	public EasybuyOrderDetail update(EasybuyOrderDetail easybuyOrderDetail) {
		// TODO Auto-generated method stub
		easybuyOrderDetailMapper.updateByPrimaryKeySelective(easybuyOrderDetail);
		return easybuyOrderDetail;
	}

	@Override
	public EasybuyOrderDetail add(EasybuyOrderDetail easybuyOrderDetail) {
		// TODO Auto-generated method stub
		easybuyOrderDetailMapper.insert(easybuyOrderDetail);
		return easybuyOrderDetail;
	}

	@Override
	public EasybuyProduct  select(Integer id) {
		// TODO Auto-generated method stub
		return easybuyProductMapper.selectByPrimaryKey(id);
		
	}

//	public EasybuyOrder selectOrder(Integer id) {
//		// TODO Auto-generated method stub	
//		return easybuyOrderMapper.selectOrder(id);
//		//return easybuyOrderMapper.selectOrder(id);
//	}

//	@Override
//	public List<EasybuyOrder>  selectOrderTo() {
//		EasybuyOrderExample example=new EasybuyOrderExample();
//		// TODO Auto-generated method stub
//		return   easybuyOrderMapper.selectByExample(example);
//	}

	@Override
	public EasybuyUser selectUser(String loginName) {
		// TODO Auto-generated method stub
		return easybuyUserMapper.selectUser(loginName);
	}

	@Override
	public EasybuyOrderDetail stateUpdate(EasybuyOrderDetail easybuyOrderDetail) {
		// TODO Auto-generated method stub
		easybuyOrderDetailMapper.stateUpdate(easybuyOrderDetail);
		return easybuyOrderDetail;
	}

	@Override
	public List<EasybuyOrderDetail> selectDetail(EasybuyOrderDetail easybuyOrderDetail) {
		// TODO Auto-generated method stub
		return easybuyOrderDetailMapper.selectDe(easybuyOrderDetail);
	}

	@Override
	public EasybuyOrderDetail UpdateQ(EasybuyOrderDetail easybuyOrderDetail) {
		easybuyOrderDetailMapper.UpdateQ(easybuyOrderDetail);
		return easybuyOrderDetail;
	}

	@Override
	public int selectOrderId(int userI) {
		// TODO Auto-generated method stub
		return easybuyOrderDetailMapper.selectOrderId(userI);
	}

	@Override
	public EasybuyOrderDetail UpdateOrdreId(EasybuyOrderDetail easybuyOrderDetail) {
		easybuyOrderDetailMapper.UpdateOrderId(easybuyOrderDetail);
		return easybuyOrderDetail;
	}
	


	
	
}

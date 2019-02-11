package service;

import java.util.List;

import model.EasybuyOrder;
import model.EasybuyOrderDetail;


public interface EasybuyCar23Service {
	public List<EasybuyOrderDetail> list(int page,Integer orderid);
	public long count();
	public boolean add(EasybuyOrder easybuyOrder);
	public void state(EasybuyOrderDetail easybuyOrderDetail);
	public List<EasybuyOrder> list();
	public List<EasybuyOrderDetail> detailtype(Integer orderid);
}

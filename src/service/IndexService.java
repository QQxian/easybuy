package service;

import java.util.List;

import vo.EasybuyAll;
import model.EasybuyOrderDetail;
import model.EasybuyProduct;

public interface IndexService {
	public List<EasybuyProduct> list(int page , String name ,String orderby) ;
	public long count(String name);
	public EasybuyProduct findProById(Integer id);
	public List<EasybuyAll> list2();
//	public List<EasybuyOrderDetail> list3();
}

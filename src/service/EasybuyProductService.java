package service;

import java.util.List;

import model.EasybuyOrderDetail;
import model.EasybuyProduct;
import model.EasybuyProductCategory;
import model.EasybuyProductPhoto;



public interface EasybuyProductService {
	public List<EasybuyProduct> list(int page , String name);
	public long count(String name);
	public EasybuyProduct select(Integer id);
	public boolean insert(EasybuyProduct easybuyProduct);
	public boolean update(EasybuyProduct easybuyProduct);
	public boolean deleteNewsDatail(Integer id);

	public List<EasybuyProductCategory> list2(Integer i);
	public List<EasybuyProductCategory> list3(Integer i, String name);
	public EasybuyProductCategory selectCategory(Integer id1);

	
	public List<EasybuyProduct>list(int page,String name,Integer id,Integer categorylevel2id);
	public int count(String name,Integer id,Integer categorylevel2id );
	public List<EasybuyProduct>list2();

}

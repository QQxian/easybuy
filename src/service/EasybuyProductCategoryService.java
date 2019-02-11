package service;

import java.util.List;

import model.EasybuyProductCategory;


public interface EasybuyProductCategoryService {
	public List<EasybuyProductCategory> list1();
	public List<EasybuyProductCategory> list3(EasybuyProductCategory nasybuy);
	public List<EasybuyProductCategory> list2(Integer type);
//	public EasybuyProductCategory list3(Integer id ,Integer parentid);
	    public EasybuyProductCategory getById(Integer id) ;
	   //public List<ProductCategoryVo>  queryAllProductCategoryList() ;
	

}

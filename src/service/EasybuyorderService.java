package service;
import java.util.List;

import model.EasybuyOrder;



public interface EasybuyorderService {
       public List<EasybuyOrder>list(String name,Integer page);//查询全部
       public boolean dele(Integer id);//删除
       public int count(String name);//记录总数
	
}

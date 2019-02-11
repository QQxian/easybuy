package mapper;

import java.util.List;
import model.EasybuyOrderDetail;
import model.EasybuyOrderDetailExample;
import vo.Cart;
import vo.EasybuyAll;


import org.apache.ibatis.annotations.Param;

public interface EasybuyOrderDetailMapper {
    long countByExample(EasybuyOrderDetailExample example);

    int deleteByExample(EasybuyOrderDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyOrderDetail record);
    int modtype(EasybuyOrderDetail type);

    int insertSelective(EasybuyOrderDetail record);

    List<EasybuyOrderDetail> selectByExample(EasybuyOrderDetailExample example);

    EasybuyOrderDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EasybuyOrderDetail record, @Param("example") EasybuyOrderDetailExample example);

    int updateByExample(@Param("record") EasybuyOrderDetail record, @Param("example") EasybuyOrderDetailExample example);

    int updateByPrimaryKeySelective(EasybuyOrderDetail record);

    int updateByPrimaryKey(EasybuyOrderDetail record);  
    
    List<Cart> selectAll(Cart cart);
    
    List<EasybuyOrderDetail> selectDe(EasybuyOrderDetail easybuyOrderDetail);
    
    void stateUpdate(EasybuyOrderDetail example);

	List<EasybuyAll> selectAllByExample(
	EasybuyOrderDetailExample easybuyOrderDetailExample);
    void UpdateQ(EasybuyOrderDetail example);
    
    
    
  

    
    void UpdateOrderId(EasybuyOrderDetail example);
}
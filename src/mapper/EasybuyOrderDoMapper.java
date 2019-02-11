package mapper;

import java.util.List;

import model.EasybuyOrderDetail;
import model.EasybuyOrderDetailExample;
import model.EasybuyOrderDoExample;

import org.apache.ibatis.annotations.Param;

import vo.EasybuyAll;

public interface EasybuyOrderDoMapper {
    long countByExample(EasybuyOrderDetailExample example);

    int deleteByExample(EasybuyOrderDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyOrderDetail record);

    int insertSelective(EasybuyOrderDetail record);
    
    List<EasybuyOrderDetail> selectByExample(EasybuyOrderDetailExample example);

    EasybuyOrderDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EasybuyOrderDetail record, @Param("example") EasybuyOrderDetailExample example);

    int updateByExample(@Param("record") EasybuyOrderDetail record, @Param("example") EasybuyOrderDetailExample example);

    int updateByPrimaryKeySelective(EasybuyOrderDetail record);

    int updateByPrimaryKey(EasybuyOrderDetail record);

	List<EasybuyAll> selectAllByExample(EasybuyOrderDoExample easybuyOrderDoExample);
    
}
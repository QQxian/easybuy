package mapper;

import java.util.List;

import model.EasybuyOrder;
import model.EasybuyUser;
import model.EasybuyUserExample;
import org.apache.ibatis.annotations.Param;

public interface EasybuyUserMapper {
    long countByExample(EasybuyUserExample example);

    int deleteByExample(EasybuyUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyUser record);

    int insertSelective(EasybuyUser record);

    List<EasybuyUser> selectByExample(EasybuyUserExample example);

    EasybuyUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EasybuyUser record, @Param("example") EasybuyUserExample example);

    int updateByExample(@Param("record") EasybuyUser record, @Param("example") EasybuyUserExample example);

    int updateByPrimaryKeySelective(EasybuyUser record);

    int updateByPrimaryKey(EasybuyUser record);
    
    EasybuyUser selectUser(String loginName );
}
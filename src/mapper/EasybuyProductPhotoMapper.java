package mapper;

import java.util.List;
import model.EasybuyProductPhoto;
import model.EasybuyProductPhotoExample;
import org.apache.ibatis.annotations.Param;

public interface EasybuyProductPhotoMapper {
    long countByExample(EasybuyProductPhotoExample example);

    int deleteByExample(EasybuyProductPhotoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyProductPhoto record);

    int insertSelective(EasybuyProductPhoto record);

    List<EasybuyProductPhoto> selectByExample(EasybuyProductPhotoExample example);

    EasybuyProductPhoto selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EasybuyProductPhoto record, @Param("example") EasybuyProductPhotoExample example);

    int updateByExample(@Param("record") EasybuyProductPhoto record, @Param("example") EasybuyProductPhotoExample example);

    int updateByPrimaryKeySelective(EasybuyProductPhoto record);

    int updateByPrimaryKey(EasybuyProductPhoto record);
}
package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import po.Carts;
import po.CartsExample;

public interface CartsMapper {
    int countByExample(CartsExample example);

    int deleteByExample(CartsExample example);

    int deleteByPrimaryKey(Integer cartid);

    int insert(Carts record);

    int insertSelective(Carts record);

    List<Carts> selectByExample(CartsExample example);

    Carts selectByPrimaryKey(Integer cartid);

    int updateByExampleSelective(@Param("record") Carts record, @Param("example") CartsExample example);

    int updateByExample(@Param("record") Carts record, @Param("example") CartsExample example);

    int updateByPrimaryKeySelective(Carts record);

    int updateByPrimaryKey(Carts record);
}
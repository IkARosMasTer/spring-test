package org.choviwu.movie.mapper;

import org.apache.ibatis.annotations.Param;
import org.choviwu.movie.model.Item;
import org.choviwu.movie.model.ItemExample;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ItemMapper extends Mapper<Item>{
    long countByExample(ItemExample example);

    int deleteByExample(ItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    int insertSelective(Item record);

    List<Item> selectByExample(ItemExample example);

    Item selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByExample(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    List<Item> selectByMovie();
}
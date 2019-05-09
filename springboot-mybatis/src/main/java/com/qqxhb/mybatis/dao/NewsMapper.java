package com.qqxhb.mybatis.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.qqxhb.mybatis.entity.News;
import com.qqxhb.mybatis.entity.NewsExample;

public interface NewsMapper {
    long countByExample(NewsExample example);

    int deleteByExample(NewsExample example);

    int insert(News record);

    int insertSelective(News record);

    List<News> selectByExample(NewsExample example);

    int updateByExampleSelective(@Param("record") News record, @Param("example") NewsExample example);

    int updateByExample(@Param("record") News record, @Param("example") NewsExample example);
}
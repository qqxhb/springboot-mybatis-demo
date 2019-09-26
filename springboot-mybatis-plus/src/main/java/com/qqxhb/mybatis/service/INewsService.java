package com.qqxhb.mybatis.service;

import com.qqxhb.mybatis.entity.News;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qqxhb
 * @since 2019-05-10
 */
public interface INewsService extends IService<News> {

	boolean insertNews(String title, String summary);

	public List<News> selectNews(String title, Integer pageIndex, Integer pageSize);

}

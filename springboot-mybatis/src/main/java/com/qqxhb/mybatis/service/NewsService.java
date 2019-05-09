package com.qqxhb.mybatis.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qqxhb.mybatis.dao.NewsMapper;
import com.qqxhb.mybatis.entity.News;
import com.qqxhb.mybatis.entity.NewsExample;

@Service
public class NewsService {

	@Autowired
	NewsMapper newsMapper;

	/**
	 * 添加新闻
	 * 
	 * @param title
	 * @param summary
	 * @return
	 */
	public int insertNews(String title, String summary) {
		if (title == null || title.length() < 1) {
			return 0;
		}
		News record = new News();
		record.setTitle(title);
		record.setSummary(summary);
		record.setCreateTime(new Date());
		return newsMapper.insertSelective(record);
	}

	/**
	 * 查询新闻
	 * 
	 * @param title
	 * @return
	 */
	public List<News> selectNews(String title) {
		NewsExample example = new NewsExample();
		if (title != null && title.length() > 0) {
			example.createCriteria().andTitleLike(title);
		}
		return newsMapper.selectByExample(example);
	}

}

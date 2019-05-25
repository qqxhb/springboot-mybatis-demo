package com.qqxhb.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qqxhb.mybatis.entity.News;
import com.qqxhb.mybatis.service.impl.NewsServiceImpl;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author qqxhb
 * @since 2019-05-10
 */
@RestController
@RequestMapping("/news")
public class NewsController {
	@Autowired
	NewsServiceImpl newsServiceImpl;

	/**
	 * 添加新闻
	 * 
	 * @param title
	 * @param summary
	 * @return
	 */
	@PostMapping
	public String addNews( String title, String summary) {
		return newsServiceImpl.insertNews(title, summary) ? "添加成功！" : "添加失败！";
	}

	/**
	 * 查询新闻
	 * 
	 * @param title
	 * @return
	 */
	@GetMapping
	public List<News> getNews(String title, int pageIndex, int pageSize) {
		return newsServiceImpl.selectNews(title, pageIndex, pageSize);
	}
}

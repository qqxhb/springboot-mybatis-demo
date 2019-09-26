package com.qqxhb.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qqxhb.mybatis.entity.News;
import com.qqxhb.mybatis.mapper.NewsMapper;
import com.qqxhb.mybatis.service.INewsService;

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
	INewsService newsService;

	/**
	 * 添加新闻
	 * 
	 * @param title
	 * @param summary
	 * @return
	 */
	@PostMapping
	public String addNews(@RequestParam(value = "title", required = true) String title, String summary) {
		return newsService.insertNews(title, summary) ? "添加成功！" : "添加失败！";
	}

	/**
	 * 查询新闻
	 * 
	 * @param title
	 * @return
	 */
	@GetMapping
	public List<News> getNews(String title, int pageIndex, int pageSize) {
		return newsService.selectNews(title, pageIndex, pageSize);
	}

	@Autowired
	NewsMapper map;

	@GetMapping("test")
	public void getNews() {
		try {
			System.out.println(map.hashCode());
			;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

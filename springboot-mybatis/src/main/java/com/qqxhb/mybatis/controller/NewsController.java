package com.qqxhb.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qqxhb.mybatis.entity.News;
import com.qqxhb.mybatis.service.NewsService;

@RestController
@RequestMapping("news")
public class NewsController {

	@Autowired
	NewsService newsService;
	
	/**添加新闻
	 * @param title
	 * @param summary
	 * @return
	 */
	@PostMapping
	public String addNews(@RequestParam(value = "title",required = true)String title, String summary) {
		int news = newsService.insertNews(title, summary);
		return news>0?"添加成功！":"添加失败！";
	} 

	/**查询新闻
	 * @param title
	 * @return
	 */
	@GetMapping
	public List<News> getNews(String title) {
		return newsService.selectNews(title);
	}
}

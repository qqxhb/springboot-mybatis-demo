package com.qqxhb.mybatis.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qqxhb.mybatis.entity.News;
import com.qqxhb.mybatis.exception.ExceptionCast;
import com.qqxhb.mybatis.mapper.NewsMapper;
import com.qqxhb.mybatis.service.INewsService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author qqxhb
 * @since 2019-05-10
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {

	/**
	 * 添加新闻
	 * 
	 * @param title
	 * @param summary
	 * @return
	 */
	public boolean insertNews(String title, String summary) {
		if (title == null || title.length() < 1) {
			return false;
		}
		News record = new News();
		record.setTitle(title);
		record.setSummary(summary);
		record.setCreateTime(LocalDateTime.now());
		;
		return super.save(record);
	}

	/**
	 * 查询新闻
	 * 
	 * @param title
	 * @return
	 */
	public List<News> selectNews(String title, Integer pageIndex, Integer pageSize) {
		QueryWrapper<News> queryWrapper = null;
		if (title != null && title.length() > 0) {
			queryWrapper = new QueryWrapper<News>().like("title", title);
		}
		IPage<News> page = page(new Page<News>(pageIndex, pageSize), queryWrapper);
		return page.getRecords();
	}

	public List<News> test() {
		ExceptionCast.cast();
		return null;
	}

}

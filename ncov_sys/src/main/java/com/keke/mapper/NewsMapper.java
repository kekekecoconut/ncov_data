package com.keke.mapper;

import com.keke.domain.News;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsMapper {

    public void insertNews(News news);

    public List<News> selectNewsByTitle(@Param("title")String title);

    public List<News> showNews();

}

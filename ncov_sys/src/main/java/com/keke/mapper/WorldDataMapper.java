package com.keke.mapper;

import com.keke.domain.WorldData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorldDataMapper {

    public void insertToday(WorldData worldData);

    public List<WorldData> selectToday(@Param("date")String date);

    public String selectConfirmed(@Param("date")String date, @Param("country")String country);

}

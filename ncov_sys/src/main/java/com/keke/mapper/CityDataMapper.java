package com.keke.mapper;

import com.keke.domain.CityData;
import com.keke.domain.CityNewData;
import com.keke.domain.CountryData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityDataMapper {

    public void insertCityData(CityNewData cityNewData);

    public void updateCityData(CityNewData cityNewData);

    public List<CityNewData> selectDataByCity(@Param("cityName")String cityName, @Param("provinceName")String provinceName);

    public List<CityNewData> selectBeijingData();

    public List<CityNewData> selectXinjiangData();

   // public List<CityData>

}

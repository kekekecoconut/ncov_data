package com.keke.mapper;
import com.keke.domain.CountryData;
import com.keke.domain.CountryDayData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryDataMapper {

    public CountryDayData selectDayCurrent(@Param("date")String date);

    public void insertCountryData(CountryData countryData);

    public void updateCountryData(CountryData countryData);

    public List<CountryData> selectDataByCountry(@Param("provinceName")String provinceName);

    public List<CountryData> selectAllData();
}

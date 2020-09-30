package com.keke.mapper;

import com.keke.domain.CountryData;
import com.keke.domain.ProvinceData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProvinceDataMapper {

    public void insertProvinceData(ProvinceData provinceData);

    public void updateProvinceData(ProvinceData provinceData);

    public List<ProvinceData> selectDataByProvince(@Param("provinceName")String provinceName);

    public List<ProvinceData> selectConfirmedDataProvince();
}

package com.keke.mapper;

import com.keke.domain.EveryCountryData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EveryMapper {

    public List<EveryCountryData> countryDateList(@Param("date") String date);
}

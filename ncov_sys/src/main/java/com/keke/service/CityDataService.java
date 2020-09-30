package com.keke.service;

import com.keke.domain.CityData;
import com.keke.domain.CityNewData;
import com.keke.domain.CountryConfirmed;
import com.keke.domain.CountryData;
import com.keke.mapper.CityDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CityDataService {

    @Autowired
    private CityDataMapper cityDataMapper;

    public List<CountryConfirmed> getBeijingConfirmed(){
        List<CityNewData> list = cityDataMapper.selectBeijingData();
        List<CountryConfirmed> fl = new LinkedList<>();
        for (CityNewData c :
                list) {
            CountryConfirmed cc = new CountryConfirmed(c.getCityName(),Integer.valueOf(c.getCurrentConfirmedCount()));
            fl.add(cc);
        }
        return fl;
    }

    public List<CountryConfirmed> getXinjiangConfirmed(){
        List<CityNewData> list = cityDataMapper.selectXinjiangData();
        List<CountryConfirmed> fl = new LinkedList<>();
        for (CityNewData c :
                list) {
            CountryConfirmed cc = new CountryConfirmed(c.getCityName(),Integer.valueOf(c.getCurrentConfirmedCount()));
            fl.add(cc);
        }
        return fl;
    }

}

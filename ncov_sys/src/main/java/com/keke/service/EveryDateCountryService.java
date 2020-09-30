package com.keke.service;

import com.keke.domain.CountrySeries;
import com.keke.domain.EveryCountryData;
import com.keke.mapper.EveryMapper;
import com.keke.utils.GetTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class EveryDateCountryService {

    @Autowired
    private EveryMapper everyMapper;

    public String dateList(){
        String str = new GetTimeUtil().getCurrentDate();
        List<EveryCountryData> list = everyMapper.countryDateList(str);
        LinkedList<String> dateList = new LinkedList<>();
        for (EveryCountryData e: list
             ) {
            dateList.add(e.getDate());
        }
        String s = dateList.toString();
        return s;
    }

    public String otherList(){
        String str = new GetTimeUtil().getCurrentDate();
        List<EveryCountryData> list = everyMapper.countryDateList(str);
        LinkedList<CountrySeries> seriesList = new LinkedList<>();
        ArrayList<String> as = new ArrayList<>();
        for (EveryCountryData e: list
             ) {
            if(e.getCountry().equals("德国")){
                as.add(e.getConfirmed());
            }

        }
        return null;
    }


}

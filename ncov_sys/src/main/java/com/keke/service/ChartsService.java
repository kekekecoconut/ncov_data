package com.keke.service;

import com.keke.domain.Confirmed;
import com.keke.mapper.ChartsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@Service
public class ChartsService {
    @Autowired
    private ChartsMapper chartsMapper;

    public List<Confirmed> confirmedCountryData(){
        List<Confirmed> list = chartsMapper.selectConfirmed();
        Collections.sort(list, new Comparator<Confirmed>() {
            @Override
            public int compare(Confirmed o1, Confirmed o2) {
                String str1 = o1.getCurrentConfirmedCount();
                String str2 = o2.getCurrentConfirmedCount();
                Integer s1 = Integer.valueOf(str1);
                Integer s2 = Integer.valueOf(str2);
                return (s2 - s1) == 0?(s1 - s2):(s2 - s1);
            }
        });
        List<Confirmed> newlist = new LinkedList<>();
        int count=0;
        for (Confirmed c: list
             ) {
            newlist.add(c);
            if(count>3) {
                break;
            }
            else {
                count++;
            }
        }
        return newlist;
    }
}

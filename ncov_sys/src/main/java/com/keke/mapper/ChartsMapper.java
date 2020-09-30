package com.keke.mapper;

import com.keke.domain.Confirmed;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChartsMapper {

    public List<Confirmed> selectConfirmed();

}

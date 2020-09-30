package com.keke;

import com.keke.service.ProvinceCityService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan(basePackages = {"com.keke.mapper"})
class NcovSysApplicationTests {

    @Test
    void contextLoads() {
    }

}

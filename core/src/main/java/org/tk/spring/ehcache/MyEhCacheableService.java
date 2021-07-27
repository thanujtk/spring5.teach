package org.tk.spring.ehcache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MyEhCacheableService {

    public String getSquare(Long number) {
        return String.format("{\"square\": %s}", square(number));
    }

    @Cacheable(value = "squareCache", key = "#number", condition = "#number>10", cacheManager = "ehcacheManager")
    public BigDecimal square(Long number) {
        BigDecimal square = BigDecimal.valueOf(number).multiply(BigDecimal.valueOf(number));
        System.out.println("MyCacheableService.square called with result " + square);
        return square;
    }
}

package org.tk.spring.rest;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping(value = "/rest", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class StockRestController {

    private static final Map<String, Stock> STOCK_LIVE = new ConcurrentHashMap<>() {
        {
            put("NSE:TATAMOTORS", new Stock("NSE:TATAMOTORS", 303.10));
            put("NSE:INFY", new Stock("NSE:INFY", 1588.95));
            put("NSE:ITC", new Stock("NSE:ITC", 207.00));
            put("NSE:ICICIBANK", new Stock("NSE:ICICIBANK", 655.75));
        }
    };

    @GetMapping("/stock/{company}")
    public Stock getStockPrice(@PathVariable("company") String company) {
        Stock stock;
        if (STOCK_LIVE.containsKey(company)) {
            stock = STOCK_LIVE.get(company);
        } else {
            throw new IllegalArgumentException("we done have stock information for given company");
        }
        return stock;
    }

    @PutMapping("/stock/{company}")
    public void storeStockPrice(@PathVariable("company") String company, @Valid @RequestBody Stock stock) {
        STOCK_LIVE.put(company, stock);
    }

    @PostMapping("/stock/{company}")
    public void updateStockPrice(@PathVariable("company") String company, @Valid @RequestBody Stock stock) {
        STOCK_LIVE.put(company, stock);
    }


    @Value
    @AllArgsConstructor
    static class Stock {

        @NotNull
        @Size(max = 15)
        private String company;

        @NotNull
        @DecimalMin("0.01")
        private Double price;
    }

}

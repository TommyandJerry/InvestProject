package com.invest.controller;

import com.invest.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class StockController {

    @Value("${stock.now.all.url}")
    private String stock_now_all;

    @Autowired
    private HttpUtils httpUtils;

    @RequestMapping(value = "/StockNowAll")
    public String StockNowAll(){
        String response = httpUtils.doGet(stock_now_all);
        log.info(stock_now_all);
        return "hello home";
    }

    
}

package com.invest.controller;

import com.google.gson.Gson;
import com.invest.utils.HttpUtils;
import com.sun.xml.internal.bind.v2.TODO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import responses.Stock_Now_All_Response;

@Slf4j
@Controller
public class StockController {

    @Value("${stock.now.all.url}")
    private String stock_now_all;

    @Autowired
    private HttpUtils httpUtils;

    @Autowired
    private Gson gson;

    @RequestMapping(value = "/StockNowAll")
    public String StockNowAll(){
        String response = httpUtils.doGet(stock_now_all);
        Stock_Now_All_Response stock_now_all_response = gson.fromJson(response,Stock_Now_All_Response.class);
        //TODO 上面获取了所有股票的基本信息，数据类型字段详情见Stock_Now_All_Vo
        return "hello home";
    }

    

    
}

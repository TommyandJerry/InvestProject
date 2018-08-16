package com.invest.controller;

import beans.Stock_Now_All_Vo;
import com.google.gson.Gson;
import com.invest.utils.CalculateUtils;
import com.invest.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import responses.Stock_Now_All_Response;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class StockController {

    @Value("${stock.now.all.url}")
    private String URL_stock_now_all;

    @Value("${stock.trade.by.trade}")
    private String URL_stock_trade_by_trade;

    @Autowired
    private HttpUtils httpUtils;

    @Autowired
    private Gson gson;

    @Autowired
    private CalculateUtils calculateUtils;

    @RequestMapping(value = "/StockNowAll")
    public String StockNowAll(){
        String response = httpUtils.doGet(URL_stock_now_all);
        Stock_Now_All_Response stock_now_all_response = gson.fromJson(response,Stock_Now_All_Response.class);


        List<Stock_Now_All_Vo> aim_stocks = new ArrayList<>();
        for(Stock_Now_All_Vo vo :stock_now_all_response.getData()){
            //TODO 准备计算符合条件的股票，还差增加String加减乘除的类
            
        }
        return "hello home";
    }

    

    
}

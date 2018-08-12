package com.invest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class HomeController {


    @RequestMapping(value = "/home")
    @ResponseBody
    public String home(){
        return "hello home";
    }


}

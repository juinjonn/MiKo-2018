package com.HUST.JuinJonn.MiKo2018.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyInformationController {
    @RequestMapping(value = "/myInformation")
    public String myInformation(){

        return "myInformation";
    }
}

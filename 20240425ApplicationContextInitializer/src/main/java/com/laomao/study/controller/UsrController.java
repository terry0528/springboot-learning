package com.laomao.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UsrController {

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public ModelAndView info(){
        int i=1/0;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userInfo");
        modelAndView.addObject("username","GDB");
        return modelAndView;
    }


}

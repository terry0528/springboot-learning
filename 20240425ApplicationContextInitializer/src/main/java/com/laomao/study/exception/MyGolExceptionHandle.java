package com.laomao.study.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 通过注解ControllerAdvice 接管全局异常
 */
@ControllerAdvice
public class MyGolExceptionHandle {

    @ExceptionHandler({Exception.class})
    public ModelAndView handleException(Exception ex){
        ex.printStackTrace();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        return mv;
    }
}

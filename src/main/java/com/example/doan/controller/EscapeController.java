package com.example.doan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/escape")
@RequiredArgsConstructor
public class EscapeController {
    @GetMapping("/1")
    public ModelAndView escape1() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cachthoathiem/1");
        return modelAndView;
    }
    @GetMapping("/2")
    public ModelAndView escape2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cachthoathiem/2");
        return modelAndView;
    }
    @GetMapping("/3")
    public ModelAndView escape3() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cachthoathiem/3");
        return modelAndView;
    }
    @GetMapping("/4")
    public ModelAndView escape4() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cachthoathiem/4");
        return modelAndView;
    }
    @GetMapping("/5")
    public ModelAndView escape5() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cachthoathiem/5");
        return modelAndView;
    }
    @GetMapping("/6")
    public ModelAndView escape6() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cachthoathiem/6");
        return modelAndView;
    }
    @GetMapping("/7")
    public ModelAndView escape7() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cachthoathiem/7");
        return modelAndView;
    }
    @GetMapping("/8")
    public ModelAndView escape8() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cachthoathiem/8");
        return modelAndView;
    }
    @GetMapping("/9")
    public ModelAndView escape9() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cachthoathiem/9");
        return modelAndView;
    }
    @GetMapping("/10")
    public ModelAndView escape10() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cachthoathiem/10");
        return modelAndView;
    }
    @GetMapping("/11")
    public ModelAndView escape11() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cachthoathiem/11");
        return modelAndView;
    }
    @GetMapping("/12")
    public ModelAndView escape12() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cachthoathiem/12");
        return modelAndView;
    }
    @GetMapping("/13")
    public ModelAndView escape13() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cachthoathiem/13");
        return modelAndView;
    }
    @GetMapping("/14")
    public ModelAndView escape14() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cachthoathiem/14");
        return modelAndView;
    }
    @GetMapping("/15")
    public ModelAndView escape15() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cachthoathiem/15");
        return modelAndView;
    }
    @GetMapping("/16")
    public ModelAndView escape16() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cachthoathiem/16");
        return modelAndView;
    }
}

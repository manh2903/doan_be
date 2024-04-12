package com.example.doan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/skill")
@RequiredArgsConstructor
public class SkillController {

    @GetMapping("/1")
    public ModelAndView skill1() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("skill/1");
        return modelAndView;
    }
    @GetMapping("/2")
    public ModelAndView skill2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("skill/2");
        return modelAndView;
    }
    @GetMapping("/3")
    public ModelAndView skill3() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("skill/3");
        return modelAndView;
    }
    @GetMapping("/4")
    public ModelAndView skill4() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("skill/4");
        return modelAndView;
    }
    @GetMapping("/5")
    public ModelAndView skill5() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("skill/5");
        return modelAndView;
    }
    @GetMapping("/6")
    public ModelAndView skill6() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("skill/6");
        return modelAndView;
    }
    @GetMapping("/7")
    public ModelAndView skill7() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("skill/7");
        return modelAndView;
    }
    @GetMapping("/8")
    public ModelAndView skill8() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("skill/8");
        return modelAndView;
    }
    @GetMapping("/9")
    public ModelAndView skill9() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("skill/9");
        return modelAndView;
    }
    @GetMapping("/10")
    public ModelAndView skill10() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("skill/10");
        return modelAndView;
    }
    @GetMapping("/11")
    public ModelAndView skill11() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("skill/11");
        return modelAndView;
    }
    @GetMapping("/12")
    public ModelAndView skill12() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("skill/12");
        return modelAndView;
    }
    @GetMapping("/13")
    public ModelAndView skill13() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("skill/13");
        return modelAndView;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishit.springhibernate.controller;

import com.nishit.springhibernate.DAO.FeedbackDAOInterface;
import com.nishit.springhibernate.entity.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nishit-TCS
 */
@Controller
public class IndexController {
    
    @Autowired
    FeedbackDAOInterface fdao;
    
    @RequestMapping(value = "AddFeedback", method = { RequestMethod.POST })
    public ModelAndView addFeedback(@ModelAttribute Feedback feedback) {
        ModelAndView mv = new ModelAndView();
        boolean result = fdao.addFeedback(feedback);
        mv.addObject("result", result);
        mv.setViewName("index");
        return mv;
    }
}

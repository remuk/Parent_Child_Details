package de.api.details.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class WebController {
    @RequestMapping(value = { "/", "/Welcome" }, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("/Welcome");
        return mav;
    }
}
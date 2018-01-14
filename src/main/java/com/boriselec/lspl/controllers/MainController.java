package com.boriselec.lspl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @RequestMapping(value="/main", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String viewHome(){
        return "main";
    }
}

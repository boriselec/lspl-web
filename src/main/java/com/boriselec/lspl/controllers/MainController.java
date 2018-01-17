package com.boriselec.lspl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.lspl.text.Text;

@Controller
public class MainController {
    @RequestMapping(value="/main", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String viewHome(){
        Text test = Text.create("Мама мыла раму.");
        return test.getWords().iterator().next().speechPart.getTitle();
    }
}

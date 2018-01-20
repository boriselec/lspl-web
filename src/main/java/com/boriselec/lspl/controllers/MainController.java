package com.boriselec.lspl.controllers;

import com.boriselec.lspl.TextView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.lspl.text.Text;
import ru.lspl.text.Word;

import java.util.List;

@Controller
public class MainController {
    @RequestMapping(value="/", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String singePage(){
        return "main";
    }

    @RequestMapping(value = "api/analyze", method = RequestMethod.POST)
    public @ResponseBody
    TextView analyze(@RequestParam(value = "text") String text) {
        List<Word> words = Text.create(text).getWords();
        return new TextView(words);
    }
}

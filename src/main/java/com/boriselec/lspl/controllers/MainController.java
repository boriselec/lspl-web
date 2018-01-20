package com.boriselec.lspl.controllers;

import com.boriselec.lspl.view.TextView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.lspl.patterns.PatternBuilder;
import ru.lspl.patterns.PatternBuildingException;
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
    TextView analyze(
        @RequestParam(value = "text") String text,
        @RequestParam(value = "pattern") String pattern
    ) throws PatternBuildingException {
        Text analyzedText = Text.create(text);
        List<Word> words = analyzedText.getWords();

        PatternBuilder patternBuilder = PatternBuilder.create();
        patternBuilder.build(pattern);
        if (patternBuilder.getDefinedPatternCount() != 1) {
            throw new IllegalStateException("Pattern count should be exactly one");
        }

        boolean hasAnyMatches = analyzedText.hasAnyMatches(patternBuilder.getDefinedPattern(0));

        return new TextView(words, hasAnyMatches);
    }
}

package com.boriselec.lspl.view;

import ru.lspl.text.Word;

public class WordFormView {
    public String base;
    public String speechPart;

    public WordFormView(Word word) {
        this.base = word.base;
        this.speechPart = word.speechPart.getTitle();
    }
}

package com.boriselec.lspl.view;

import ru.lspl.text.Word;

import java.util.ArrayList;
import java.util.Collection;

public class WordView {
    public String text;
    public Collection<WordFormView> wordFormViews;

    public WordView(Word word) {
        this.text = word.form;
        this.wordFormViews = new ArrayList<>();
        addForm(word);
    }

    public void addForm(Word word) {
        wordFormViews.add(new WordFormView(word));
    }
}

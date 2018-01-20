package com.boriselec.lspl.view;

import ru.lspl.text.Word;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextView {
    public final Map<Integer, WordView> wordViewMap;
    public final boolean hasAnyMatches;

    public TextView(List<Word> words, boolean hasAnyMatches) {
        this.hasAnyMatches = hasAnyMatches;
        wordViewMap = new HashMap<>();
        words.forEach(this::add);
    }


    private void add(Word word) {
        int offset = word.getStartOffset();
        if (wordViewMap.containsKey(offset)) {
            wordViewMap.get(offset).addForm(word);
        } else {
            wordViewMap.put(offset, new WordView(word));
        }
    }
}

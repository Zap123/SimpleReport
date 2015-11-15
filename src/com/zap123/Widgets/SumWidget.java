package com.zap123.Widgets;

import j2html.tags.Tag;

import java.util.Collection;

import static j2html.TagCreator.div;
import static j2html.TagCreator.text;

/**
 * Created by luca on 15/11/15.
 */
public class SumWidget extends Widget {
    Collection<Integer> sumList;
    String description;

    public SumWidget(String description, Collection<Integer> sumList) {
        this.sumList = sumList;
        this.description = description;
    }

    @Override
    public Tag export() {
        return div().withClass("well").with(
                text(description + " : " + sum())
        );
    }

    public int sum() {
        int sum = 0;
        for (Integer i : sumList) {
            sum += i;
        }
        return sum;
    }

    ;
}

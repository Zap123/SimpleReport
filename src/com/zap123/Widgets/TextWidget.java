package com.zap123.Widgets;

import j2html.tags.Tag;

import static j2html.TagCreator.p;

/**
 * Created by luca on 14/11/15.
 */
public class TextWidget extends Widget {
    String text;

    public TextWidget(String text) {
        this.text = text;
    }

    public Tag export() {
        return p(text);
    }
}

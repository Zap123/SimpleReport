package com.zap123.Widgets;

import j2html.tags.Tag;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static j2html.TagCreator.*;

/**
 * Created by luca on 14/11/15.
 * Concrete Composite Widget,
 * Other Widgets can be add to this one
 * to have multiple widgets in a Report
 */
public class LayoutWidget extends Widget {
    String title;

    private ArrayList<Widget> widget_child;

    public LayoutWidget(String title) {
        widget_child = new ArrayList<Widget>();
        this.title = title;
    }

    public Tag export() {
        return html().with(
                head().with(
                        meta().withCharset("utf-8"),
                        meta().withName("viewport").withContent("width=device-width, initial-scale=1"),
                        title(title),
                        link().withRel("stylesheet")
                                .withHref("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"),
                        link().withRel("stylesheet")
                                .withHref("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css")
                ),
                body().with(
                        nav().withClass("navbar navbar-inverse").with(a(title).withClass("navbar-brand").withHref("#")),
                        div().withClass("container").with(exportAll())
                )
        );
    }

    public List<Tag> exportAll() {
        LinkedList<Tag> l = new LinkedList<>();
        for (Widget widget : widget_child) {
            l.add(widget.export());
        }
        return l;
    }

    public void add(Widget w) {
        widget_child.add(w);
    }

}

package com.zap123.Widgets;

import org.junit.Test;

/**
 * Created by luca on 14/11/15.
 */
public class LayoutWidgetTest {
    Widget bd = new LayoutWidget("report Test");

    @Test
    public void testExport() throws Exception {
        LayoutWidget q = (LayoutWidget) bd;
        q.add(new TextWidget("One"));
        q.add(new TextWidget("Two"));
        System.out.println(bd.export());
    }
}
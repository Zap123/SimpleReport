package com.zap123.Widgets;

import com.zap123.DataSources.Model;
import j2html.tags.Tag;

/**
 * Created by luca on 14/11/15.
 * Interface of Widget
 */
public abstract class Widget {
    private static Model ctrl;

    public Model getCtrl() {
        return ctrl;
    }

    public void setCtrl(Model ctrl) {
        this.ctrl = ctrl;
    }

    public abstract Tag export();
}

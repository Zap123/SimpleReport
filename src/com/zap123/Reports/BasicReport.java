package com.zap123.Reports;

import com.zap123.DataSources.Model;
import com.zap123.Utils.HTTPServer;
import com.zap123.Widgets.Widget;

/**
 * Created by luca on 14/11/15.
 * Basic Concrete Report
 */
public class BasicReport implements Report {
    Widget view;

    public BasicReport(Widget view, Model model) {
        this.view = view;
        view.setCtrl(model);
    }

    ;

    public void run() {
        try {
            HTTPServer.startServer(view.export());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ;

}

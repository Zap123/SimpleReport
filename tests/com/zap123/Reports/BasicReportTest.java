package com.zap123.Reports;

import com.zap123.DataSources.DataSource;
import com.zap123.DataSources.Model;
import com.zap123.DataSources.SQliteSource;
import com.zap123.DataSources.SimpleTable;
import com.zap123.Widgets.LayoutWidget;
import com.zap123.Widgets.TableWidget;
import org.junit.Test;


/**
 * Created by luca on 14/11/15.
 */
public class BasicReportTest {
    Report report;


    @Test
    public void testRun() throws Exception {
        //repobuilder
        LayoutWidget w = new LayoutWidget("Report Test");
        w.add(new TableWidget("sales","Sales"));
        Model model = new Model();
        DataSource ds = new SQliteSource("testData/sales");

        SimpleTable sales = new SimpleTable(ds, "Sales");
        model.add("sales",sales);

        report = new BasicReport(w, model);
        report.run();
    }
}
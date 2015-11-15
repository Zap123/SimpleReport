package com.zap123;

import com.zap123.DataSources.DataSource;
import com.zap123.DataSources.Model;
import com.zap123.DataSources.SQliteSource;
import com.zap123.DataSources.SimpleTable;
import com.zap123.Reports.BasicReport;
import com.zap123.Reports.Report;
import com.zap123.Widgets.LayoutWidget;
import com.zap123.Widgets.SumWidget;
import com.zap123.Widgets.TableWidget;
import com.zap123.Widgets.TextWidget;

/*
* An example report showing some widgets
* that uses the SQLite table Sales
* The report can be displayed in a browser at the address
* http://localhost:8080/
*/


public class SimpleReport {

    public static void main(String[] args) {
        Model model = new Model();
        DataSource ds = new SQliteSource("testData/sales");

        SimpleTable sales = new SimpleTable(ds, "Sales");
        model.add("sales", sales);

        LayoutWidget w = new LayoutWidget("Regional Sales Summary - MyCompany");

        w.add(new TextWidget("This is our sales report"));

        w.add(new SumWidget("Total Amount of M1", sales.column("m1")));

        w.add(new TableWidget("sales", "Product Revenue"));

        Report report = new BasicReport(w, model);
        report.run();
    }
}

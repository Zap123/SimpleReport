# SimpleReport
A simple server reporting engine in Java

Run with:  
* java -jar out/artifacts/SimpleReport_jar/SimpleReport.jar 

and point the browser to http://localhost:8080

#Example Report


```java
//instantiate the model and the db connector 
Model model = new Model();
DataSource ds = new SQliteSource("testData/sales");

//Create a Mapping with the table Sales
SimpleTable sales = new SimpleTable(ds, "Sales");
model.add("sales", sales);

//Here we create the view of the Report
LayoutWidget w = new LayoutWidget("Regional Sales Summary - MyCompany");
w.add(new TextWidget("This is our sales report"));
w.add(new SumWidget("Total Amount of M1", sales.column("m1")));
w.add(new TableWidget("sales", "Product Revenue"));

//Run the report
Report report = new BasicReport(w, model);
report.run();
```
![Example Report](/screenshot.png?raw=true "Optional Title")

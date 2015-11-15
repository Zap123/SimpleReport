package com.zap123.DataSources;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by luca on 13/11/15.
 */
public class SQliteSourceTest {
    DataSource ds = new SQliteSource("testData/sales");

    @Test
   public void testConnect() throws Exception {
        SimpleTable sales = new SimpleTable(ds, "sales");
        List<LinkedHashMap> list = sales.getTable();
        assertEquals(list.get(1).get("m1"), 23432);
    }

    @Test
    public void testCount() throws Exception {
        Map map = ds.getDb().sql("select count(*) as count from sales").first(HashMap.class);
        assertEquals(map.get("count"), 6);
    }

    @Test
    public void testPrint() throws Exception {
        SimpleTable sales = new SimpleTable(ds, "sales");
        List<LinkedHashMap> salesTable = sales.getTable();
        for (HashMap row:salesTable) {
            Iterator column = row.values().iterator();
            while(column.hasNext()){
                System.out.print(" | ");
                System.out.print(column.next());
            }
            System.out.println();
        };
   }

    @Test
    public void testHeader() throws Exception {
        SimpleTable sales = new SimpleTable(ds, "sales");
        System.out.print(sales.header());
        assertEquals(sales.header().iterator().next(), "state");
    }


    @Test
    public void testRows() throws Exception {
        SimpleTable sales = new SimpleTable(ds, "sales");
        System.out.print(sales.row(0));
        assertEquals(sales.row(0).iterator().next(), "Ohio");
    }

    @Test
    public void testColumns() throws Exception {
        SimpleTable sales = new SimpleTable(ds, "sales");
        System.out.print(sales.column("m1"));
    }
}

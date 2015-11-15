package com.zap123.DataSources;

import com.dieselpoint.norm.Database;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by luca on 13/11/15.
 *
 * Simple mapping to a table
 */
public class SimpleTable implements Table {
    Database db;
    String name;
    List<LinkedHashMap> table;

    public SimpleTable(DataSource ds, String name) {
        this.name = name;
        this.db = ds.getDb();
        this.table = getTable();
    }

    ;

    public List<LinkedHashMap> getTable() {
        return db.table(name).results(LinkedHashMap.class);
    }

    public Collection header() {
        return table.get(0).keySet();
    }

    public Collection row(int n) {
        return rows().get(n).values();
    }

    public Collection column(String name) {
        ArrayList a = new ArrayList();
        int size = rows().size();
        for (int i = 0; i < size; i++) {
            a.add(rows().get(i).get(name));
        }
        return a;
    }

    public List<LinkedHashMap> rows() {
        //skip the table header
        List<LinkedHashMap> rows = table;
        return rows;
    }

}

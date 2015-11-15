package com.zap123.DataSources;

import java.util.HashMap;

/**
 * Created by luca on 14/11/15.
 *
 * Container of tables used in a report
 */
public class Model {
    HashMap<String, Table> model_source = new HashMap<>();

    public void add(String name, Table t) {
        model_source.put(name, t);
    }

    ;

    public Table get(String name) {
        return model_source.get(name);
    }

    ;
}

package com.zap123.DataSources;

import com.dieselpoint.norm.Database;

/**
 * Created by luca on 13/11/15.
 * interface of database connectors
 */
public abstract class DataSource {
    private static Database db;

    protected Database getDb() {
        return db;
    }

    protected void setDb(Database db) {
        this.db = db;
    }
}

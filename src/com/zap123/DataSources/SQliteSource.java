package com.zap123.DataSources;

/**
 * Created by luca on 13/11/15.
 * SQLite connector
 */
public class SQliteSource extends DataSource {

    public SQliteSource(String path) {
        setDb(new SQliteDatabase(path));
    }
}

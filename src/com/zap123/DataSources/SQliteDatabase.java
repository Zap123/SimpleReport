package com.zap123.DataSources;

import com.dieselpoint.norm.Database;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by luca on 13/11/15.
 * Extends Norm.Database to support SQLite
 */
public class SQliteDatabase extends Database {
    String path;


    public SQliteDatabase(String path) {
        super();
        this.path = path;
    }

    @Override
    protected DataSource getDataSource() throws SQLException {
        HikariConfig config = new HikariConfig();
        config.setPoolName("AuthMeSQLitePool");
        config.setDriverClassName("org.sqlite.JDBC");
        config.setJdbcUrl("jdbc:sqlite:" + path);
        config.setConnectionTestQuery("SELECT 1");
        config.setMaxLifetime(60000); // 60 Sec
        config.setIdleTimeout(45000); // 45 Sec
        config.setMaximumPoolSize(50); // 50 Connections (including idle connections)
        return new HikariDataSource(config);
    }
}

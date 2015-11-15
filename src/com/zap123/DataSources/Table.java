package com.zap123.DataSources;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by luca on 14/11/15.
 * Table Interface for the model
 */
public interface Table {

    Collection header();

    Collection row(int n);

    Collection column(String name);

    List<LinkedHashMap> rows();
}

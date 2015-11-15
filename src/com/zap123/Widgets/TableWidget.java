package com.zap123.Widgets;

import com.zap123.DataSources.Table;
import j2html.tags.Tag;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static j2html.TagCreator.*;

/**
 * Created by luca on 14/11/15.
 */
public class TableWidget extends Widget {
    String tableName;
    String description;

    public TableWidget(String tableName, String description) {
        this.tableName = tableName;
        this.description = description;
    }

    private Table getTable() {
        return getCtrl().get(tableName);
    }

    @Override
    public Tag export() {
        return div().withClass("panel panel-default").with(
                div().withClass("panel-heading").with(text(description)),
                table().withClass("table .table-responsive table-bordered table-hover").with(
                        tableRows()
                )
        );
    }

    public List<Tag> tableHeader() {
        LinkedList tags = new LinkedList();
        Iterator it = getTable().header().iterator();
        while (it.hasNext()) {
            String header = (String) it.next();
            tags.add(th(header));
        }
        return tags;
    }

    public List<Tag> tableRows() {
        //include headerRow
        List<Tag> tags = tableHeader();
        int size = getTable().rows().size();
        for (int i = 0; i < size; i++) {
            List<Tag> rowTags = new LinkedList();
            Iterator it = getTable().row(i).iterator();
            while (it.hasNext()) {
                Object row = it.next();
                rowTags.add(td(row.toString()));
            }
            tags.add(tr().with(rowTags));
        }
        return tags;
    }

}

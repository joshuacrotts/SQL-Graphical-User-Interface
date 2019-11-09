/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshuacrotts.view.mainscreen;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultRowSorter;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joshua
 */
public class TablePanel extends JPanel {

    private final MainScreenPanel parentPanel;

    private final JScrollPane scrollPane;
    private JTable sqlTable;

    public TablePanel (MainScreenPanel parentPanel) {
        this.parentPanel = parentPanel;
        this.setLayout(new BorderLayout());
        this.sqlTable = new JTable(5, 5);
        this.scrollPane = new JScrollPane(this.sqlTable);
        this.sqlTable.setPreferredScrollableViewportSize(this.sqlTable.getPreferredSize());
        this.sqlTable.setAutoCreateRowSorter(true);
        this.add(this.scrollPane);
    }

    public void fillTable (ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();

        String[] columnNames = new String[rsmd.getColumnCount()];
        for (int column = 0 ; column < columnNames.length ; column++) {
            columnNames[column] = (rsmd.getColumnName(column + 1));
        }
        this.parentPanel.getInfoPanel().getTableSorter().updateSortColumns(columnNames);

        this.sqlTable.setModel(buildTableModel(rs));
    }

    public void sortTable (int indexCol) {
        DefaultRowSorter sorter = ((DefaultRowSorter) this.sqlTable.getRowSorter());
        ArrayList list = new ArrayList();
        list.add(new RowSorter.SortKey(indexCol, SortOrder.ASCENDING));
        sorter.setSortKeys(list);
        sorter.sort();
    }

    public static DefaultTableModel buildTableModel (ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1 ; column <= columnCount ; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1 ; columnIndex <= columnCount ; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);

    }
}

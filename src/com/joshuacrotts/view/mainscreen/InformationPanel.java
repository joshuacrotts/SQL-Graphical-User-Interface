package com.joshuacrotts.view.mainscreen;

import com.joshuacrotts.model.TableSelect;
import com.joshuacrotts.model.TableSort;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Joshua
 */
public class InformationPanel extends JPanel {

    private final MainScreenPanel parentPanel;
    private final SortPanel sortPanel;
    private final TableSelectionPanel tableSelectPanel;

    public InformationPanel (MainScreenPanel parentPanel) {
        this.parentPanel = parentPanel;
        this.setLayout(new GridLayout(2, 1));

        this.sortPanel = new SortPanel(parentPanel, this);
        this.tableSelectPanel = new TableSelectionPanel(parentPanel, this);
        this.add(this.sortPanel);
        this.add(this.tableSelectPanel);
    }

    public void fillTables (ResultSet rs) {
        try {
            ArrayList<String> tableNames = new ArrayList<>();
            int i = 0;
            while (rs.next()) {
                tableNames.add(rs.getString(++i));
            }
            this.tableSelectPanel.getTableSelect().updateTableColumns(Arrays.copyOf(tableNames.toArray(), tableNames.size(), String[].class));
        }
        catch (SQLException ex) {
            Logger.getLogger(InformationPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TableSelect getTableSelect () {
        return this.tableSelectPanel.getTableSelect();
    }

    public TableSort getTableSorter () {
        return this.sortPanel.getTableSort();
    }

    public TablePanel getTablePanel () {
        return this.parentPanel.getTablePanel();
    }
}

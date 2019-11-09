package com.joshuacrotts.view.mainscreen;

import com.joshuacrotts.view.SQLWindow;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 *
 * @author Joshua
 */
public class MainScreenPanel extends JPanel {

    private final SQLWindow window;

    private final JSplitPane tableInfoSplitPane;
    private final JSplitPane consoleSplitPane;

    private final ConsolePanel consolePanel;
    private final InformationPanel infoPanel;
    private final TablePanel tablePanel;

    public MainScreenPanel (SQLWindow window) {
        this.window = window;
        this.setLayout(new BorderLayout());
        this.consolePanel = new ConsolePanel(this);
        this.infoPanel = new InformationPanel(this);
        this.tablePanel = new TablePanel(this);

        this.tableInfoSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.infoPanel, this.tablePanel);
        this.consoleSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, this.tableInfoSplitPane, this.consolePanel);
        this.tableInfoSplitPane.setDividerLocation(this.window.getPreferredSize().width / 2);
        this.consoleSplitPane.setDividerLocation(this.window.getPreferredSize().height / 2);

        //this.add(this.tableInfoSplitPane);
        this.add(this.consoleSplitPane);
    }

    public void executeQuery (String input) {
        try {
            String query = input;

            // create the java statement
            Statement st = this.window.remoteDbConnection.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            this.tablePanel.fillTable(rs);
        }
        catch (SQLException ex) {
            Logger.getLogger(MainScreenPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getTableNames () {
        //
        try {
            String query = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'users';";

            // create the java statement
            Statement st = this.window.remoteDbConnection.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            this.infoPanel.fillTables(rs);
        }
        catch (SQLException ex) {
            Logger.getLogger(MainScreenPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public InformationPanel getInfoPanel () {
        return this.infoPanel;
    }

    public TablePanel getTablePanel () {
        return this.tablePanel;
    }
}

package com.joshuacrotts.view.account;

import com.joshuacrotts.main.WindowState;
import com.joshuacrotts.view.SQLWindow;
import java.awt.GridLayout;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Joshua
 */
public class AccountPanel extends JPanel {

    private final SQLWindow window;

    private IPAddressPanel ipPanel;
    private DatabaseNamePanel dbPanel;
    private UsernamePanel usernamePanel;
    private PasswordPanel passwordPanel;
    private LoginPanel loginPanel;

    public AccountPanel (SQLWindow window) {

        this.window = window;
        this.setLayout(new GridLayout(5, 2));
        this.ipPanel = new IPAddressPanel(this);
        this.dbPanel = new DatabaseNamePanel(this);
        this.usernamePanel = new UsernamePanel(this);
        this.passwordPanel = new PasswordPanel(this);
        this.loginPanel = new LoginPanel(this);

        this.add(this.ipPanel);
        this.add(this.dbPanel);
        this.add(this.usernamePanel);
        this.add(this.passwordPanel);
        this.add(this.loginPanel);
    }

    /**
     * Connect to the SQL database... when applicable.
     *
     * @return true if a connection was successful, false otherwise.
     */
    public boolean connect () {
        //  Database name (db name in remote sql).
        String instanceID = this.dbPanel.getDatabaseName();

        this.generateClassName();

        String url = String.format("jdbc:mysql://%s:3306/%s", this.ipPanel.getIPAddress(), instanceID);
        try {
            this.window.remoteDbConnection = DriverManager.getConnection(url, this.usernamePanel.getUsername(), String.valueOf(this.passwordPanel.getPassword()));
        }
        catch (SQLException ex) {
            Logger.getLogger(AccountPanel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        this.window.setWindowState(WindowState.MAIN);
        this.window.getMainScreenPanel().getTableNames();

        return true;
    }

    /**
     * Generates the necessary classname to get the MySQL java driver working.
     */
    private void generateClassName () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

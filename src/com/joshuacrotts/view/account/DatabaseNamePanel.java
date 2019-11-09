/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshuacrotts.view.account;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Joshua
 */
public class DatabaseNamePanel extends JPanel {

    private AccountPanel parentPanel;

    private JLabel database;
    private JTextField databaseField;

    public DatabaseNamePanel (AccountPanel parentPanel) {
        this.parentPanel = parentPanel;

        this.database = new JLabel("Database: ");
        this.database.setLabelFor(this.databaseField);
        this.databaseField = new JTextField(25);
        this.add(this.database);
        this.add(this.databaseField);
    }

    public String getDatabaseName () {
        return this.databaseField.getText();
    }
}

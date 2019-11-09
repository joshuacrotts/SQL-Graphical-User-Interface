/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshuacrotts.view.account;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Joshua
 */
public class UsernamePanel extends JPanel {

    private AccountPanel parentPanel;

    private JLabel username;
    private JTextField usernameField;

    public UsernamePanel (AccountPanel parentPanel) {
        this.parentPanel = parentPanel;

        this.username = new JLabel("Username: ");
        this.username.setLabelFor(this.usernameField);
        this.usernameField = new JTextField(25);
        this.add(this.username);
        this.add(this.usernameField);
    }

    public String getUsername () {
        return this.usernameField.getText();
    }
}

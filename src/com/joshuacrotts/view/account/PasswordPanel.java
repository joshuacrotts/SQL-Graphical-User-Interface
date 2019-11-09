/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshuacrotts.view.account;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 *
 * @author Joshua
 */
public class PasswordPanel extends JPanel {

    private AccountPanel parentPanel;

    private JLabel password;
    private JPasswordField passwordField;

    public PasswordPanel (AccountPanel parentPanel) {
        this.parentPanel = parentPanel;

        this.password = new JLabel("Password: ");
        this.password.setLabelFor(this.passwordField);
        this.passwordField = new JPasswordField(25);
        this.add(this.password);
        this.add(this.passwordField);
    }

    public char[] getPassword () {
        return this.passwordField.getPassword();
    }
}

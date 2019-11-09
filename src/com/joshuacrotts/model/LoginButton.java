/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshuacrotts.model;

import com.joshuacrotts.view.account.AccountPanel;
import com.joshuacrotts.view.account.LoginPanel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 *
 * @author Joshua
 */
public class LoginButton extends JButton {

    private final String text = "LOGIN";

    private final AccountPanel globalPanel;
    private final LoginPanel parentPanel;

    public LoginButton (AccountPanel globalPanel, LoginPanel parentPanel) {
        this.globalPanel = globalPanel;
        this.parentPanel = parentPanel;

        this.setText(text);
        this.setPreferredSize(new Dimension(80, 20));
        this.setMaximumSize(new Dimension(80, 20));

        this.addActionListener((ActionEvent _e) -> {
            globalPanel.connect();
        });
    }

}

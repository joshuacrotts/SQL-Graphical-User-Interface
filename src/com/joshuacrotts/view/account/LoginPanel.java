/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshuacrotts.view.account;

import com.joshuacrotts.model.LoginButton;
import javax.swing.JPanel;

/**
 *
 * @author Joshua
 */
public class LoginPanel extends JPanel {

    private final AccountPanel parentPanel;

    public LoginPanel (AccountPanel parentPanel) {
        this.parentPanel = parentPanel;
        this.add(new LoginButton(this.parentPanel, this));
    }
}

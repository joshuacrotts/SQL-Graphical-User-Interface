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
public class IPAddressPanel extends JPanel {

    private final AccountPanel parentPanel;

    private final JLabel ipAddress;
    private final JTextField ipAddressField;

    public IPAddressPanel (AccountPanel parentPanel) {
        this.parentPanel = parentPanel;
        this.ipAddress = new JLabel("IP Address: ");
        this.ipAddressField = new JTextField(25);
        this.ipAddress.setLabelFor(this.ipAddressField);

        this.add(this.ipAddress);
        this.add(this.ipAddressField);
    }

    public String getIPAddress () {
        return this.ipAddressField.getText();
    }
}

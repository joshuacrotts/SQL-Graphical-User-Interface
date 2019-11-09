/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshuacrotts.view.mainscreen;

import com.joshuacrotts.model.ConsoleTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Joshua
 */
public class ConsolePanel extends JPanel {

    private final MainScreenPanel parentPanel;

    private final JTextArea previousText;
    private final ConsoleTextField consoleText;
    private final JScrollPane scrollPane;

    public ConsolePanel (MainScreenPanel parentPanel) {
        this.parentPanel = parentPanel;
        this.setLayout(new BorderLayout());
        this.previousText = new JTextArea();
        this.consoleText = new ConsoleTextField(this.parentPanel, this);
        this.scrollPane = new JScrollPane(this.previousText);
        this.add(this.scrollPane, BorderLayout.CENTER);
        this.add(this.consoleText, BorderLayout.PAGE_END);
    }

    public void appendToTextArea (String str) {
        this.previousText.setText(this.previousText.getText() + "\n" + str);
    }
}

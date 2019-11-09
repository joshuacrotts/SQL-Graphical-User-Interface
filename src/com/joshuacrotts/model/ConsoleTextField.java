/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshuacrotts.model;

import com.joshuacrotts.view.mainscreen.ConsolePanel;
import com.joshuacrotts.view.mainscreen.MainScreenPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 *
 * @author Joshua
 */
public class ConsoleTextField extends JTextField implements KeyListener {

    private static String mandatoryString = "mysql> ";

    private MainScreenPanel globalPanel;
    private ConsolePanel parentPanel;

    public ConsoleTextField (MainScreenPanel globalPanel, ConsolePanel parentPanel) {
        this.setText(mandatoryString);
        this.globalPanel = globalPanel;
        this.parentPanel = parentPanel;

        this.addKeyListener(this);
    }

    @Override
    public void keyTyped (KeyEvent _e) {
        this.fixPrefix(this.getText());
    }

    @Override
    public void keyPressed (KeyEvent _e) {
        if (_e.getKeyCode() == KeyEvent.VK_ENTER) {
            this.parseInput(this.getText());
        }
    }

    @Override
    public void keyReleased (KeyEvent _e) {
    }

    private void parseInput (String input) {
        this.parentPanel.appendToTextArea(input);

        if (input.contains("SELECT")) {
            this.globalPanel.executeQuery(input.replaceFirst(mandatoryString, ""));
        }
    }

    private void fixPrefix (String input) {
        if (!input.startsWith(mandatoryString)) {
            this.setText(mandatoryString);
        }

    }
}

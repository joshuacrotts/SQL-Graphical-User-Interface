package com.joshuacrotts.view;

import com.joshuacrotts.view.mainscreen.MainScreenPanel;
import com.joshuacrotts.view.account.AccountPanel;
import com.joshuacrotts.main.WindowState;
import java.awt.Dimension;
import java.sql.Connection;
import javax.swing.JFrame;

/**
 *
 * @author Joshua
 */
public class SQLWindow extends JFrame {

    private WindowState windowState = WindowState.ACCOUNT;

    private final AccountPanel accountPanel;
    private final MainScreenPanel mainScreenPanel;

    public Connection remoteDbConnection;

    public SQLWindow () {
        super("SQL Graphical User Interface");

        this.accountPanel = new AccountPanel(this);
        this.mainScreenPanel = new MainScreenPanel(this);
        this.setSize(640, 240);

        this.setWindowState(this.windowState);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    public void setWindowState (WindowState state) {
        this.getContentPane().removeAll();

        switch (state) {
            case ACCOUNT:
                this.getContentPane().add(this.accountPanel);
                break;
            case MAIN:
                this.getContentPane().add(this.mainScreenPanel);
                break;
        }
        this.revalidate();
        this.pack();
    }

    @Override
    public Dimension getPreferredSize () {
        return new Dimension(1280, 720);
    }

    public AccountPanel getAccountPanel () {
        return accountPanel;
    }

    public MainScreenPanel getMainScreenPanel () {
        return mainScreenPanel;
    }

}

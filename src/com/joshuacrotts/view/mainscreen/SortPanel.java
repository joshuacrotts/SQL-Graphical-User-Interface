/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshuacrotts.view.mainscreen;

import com.joshuacrotts.model.TableSort;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Joshua
 */
public class SortPanel extends JPanel {

    private final MainScreenPanel globalPanel;
    private final InformationPanel parentPanel;

    private final TableSort tableSorter;
    private final JLabel tableSortLabel;

    public SortPanel (MainScreenPanel globalPanel, InformationPanel parentPanel) {
        this.parentPanel = parentPanel;
        this.globalPanel = globalPanel;
        this.setLayout(new FlowLayout());
        this.tableSortLabel = new JLabel("Sort By: ");
        this.tableSorter = new TableSort(parentPanel, this);
        this.tableSortLabel.setLabelFor(this.tableSorter);

        this.add(this.tableSortLabel);
        this.add(this.tableSorter);
    }

    public TableSort getTableSort () {
        return this.tableSorter;
    }
}

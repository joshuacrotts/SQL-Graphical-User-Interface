/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshuacrotts.view.mainscreen;

import com.joshuacrotts.model.TableSelect;
import com.joshuacrotts.model.TableSort;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Joshua
 */
public class TableSelectionPanel extends JPanel {

    private final MainScreenPanel globalPanel;
    private final InformationPanel parentPanel;

    private final TableSelect tableSelect;
    private final JLabel tableSelectLabel;

    public TableSelectionPanel (MainScreenPanel globalPanel, InformationPanel parentPanel) {
        this.parentPanel = parentPanel;
        this.globalPanel = globalPanel;
        this.setLayout(new FlowLayout());
        this.tableSelectLabel = new JLabel("Table: ");
        this.tableSelect = new TableSelect(parentPanel, this);
        this.tableSelectLabel.setLabelFor(this.tableSelect);

        this.add(this.tableSelectLabel);
        this.add(this.tableSelect);
    }

    public TableSelect getTableSelect () {
        return this.tableSelect;
    }
}

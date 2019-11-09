package com.joshuacrotts.model;

import com.joshuacrotts.view.mainscreen.InformationPanel;
import com.joshuacrotts.view.mainscreen.SortPanel;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Joshua
 */
public class TableSort extends JComboBox implements ItemListener {

    private final InformationPanel globalPanel;
    private final SortPanel parentPanel;

    public static String[] sortColumns;

    public TableSort (InformationPanel globalPanel, SortPanel parentPanel) {
        this.globalPanel = globalPanel;
        this.parentPanel = parentPanel;
        this.addItemListener(this);
        this.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXXXXXXXXXX");
        this.setDefaultSelection();
    }

    @Override
    public void itemStateChanged (ItemEvent event) {
        if (event.getStateChange() == ItemEvent.SELECTED) {
            System.out.println("we here");
            int sortByIndex = this.getSelectedIndex();
            this.globalPanel.getTablePanel().sortTable(sortByIndex);
        }
    }

    public void updateSortColumns (String[] columns) {
        DefaultComboBoxModel model = new DefaultComboBoxModel(columns);
        this.setModel(model);
        this.setDefaultSelection();
    }

    private void setDefaultSelection () {
        this.setRenderer(new MyComboBoxRenderer("SORT BY COLUMN"));
        this.setSelectedIndex(-1);
    }

    private class MyComboBoxRenderer extends JLabel implements ListCellRenderer {

        private String title;

        public MyComboBoxRenderer (String title) {
            this.title = title;
        }

        @Override
        public Component getListCellRendererComponent (JList list, Object value,
                int index, boolean isSelected, boolean hasFocus) {
            if (index == -1 && value == null) {
                this.setText(title);
            }
            else {
                this.setText(value.toString());
            }
            return this;
        }
    }
}

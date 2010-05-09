/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.option.gui;

import org.petah.common.option.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Petah
 */
public class OptionTableModel extends AbstractTableModel {

    @Override
    public String getColumnName(int column) {
        switch (column) {
            default:
                return "Name";
            case 1:
                return "Value";
        }
    }

    public int getColumnCount() {
        return 2;
    }

    public int getRowCount() {
        return OptionsManager.getOptions().size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Option option = (Option) OptionsManager.getOptions().values().toArray()[rowIndex];
        switch (columnIndex) {
            default:
                return option.getName();
            case 1:
                return option.getValue();
        }
    }
}

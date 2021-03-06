/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import javax.swing.AbstractAction;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author EMAX
 */
public abstract class AbstractTableAction<T extends JTable, M extends TableModel> extends AbstractAction {

    private T table;
    private M model;

    public AbstractTableAction(T table, M model) {
        this.table = table;
        this.model = model;
    }

    public T getTable() {
        return table;
    }

    public M getModel() {
        return model;
    }
}
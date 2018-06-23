/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Model.Tiers;
import java.io.Serializable;

import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author soufiane
 */
public class DefaultComboBoxModelTiers extends DefaultComboBoxModel {

    private List<Tiers> Objects;

    public DefaultComboBoxModelTiers(List<Tiers> Objects) {
        this.Objects = Objects;
    }

    protected List<Tiers> getAllElements() {
        return Objects;
    }

    public Tiers getSelectedElement() {
        return (Tiers) getSelectedItem();
    }

    @Override
    public Object getElementAt(int index) {
        return Objects.get(index);
    }

    @Override
    public int getSize() {
        return Objects.size();
    }

    @Override
    public int getIndexOf(Object element) {
        return Objects.indexOf(element);
    }

    public void addElement(Tiers element) {
        this.Objects.add(element);
        int size = this.Objects.size();
        fireIntervalAdded(this, size, size);
    }

    public void removeElement(Tiers element) {
        int position = this.Objects.indexOf(element);
        this.Objects.remove(position);
        fireIntervalRemoved(this, position, position);
    }
}

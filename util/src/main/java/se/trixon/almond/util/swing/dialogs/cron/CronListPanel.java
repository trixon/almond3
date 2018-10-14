/*
 * Copyright 2018 Patrik Karlström.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package se.trixon.almond.util.swing.dialogs.cron;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.ResourceBundle;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.apache.commons.lang3.StringUtils;
import se.trixon.almond.util.AlmondOptions;
import se.trixon.almond.util.AlmondUI;
import se.trixon.almond.util.Dict;
import se.trixon.almond.util.SystemHelper;
import se.trixon.almond.util.icons.IconColor;
import se.trixon.almond.util.icons.material.MaterialIcon;
import se.trixon.almond.util.swing.SwingHelper;
import se.trixon.almond.util.swing.dialogs.Message;

/**
 *
 * @author Patrik Karlström
 */
public class CronListPanel extends JPanel {

    private static final int ICON_SIZE = AlmondUI.ICON_SIZE_NORMAL;
    private DefaultListModel mModel = new DefaultListModel();
    private final AlmondOptions mAlmondOptions = AlmondOptions.getInstance();
    private static final String CRON_ITEM_SEPARATOR = "|";
    private final ResourceBundle mBundle = SystemHelper.getBundle(CronListPanel.class, "Bundle");

    /**
     * Creates new form EditPanel
     */
    public CronListPanel() {
        initComponents();
        init();
    }

    public DefaultListModel getModel() {
        return mModel;
    }

    public String getSelectedCronString() {
        return (String) list.getSelectedValue();
    }

    public boolean isActive() {
        return checkBox.isSelected();
    }

    public void setActive(boolean value) {
        checkBox.setSelected(value);
        list.setEnabled(checkBox.isSelected());
    }

    public String getCronItems() {
        return StringUtils.join(getModel().toArray(), CRON_ITEM_SEPARATOR);
    }

    public void setCronItems(String cronItems) {
        for (String item : StringUtils.split(cronItems, CRON_ITEM_SEPARATOR)) {
            getModel().addElement(item);
        }
    }

    public void setModel(DefaultListModel model) {
        mModel = model;
        list.setModel(model);
    }

    public void sortModel() {
        Object[] objects = mModel.toArray();
        Arrays.sort(objects);
        mModel.clear();

        for (Object object : objects) {
            mModel.addElement(object);
        }
    }

    private Component getRoot() {
        return SwingUtilities.getRoot(this);
    }

    private void edit(String cronString) {
        String title;
        boolean add = cronString == null;
        if (cronString == null) {
            title = Dict.ADD.toString();
        } else {
            title = Dict.EDIT.toString();
        }

        CronPanel cronPanel = new CronPanel();
        cronPanel.setCronString(cronString);
        SwingHelper.makeWindowResizable(cronPanel);

        int retval = JOptionPane.showOptionDialog(getRoot(),
                cronPanel,
                title,
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null);

        if (retval == JOptionPane.OK_OPTION) {
            String modifiedCronString = cronPanel.getCronString();
            if (cronPanel.isCronValid()) {
                if (add) {
                    getModel().addElement(modifiedCronString);
                } else {
                    getModel().set(getModel().indexOf(getSelectedCronString()), modifiedCronString);
                }
                sortModel();
                list.setSelectedValue(modifiedCronString, true);
            } else {
                Message.error(this, "Invalid cron string", modifiedCronString);
                edit(modifiedCronString);
            }
        }
    }

    private void init() {
        IconColor iconColor = IconColor.getDefault();

        addButton.setIcon(MaterialIcon._Content.ADD.get(ICON_SIZE, iconColor));
        editButton.setIcon(MaterialIcon._Editor.MODE_EDIT.get(ICON_SIZE, iconColor));
        removeButton.setIcon(MaterialIcon._Content.REMOVE.get(ICON_SIZE, iconColor));
        removeAllButton.setIcon(MaterialIcon._Content.CLEAR.get(ICON_SIZE, iconColor));

        setModel(getModel());
        list.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolBar = new javax.swing.JToolBar();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        removeAllButton = new javax.swing.JButton();
        checkBox = new javax.swing.JCheckBox();
        scrollPane = new javax.swing.JScrollPane();
        list = new javax.swing.JList();

        setLayout(new java.awt.BorderLayout());

        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        addButton.setToolTipText(Dict.ADD.toString());
        addButton.setFocusable(false);
        addButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        toolBar.add(addButton);

        editButton.setToolTipText(Dict.EDIT.toString());
        editButton.setFocusable(false);
        editButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        toolBar.add(editButton);

        removeButton.setToolTipText(Dict.REMOVE.toString());
        removeButton.setFocusable(false);
        removeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        removeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        toolBar.add(removeButton);

        removeAllButton.setToolTipText(Dict.REMOVE_ALL.toString());
        removeAllButton.setFocusable(false);
        removeAllButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        removeAllButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        removeAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAllButtonActionPerformed(evt);
            }
        });
        toolBar.add(removeAllButton);

        checkBox.setText(Dict.ACTIVE.toString());
        checkBox.setFocusable(false);
        checkBox.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        checkBox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        checkBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });
        toolBar.add(checkBox);

        add(toolBar, java.awt.BorderLayout.PAGE_START);

        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(list);

        add(scrollPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (isActive()) {
            edit(null);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        if (getSelectedCronString() != null && isActive()) {
            edit(getSelectedCronString());
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2 && isActive()) {
            editButtonActionPerformed(null);
        }
    }//GEN-LAST:event_listMouseClicked

    private void removeAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAllButtonActionPerformed
        if (!getModel().isEmpty()) {
            int retval = JOptionPane.showConfirmDialog(getRoot(),
                    mBundle.getString("CronPanel.message.removeAll"),
                    mBundle.getString("CronPanel.title.removeAll"),
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (retval == JOptionPane.OK_OPTION) {
                getModel().removeAllElements();
            }
        }
    }//GEN-LAST:event_removeAllButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        if (getSelectedCronString() != null && isActive()) {
            String message = String.format(mBundle.getString("CronPanel.message.remove"), getSelectedCronString());
            int retval = JOptionPane.showConfirmDialog(getRoot(),
                    message,
                    mBundle.getString("CronPanel.title.remove"),
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (retval == JOptionPane.OK_OPTION) {
                getModel().removeElement(getSelectedCronString());
            }
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void checkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxActionPerformed
        list.setEnabled(checkBox.isSelected());
    }//GEN-LAST:event_checkBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton addButton;
    protected javax.swing.JCheckBox checkBox;
    protected javax.swing.JButton editButton;
    protected javax.swing.JList list;
    protected javax.swing.JButton removeAllButton;
    protected javax.swing.JButton removeButton;
    protected javax.swing.JScrollPane scrollPane;
    protected javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
}

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
package se.trixon.almond.util.swing;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author Patrik Karlström
 */
public class LogPanel extends javax.swing.JPanel {

    private final DefaultCaret mCaret;

    /**
     * Creates new form LogPanel
     */
    public LogPanel() {
        initComponents();
        mCaret = (DefaultCaret) textArea.getCaret();
        mCaret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }

    synchronized public void clear() {
        textArea.setText("");
    }

    public String getText() {
        return textArea.getText();
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    synchronized public void println(final String string) {
        SwingUtilities.invokeLater(() -> {
            textArea.append(string + "\n");
        });
    }

    public void scrollToBottom() {
        setCaretPosition(textArea.getText().length());
    }

    public void scrollToTop() {
        setCaretPosition(0);
    }

    private void setCaretPosition(int pos) {
        SwingUtilities.invokeLater(() -> {
            textArea.setCaretPosition(pos);
        });
    }

    public void setWordWrap(boolean value) {
        textArea.setWrapStyleWord(value);
        textArea.setLineWrap(value);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        textArea.setLineWrap(true);
        textArea.setRows(5);
        textArea.setWrapStyleWord(true);
        scrollPane.setViewportView(textArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
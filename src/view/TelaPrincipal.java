/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import actions.DeleteRowFromTableAction;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import data.Data;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas
 */
public class TelaPrincipal extends javax.swing.JFrame {
    DefaultTableModel modelModalidade = new DefaultTableModel();
    DefaultTableModel modelEsporte = new DefaultTableModel();
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        
        Data data1 = new Data();
        
        String[] columnNames = {"First Name",
                                "Last Name",
                                "Sport",
                                "# of Years",
                                "Vegetarian"};
        
        Object[][] data = {
            {"Kathy", "Smith",
             "Snowboarding", new Integer(5), new Boolean(false)},
            {"John", "Doe",
             "Rowing", new Integer(3), new Boolean(true)},
            {"Sue", "Black",
             "Knitting", new Integer(2), new Boolean(false)},
            {"Jane", "White",
             "Speed reading", new Integer(20), new Boolean(true)},
            {"Joe", "Brown",
             "Pool", new Integer(10), new Boolean(false)}
        };
        
        Object[][] data2 = {
            {"Kathy", "Smith",
             "Snowboarding", new Integer(5), new Boolean(false)},
            {"Kathy", "Smith",
             "Snowboarding", new Integer(3), new Boolean(true)},
            {"Kathy", "Smith",
             "Snowboarding", new Integer(2), new Boolean(false)},
            {"Kathy", "Smith",
             "Snowboarding", new Integer(20), new Boolean(true)},
            {"Kathy", "Smith",
             "Snowboarding", new Integer(10), new Boolean(false)}
        };
        
        configureTabModalidade(data, columnNames);
        configureTabEsporte(data2, columnNames);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAdd.setText("Adicionar");
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setLabel("Remover");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report.png"))); // NOI18N
        jMenu3.setText("Relatorio");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        jMenuItem4.setText("Atletas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 310, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemove)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        System.out.println(jTabbedPane1.getSelectedIndex());
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        JScrollPane scrollRef = (JScrollPane) jTabbedPane1.getSelectedComponent();
        JTable tableRef = (JTable) scrollRef.getViewport().getComponents()[0];
        DeleteRowFromTableAction deleteAction = null;
        if (jTabbedPane1.getSelectedIndex() == 0)
            deleteAction = new DeleteRowFromTableAction(tableRef, modelModalidade);
        else if (jTabbedPane1.getSelectedIndex() == 1)
            deleteAction = new DeleteRowFromTableAction(tableRef, modelEsporte);
        deleteAction.actionPerformed(evt);
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Document document = new Document();

        try{
            PdfWriter.getInstance(document, new FileOutputStream("relatorio.pdf"));

            document.open();
            document.add(new Paragraph("Paragrafo 1"));
            document.add(new Paragraph("Paragrafo 2"));
            document.add(new Paragraph("Paragrafo 3"));
        } catch (DocumentException | FileNotFoundException ex) {
            System.out.println("Error:"+ex);
        } finally {
            document.close();
        }

        try {
            Desktop.getDesktop().open(new File("relatorio.pdf"));
        } catch (IOException ex) {
            System.out.println("Error:"+ex);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    private void configureTabModalidade(Object[][] data, String[] columnNames) {
        
        for (int index = 0; index < columnNames.length; index++) {
            modelModalidade.addColumn(columnNames[index]);
        }
        for (int row = 0; row < data.length; row++) {
            Vector<Object> rowData = new Vector<>(columnNames.length);
            for (int col = 0; col < columnNames.length; col++) {
                rowData.add(data[row][col]);
            }
            modelModalidade.addRow(rowData);
        }
        
        JTable table = new JTable(modelModalidade);
        table.getSelectionModel().addListSelectionListener((ListSelectionEvent evt) -> {
            if(!evt.getValueIsAdjusting()){
                JFrame frame = new TelaNovoEditarModalidade();
                frame.setVisible(true);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
            }
        });
        JScrollPane scroll = new JScrollPane(table);
        jTabbedPane1.add("Modalidade", scroll);
        
        DeleteRowFromTableAction deleteAction = new DeleteRowFromTableAction(table, modelModalidade);
        InputMap im = table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap am = table.getActionMap();
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "deleteRow");
        am.put("deleteRow", deleteAction);
    }
    
    private void configureTabEsporte(Object[][] data, String[] columnNames) {
        for (int index = 0; index < columnNames.length; index++) {
            modelEsporte.addColumn(columnNames[index]);
        }
        for (int row = 0; row < data.length; row++) {
            Vector<Object> rowData = new Vector<>(columnNames.length);
            for (int col = 0; col < columnNames.length; col++) {
                rowData.add(data[row][col]);
            }
            modelEsporte.addRow(rowData);
        }
        
        JTable table = new JTable(modelEsporte);
        table.getSelectionModel().addListSelectionListener((ListSelectionEvent evt) -> {
            if(!evt.getValueIsAdjusting()){
                JFrame frame = new TelaNovoEditarEsporte();
                frame.setVisible(true);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
            }
        });
        JScrollPane scroll = new JScrollPane(table);
        jTabbedPane1.add("Esporte", scroll);
        
        DeleteRowFromTableAction deleteAction = new DeleteRowFromTableAction(table, modelEsporte);
        InputMap im = table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap am = table.getActionMap();
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "deleteRow");
        am.put("deleteRow", deleteAction);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iloan.utilities;

import de.javasoft.swing.JYTableHeader;
import de.javasoft.swing.jytable.renderer.CellLayoutHint;
import iloan.kernel.Utilities;
import java.awt.Point;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author mrogers
 */
public class FrmSalutationList extends javax.swing.JInternalFrame
{

    /**
     * Creates new form FrmSalutationList
     */
    public FrmSalutationList()
    {
        initComponents();
        populateLists();
    }

    private void populateLists()
    {

        tblSalutation.setModel(SalutationList.getSalutationTable());
        JYTableHeader header = (JYTableHeader) tblSalutation.getTableHeader();
        CellLayoutHint hint = header.getCellLayoutHint();
        //center header text
        header.setCellLayoutHint(new CellLayoutHint(hint.sortMarkerPosition, SwingConstants.CENTER, hint.verticalAlignment));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jYTableScrollPane1 = new de.javasoft.swing.JYTableScrollPane();
        tblSalutation = new de.javasoft.swing.JYTable();
        cmdAdd = new javax.swing.JButton();
        cmdEnable = new javax.swing.JButton();
        cmdDisable = new javax.swing.JButton();
        cmdClose = new javax.swing.JButton();
        cmdRefresh = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Manage Salutation List");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/iloan/resources/database_table.png"))); // NOI18N

        tblSalutation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Salutation", "Status"
            }
        ));
        tblSalutation.setColumnControlVisible(false);
        tblSalutation.setFillsViewportHeight(false);
        jYTableScrollPane1.setViewportView(tblSalutation);
        tblSalutation.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        cmdAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iloan/resources/add.png"))); // NOI18N
        cmdAdd.setText("Add");
        cmdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddActionPerformed(evt);
            }
        });

        cmdEnable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iloan/resources/accept.png"))); // NOI18N
        cmdEnable.setText("Enable");
        cmdEnable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEnableActionPerformed(evt);
            }
        });

        cmdDisable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iloan/resources/delete.png"))); // NOI18N
        cmdDisable.setText("Disable");
        cmdDisable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDisableActionPerformed(evt);
            }
        });

        cmdClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iloan/resources/cross.png"))); // NOI18N
        cmdClose.setText("Close");
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        cmdRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iloan/resources/arrow_refresh.png"))); // NOI18N
        cmdRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jYTableScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(cmdAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdEnable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdDisable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdClose)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jYTableScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdClose)
                    .addComponent(cmdDisable)
                    .addComponent(cmdAdd)
                    .addComponent(cmdEnable)
                    .addComponent(cmdRefresh))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cmdCloseActionPerformed
    {//GEN-HEADEREND:event_cmdCloseActionPerformed
        Utilities.showCancelScreen(this);
    }//GEN-LAST:event_cmdCloseActionPerformed

    private void cmdDisableActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cmdDisableActionPerformed
    {//GEN-HEADEREND:event_cmdDisableActionPerformed
        if (tblSalutation.getSelectedRow() != -1)
        {
            String message = "Are you sure you want to disable the selected item(s)?";
            int response = Utilities.showConfirmDialog(rootPane, message);
            if (response == JOptionPane.YES_OPTION)
            {
                for (int rowID : tblSalutation.getSelectedRows())
                {
                    String salID = tblSalutation.getValueAt(rowID, 0).toString();
                    SalutationList.disableSalutation(salID);
                }
                populateLists();
            }
        }
        else
        {
            String message = "Kindly select an item to remove first.";
            Utilities.showErrorMessage(rootPane, message);
        }
    }//GEN-LAST:event_cmdDisableActionPerformed

    private void cmdEnableActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cmdEnableActionPerformed
    {//GEN-HEADEREND:event_cmdEnableActionPerformed
        if (tblSalutation.getSelectedRow() != -1)
        {
            String message = "Are you sure you want to enable the selected item(s)?";
            int response = Utilities.showConfirmDialog(rootPane, message);
            if (response == JOptionPane.YES_OPTION)
            {
                for (int rowID : tblSalutation.getSelectedRows())
                {
                    String salID = tblSalutation.getValueAt(rowID, 0).toString();
                    SalutationList.enableSalutation(salID);
                }
                populateLists();
            }
        }
        else
        {
            String message = "Kindly select an item to enable first.";
            Utilities.showErrorMessage(rootPane, message);
        }
    }//GEN-LAST:event_cmdEnableActionPerformed

    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cmdAddActionPerformed
    {//GEN-HEADEREND:event_cmdAddActionPerformed
        
        String name = JOptionPane.showInputDialog("Salutation");
        
        if (name == null)
        {
            return;
        }
        
        if (name.trim().isEmpty())
        {
            name = "Kindly enter a title for the entry.";
            Utilities.showWarningMessage(rootPane, name);
            return;
        }
        int result = SalutationList.addSalutation(name);
        String message = "";
        switch (result)
        {
            case -1:
                message = "An error occurred while trying to add a new item to the list.\n"
                        + "Kindly verify your input and try again.";
                Utilities.showErrorMessage(rootPane, message);
                break;

            case 0:
                message = "The item was successfully added.";
                Utilities.showInfoMessage(rootPane, message);
                break;

            case 1:
                message = "An error occurred while trying to add a new item to the list.\n"
                        + "Kindly verify your input and try again.";
                Utilities.showErrorMessage(rootPane, message);
                break;

            case 2:
                message = "That item is already in the list.\n"
                        + "Kindly verify your input and try again.";
                Utilities.showErrorMessage(rootPane, message);
                break;

            default:
                message = "An error occurred while trying to add a new item to the list.\n"
                        + "Kindly verify your input and try again.";
                Utilities.showErrorMessage(rootPane, message);
                break;
        }
        populateLists();
    }//GEN-LAST:event_cmdAddActionPerformed

    private void cmdRefreshActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cmdRefreshActionPerformed
    {//GEN-HEADEREND:event_cmdRefreshActionPerformed
        populateLists();
    }//GEN-LAST:event_cmdRefreshActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAdd;
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdDisable;
    private javax.swing.JButton cmdEnable;
    private javax.swing.JButton cmdRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private de.javasoft.swing.JYTableScrollPane jYTableScrollPane1;
    private de.javasoft.swing.JYTable tblSalutation;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iloan;

import iloan.kernel.EncryptionHandler;
import iloan.kernel.Utilities;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author mrogers
 */
public class SettingsEditor extends javax.swing.JFrame
{

    boolean connectionTested = false;
    Properties properties = new Properties();

    /**
     * Creates new form SettingsEditor
     */
    public SettingsEditor()
    {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/ruby.png"));
        loadCurrentSettings();
    }

    private void loadCurrentSettings()
    {
        try
        {
            properties.load(new FileInputStream("conf/iLoan.properties"));
            String dbLocation = EncryptionHandler.decrypt(properties.getProperty("dbLocation"));
            String dbUser = EncryptionHandler.decrypt(properties.getProperty("dbUser"));
            String dbPass = EncryptionHandler.decrypt(properties.getProperty("dbPass"));
            txtUser.setText(dbUser);
            txtPassword.setText(dbPass);
            dbLocation = dbLocation.substring(13);
            String[] split = dbLocation.split("/");
            txtServer.setText(split[0]);
            txtDatabase.setText(split[1]);
        }
        catch (Exception ex)
        {
            Logger.getLogger(SettingsEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        lblImage = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblServer = new javax.swing.JLabel();
        txtServer = new javax.swing.JTextField();
        lblDatabase = new javax.swing.JLabel();
        txtDatabase = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        lblUser = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblPassword = new javax.swing.JLabel();
        cmdClose = new javax.swing.JButton();
        cmdSave = new javax.swing.JButton();
        cmdTestConn = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("iLoan Database Settings Editor");
        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iloan/resources/Logo-No-BG.png"))); // NOI18N
        lblTitle.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Database Settings Editor");
        lblServer.setText("Server Name / IP:");
        lblDatabase.setText("Database Name:");
        lblUser.setText("User:");
        lblPassword.setText("Password:");
        cmdClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iloan/resources/cross.png"))); // NOI18N
        cmdClose.setText("Close");
        cmdClose.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmdCloseActionPerformed(evt);
            }
        });
        cmdSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iloan/resources/accept.png"))); // NOI18N
        cmdSave.setText("Save");
        cmdSave.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmdSaveActionPerformed(evt);
            }
        });
        cmdTestConn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iloan/resources/connect.png"))); // NOI18N
        cmdTestConn.setText("Test Connection");
        cmdTestConn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmdTestConnActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                      .addContainerGap()
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                  .addComponent(lblServer)
                                                  .addComponent(lblDatabase)
                                                  .addComponent(lblUser)
                                                  .addComponent(lblPassword))
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                  .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                                                  .addComponent(txtUser, javax.swing.GroupLayout.Alignment.TRAILING)
                                                  .addComponent(txtDatabase)
                                                  .addComponent(txtServer)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                          .addComponent(cmdTestConn)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(cmdSave)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                          .addComponent(cmdClose)))
                      .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                      .addContainerGap()
                      .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addComponent(lblTitle)
                      .addGap(18, 18, 18)
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblServer)
                                .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblDatabase)
                                .addComponent(txtDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblUser))
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPassword))
                      .addGap(18, 18, Short.MAX_VALUE)
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmdClose)
                                .addComponent(cmdSave)
                                .addComponent(cmdTestConn))
                      .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cmdCloseActionPerformed
    {
//GEN-HEADEREND:event_cmdCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cmdCloseActionPerformed

    private void cmdTestConnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cmdTestConnActionPerformed
    {
//GEN-HEADEREND:event_cmdTestConnActionPerformed
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbServer = txtServer.getText().trim();
        String dbName = txtDatabase.getText().trim();
        String dbLocation = "jdbc:mysql://" + dbServer + "/" + dbName;
        String dbUser = txtUser.getText().trim();
        String dbPass = String.valueOf(txtPassword.getPassword());
        //Try to connect to the database
        try
        {
            //Create database connection objects.
            Class.forName(dbDriver); //set the database driver
            Connection dbConnection = DriverManager.getConnection(dbLocation, dbUser, dbPass);
            String message = "Successfully connected to the database.";
            Utilities.showInfoMessage(rootPane, message);
            connectionTested = true;
        }
        catch (Exception ex)
        {
            String message = "An error occurred while connecting to the database.\n"
                             + "Kindly check with your system administrator.";
            Utilities.showErrorMessage(rootPane, message);
        }
    }//GEN-LAST:event_cmdTestConnActionPerformed

    private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cmdSaveActionPerformed
    {
//GEN-HEADEREND:event_cmdSaveActionPerformed
        if (!connectionTested)
        {
            String message = "Kindly test the connection setting you have entered before saving.";
            Utilities.showWarningMessage(rootPane, message);
            return;
        }
        String message = "Are you sure you want to save these changes to the config file?";
        int response = Utilities.showConfirmDialog(rootPane, message);
        if (response == JOptionPane.YES_OPTION)
        {
            String dbDriver = "com.mysql.jdbc.Driver";
            String dbServer = txtServer.getText().trim();
            String dbName = txtDatabase.getText().trim();
            String dbLocation = "jdbc:mysql://" + dbServer + "/" + dbName;
            String dbUser = txtUser.getText().trim();
            String dbPass = String.valueOf(txtPassword.getPassword());
            try
            {
                properties.setProperty("dbLocation", EncryptionHandler.encrypt(dbLocation));
                properties.setProperty("dbUser", EncryptionHandler.encrypt(dbUser));
                properties.setProperty("dbPass", EncryptionHandler.encrypt(dbPass));
                properties.store(new FileOutputStream("conf/iLoan.properties"), "Database config settings for iLoan");
                message = "Settings were successfully saved.";
                Utilities.showInfoMessage(rootPane, message);
            }
            catch (Exception e)
            {
                message = "An error occurred."
                          + "\nCould not read the application's settings."
                          + "\n\nKindly consult the system administrator.";
                Utilities.showErrorMessage(rootPane, message);
            }
        }
    }//GEN-LAST:event_cmdSaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code ">
        try
        {
            String[] li =
            {
                "Licensee=Maurice Rogers", "LicenseRegistrationNumber=------", "Product=Synthetica", "LicenseType=Non Commercial", "ExpireDate=--.--.----", "MaxVersion=2.999.999"
            };
            UIManager.put("Synthetica.license.info", li);
            UIManager.put("Synthetica.license.key", "2BCF99E0-3738913D-F30B5EC9-622511CC-4F19572A");
            javax.swing.UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel");
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(SettingsEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(SettingsEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(SettingsEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(SettingsEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new SettingsEditor().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdSave;
    private javax.swing.JButton cmdTestConn;
    private javax.swing.JLabel lblDatabase;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblServer;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextField txtDatabase;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtServer;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}

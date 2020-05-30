package gui;

import com.mybank.data.DataSource;
import com.mybank.domain.Account;
import com.mybank.domain.Bank;
import com.mybank.domain.CheckingAccount;
import com.mybank.domain.Customer;

import javax.swing.*;
import java.io.IOException;


public class BankForm extends javax.swing.JFrame {


    public BankForm() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        showButton = new javax.swing.JButton();
        reportButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();
        customersBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        info = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyBank Clients");
        setLocation(new java.awt.Point(400, 400));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        showButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        showButton.setForeground(new java.awt.Color(51, 51, 255));
        showButton.setText("Show");
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        reportButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        reportButton.setForeground(new java.awt.Color(255, 0, 0));
        reportButton.setText("Report");
        reportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportButtonActionPerformed(evt);
            }
        });

        aboutButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        aboutButton.setForeground(new java.awt.Color(0, 153, 51));
        aboutButton.setText("About");
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });

        customersBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customersBoxActionPerformed(evt);
            }
        });

        info.setContentType("text/html"); // NOI18N
        jScrollPane1.setViewportView(info);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(customersBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(showButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reportButton, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(aboutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showButton)
                    .addComponent(customersBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(reportButton)
                        .addGap(18, 18, 18)
                        .addComponent(aboutButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        
        StringBuilder repcust = new StringBuilder();
                
            Customer current = Bank.getCustomer(customersBox.getSelectedIndex());
            
            repcust.append("<br>&nbsp;<b><span style=\"font-size:2em;\">").append(current.getFirstName()).append(", ").append(current.getLastName()).append("</span><br><hr>");                                                  

            for (int k = 0; k < current.getNumberOfAccounts(); k++) {
                
            Account account = current.getAccount(k);
            
            repcust.append("\n").append("&nbsp;<b>Acc Type: </b>").append(account instanceof CheckingAccount ? "Checking " : "Savings ").append("\n").append("<br>&nbsp;<b>Balance: <span style=\"color:blue;\">$").append(account.getBalance()).append("</span></b><br>");
                 
            }info.setText(repcust.toString());        
    }//GEN-LAST:event_showButtonActionPerformed

    private void reportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportButtonActionPerformed
        
         StringBuilder repcust = new StringBuilder();
         
            for(int j = 0; j < Bank.getNumberOfCustomers(); j++){
                
                Customer current = Bank.getCustomer(j);
                
                repcust.append("<br>&nbsp;<b><span style=\"font-size:2em;\">").append(current.getFirstName()).append(", ").append(current.getLastName()).append("</span><br><hr>");                                                  

                for (int i = 0; i < current.getNumberOfAccounts(); i++) {
                
                Account account = current.getAccount(i);
            
                repcust.append("\n").append("&nbsp;<b>Acc Type: </b>").append(account instanceof CheckingAccount ? "Checking " : "Savings ").append("\n").append("<br>&nbsp;<b>Balance: <span style=\"color:red;\">$").append(account.getBalance()).append("</span></b><br>");
                
            }
            
        }info.setText(repcust.toString());
    }//GEN-LAST:event_reportButtonActionPerformed

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        JOptionPane.showMessageDialog(this, "Matisse!!! My Bank Clients");
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void customersBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customersBoxActionPerformed
    }//GEN-LAST:event_customersBoxActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
         DataSource dataSource = new DataSource("data/test.dat");
        
        try {
            
            dataSource.loadData();
            
            for (int g = 0; g < Bank.getNumberOfCustomers(); g++) {
                
                Customer customer = Bank.getCustomer(g);
                
                customersBox.addItem((new StringBuilder()).append(customer.getFirstName()).append(" ").append(customer.getLastName()).toString());
            }
            
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(BankForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BankForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BankForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BankForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BankForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButton;
    private javax.swing.JComboBox<String> customersBox;
    private javax.swing.JEditorPane info;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton reportButton;
    private javax.swing.JButton showButton;
    // End of variables declaration//GEN-END:variables
}

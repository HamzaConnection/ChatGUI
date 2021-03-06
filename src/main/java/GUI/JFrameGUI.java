/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Socket.Connect;
import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingWorker;

/**
 *
 * @author HamzaLaroussi
 */
public class JFrameGUI extends javax.swing.JFrame
{

    Connect con = Connect.getInstance();
    Scanner scan = null;
    PrintWriter write = null;

    private void startSwingWorker()
    {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>()
        {
            @Override
            protected Void doInBackground()
            {
                try
                {
                    if (con.getSocket() == null)
                    {
                        System.out.println("Socket is null");
                        return null;
                    }
                    scan = new Scanner(con.getSocket().getInputStream());
                } catch (Exception ex)
                {
                    System.out.println("Scanner exception" + ex);
                }
                String msg = "";
                while (true)
                {
                    try
                    {
                        msg += scan.nextLine() + "\n";
                        chat.setText(msg);

                    } catch (Exception ex)
                    {
                        System.out.println(ex);
                    }

                }

            }
        };

        worker.execute();
    }

    public void sendmessage()
    {
        SwingWorker<Void, Void> worker2 = new SwingWorker<Void, Void>()
        {
            @Override
            protected Void doInBackground()
            {
                try
                {
                    if (con.getSocket() == null)
                    {
                        System.out.println("Socket is null");
                        return null;
                    }
                    write = new PrintWriter(con.getSocket().getOutputStream(),true);

                } catch (Exception ex)
                {
                    System.out.println("creating the printwriter" + ex);
                }
                String msg = "";

                try
                {
                    msg = message.getText();
                    message.setText("");
                    System.out.println(msg);
                    write.println(msg);
                } catch (Exception ex)
                {
                    System.out.println("Writer exception " + ex);
                }

                return null;

            }
        };

        worker2.execute();
    }

    public void logout()
    {
        SwingWorker<Void, Void> worker3 = new SwingWorker<Void, Void>()
        {
            @Override
            protected Void doInBackground()
            {
                try
                {
                    if (con.getSocket() == null)
                    {
                        System.out.println("Socket is null");
                        return null;
                    }
                    write = new PrintWriter(con.getSocket().getOutputStream(),true);

                } catch (Exception ex)
                {
                    System.out.println("creating the printwriter" + ex);
                }
                

                try
                {
                    System.out.println("Before writting ");
                    write.println("LOGOUT:");
                    System.exit(0);
                    
                } catch (Exception ex)
                {
                    System.out.println("Writer exception " + ex);
                }

                return null;

            }
        };

        worker3.execute();
    }

    /**
     * Creates new form JFrameGUI
     */
    public JFrameGUI()
    {
        initComponents();

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

        labelUsername = new javax.swing.JLabel();
        textFieldIP = new javax.swing.JTextField();
        buttonConnect = new javax.swing.JButton();
        buttonDisconnect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        message = new javax.swing.JTextArea();
        buttonSend = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        chat = new javax.swing.JTextArea();
        textFieldPort = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelUsername.setText("IP:");

        textFieldIP.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                textFieldIPActionPerformed(evt);
            }
        });

        buttonConnect.setText("Connect");
        buttonConnect.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonConnectActionPerformed(evt);
            }
        });

        buttonDisconnect.setText("Disconnect");
        buttonDisconnect.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonDisconnectActionPerformed(evt);
            }
        });

        message.setColumns(20);
        message.setLineWrap(true);
        message.setRows(5);
        jScrollPane1.setViewportView(message);

        buttonSend.setText("Send");
        buttonSend.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonSendActionPerformed(evt);
            }
        });

        chat.setEditable(false);
        chat.setColumns(20);
        chat.setLineWrap(true);
        chat.setRows(5);
        jScrollPane2.setViewportView(chat);

        textFieldPort.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                textFieldPortActionPerformed(evt);
            }
        });

        jLabel2.setText("Port:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelUsername)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldIP, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDisconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSend, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonConnect)
                    .addComponent(buttonDisconnect)
                    .addComponent(textFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonSend, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldIPActionPerformed

    private void buttonDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDisconnectActionPerformed
        logout();

    }//GEN-LAST:event_buttonDisconnectActionPerformed

    private void buttonConnectActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonConnectActionPerformed
    {//GEN-HEADEREND:event_buttonConnectActionPerformed

        String ipInput = textFieldIP.getText();
        int portInput = Integer.parseInt(textFieldPort.getText());
        con.connect(ipInput, portInput);
        startSwingWorker();


    }//GEN-LAST:event_buttonConnectActionPerformed

    private void textFieldPortActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_textFieldPortActionPerformed
    {//GEN-HEADEREND:event_textFieldPortActionPerformed

// TODO add your handling code here:
    }//GEN-LAST:event_textFieldPortActionPerformed

    private void buttonSendActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonSendActionPerformed
    {//GEN-HEADEREND:event_buttonSendActionPerformed
        sendmessage();
    }//GEN-LAST:event_buttonSendActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(JFrameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(JFrameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(JFrameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(JFrameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new JFrameGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonConnect;
    private javax.swing.JButton buttonDisconnect;
    private javax.swing.JButton buttonSend;
    private javax.swing.JTextArea chat;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JTextArea message;
    private javax.swing.JTextField textFieldIP;
    private javax.swing.JTextField textFieldPort;
    // End of variables declaration//GEN-END:variables
}

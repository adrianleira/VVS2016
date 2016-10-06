/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ER1301.joinMe.view;

import ER1301.joinMe.model.Usuario;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author alex030293
 */
public class mainForm extends javax.swing.JFrame {

    private void reloadWall(){
        Usuario u = (Main.tempUser == null) ? Main.logedInUser : Main.tempUser;
        String[] wall = u.getWall().toArray(new String[u.getWall().size()]);

        wallList.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return wall.length; }
            public Object getElementAt(int i) { return wall[i]; }
        });
        setLocationRelativeTo(null);
    }
    /**
     * Creates new form mainForm
     */
    public mainForm() {
        initComponents();
        statusText.setForeground(java.awt.Color.GRAY);
        statusTextField.setForeground(java.awt.Color.GRAY);
        statusText.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (statusText.getText().equals("Nueva frase de estado")) {
                    statusText.setText("");
                    statusText.setForeground(java.awt.Color.BLACK);
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (statusText.getText().equals("")) {
                    statusText.setText("Nueva frase de estado");
                    statusText.setForeground(java.awt.Color.GRAY);
                }
            }
        });
        
        statusTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (statusTextField.getText().equals("Escribir entrada en muro")) {
                    statusTextField.setText("");
                    statusTextField.setForeground(java.awt.Color.BLACK);
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (statusTextField.getText().equals("")) {
                    statusTextField.setText("Escribir entrada en muro");
                    statusTextField.setForeground(java.awt.Color.GRAY);
                }
            }
        });
        
        publicarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.logedInUser.post(statusTextField.getText());
                reloadWall();
            }
        }); 
        
        ActionListener showFriends = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    misAmigosForm.main(null);
                    dispose();
            }
        }; 
        
        myFriendsButton.addActionListener(showFriends);
        
        
        ActionListener showContestList = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    concursoForm.main(null);
                    dispose();
            }
        }; 
        
        showContestForm.addActionListener(showContestList);
        
        
        
        
        ActionListener showUsers = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    usersForm.main(null);
                    dispose();
            }
        }; 
        
        usersButton.addActionListener(showUsers);
        
        // NEW
        ActionListener showGroups = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    grupoDifusionForm.main(null);
                    dispose();
            }
        }; 
        
        broadcastGroups.addActionListener(showGroups);
        
        //NEW
        
        ActionListener logOut = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Main.logedInUser = null;
                    loginForm.main(null);
                    dispose();
            }
        }; 
        
        logOutButton.addActionListener(logOut);
        homeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Main.tempUser = null;
                    mainForm.main(null);
                    dispose();
                }
        });
        
        showNotificationsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    notificationsForm.main(null);
                    dispose();
                }
        });
        
        notificaciones.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    if(Main.logedInUser.getFriends().indexOf(Main.tempUser) > -1){
                        //Remove friend
                        Main.logedInUser.getFriends().remove(Main.tempUser);
                    }else{
                        Main.tempUser.notify(Main.logedInUser.getName() + " te ha enviado una solicitud de amistad");
                    }
                    
                    Main.tempUser = null; //Comment this line out to stay in user's wall after action
                    mainForm.main(null);
                    dispose();
                }
        });
        
        
//Set user actual name and position
        if(Main.tempUser == null){
            homeButton.hide();
            notificaciones.hide();
            showNotificationsButton.show();
            nameLabel.setText(Main.logedInUser.getName() + " " + Main.logedInUser.getSurname());
            positionLabel.setText("Puesto de trabajo");
        }else{
            notificaciones.show();
            if(Main.logedInUser.getFriends().indexOf(Main.tempUser) > -1){
                notificaciones.setText("Eliminar amistad");
            }else{
                notificaciones.setText("Solicitar amistad");
            }
            homeButton.show();
            showNotificationsButton.hide();
            nameLabel.setText(Main.tempUser.getName() + " " + Main.tempUser.getSurname());
            positionLabel.setText("Puesto de trabajo");
        }
        reloadWall();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statusText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        postButtonState = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        positionLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        wallList = new javax.swing.JList();
        publicarButton = new javax.swing.JButton();
        statusTextField = new javax.swing.JTextField();
        usersButton = new javax.swing.JButton();
        showNotificationsButton = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        myFriendsButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLabel11 = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        notificaciones = new javax.swing.JButton();
        broadcastGroups = new javax.swing.JButton();
        showContestForm = new javax.swing.JButton();

        statusText.setText("Nueva frase de estado");
        statusText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusTextActionPerformed(evt);
            }
        });

        jLabel1.setText("¿Cómo te va el día?");

        postButtonState.setText("Publicar");

        jLabel8.setText("Archivos");

        jLabel7.setText("Publicidad");

        jButton5.setText("Editar perfil");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ER1301/joinMe/view/img/advert.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ER1301/joinMe/view/img/profile.jpg"))); // NOI18N

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(608, 500));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ER1301/joinMe/view/img/profile.jpg"))); // NOI18N

        jButton2.setText("Añadir archivo");

        nameLabel.setText("Eduardo Mosqueira");

        positionLabel.setText("Profesor en Universidad de A Coruña");

        jLabel5.setText("Muro");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ER1301/joinMe/view/img/profile.jpg"))); // NOI18N
        jScrollPane2.setViewportView(jLabel9);

        wallList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(wallList);

        publicarButton.setText("Publicar");
        publicarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publicarButtonActionPerformed(evt);
            }
        });

        statusTextField.setText("Escribir entrada en muro");
        statusTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusTextFieldActionPerformed(evt);
            }
        });

        usersButton.setText("Usuarios");

        showNotificationsButton.setText("Notificaciones");

        jButton6.setText("Editar perfil");

        myFriendsButton.setText("Amigos");
        myFriendsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myFriendsButtonActionPerformed(evt);
            }
        });

        logOutButton.setText("Cerrar Sesión");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ER1301/joinMe/view/img/profile.jpg"))); // NOI18N
        jScrollPane3.setViewportView(jLabel11);

        homeButton.setText("Inicio");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        notificaciones.setText("Notificaciones");
        notificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notificacionesActionPerformed(evt);
            }
        });

        broadcastGroups.setText("Grupos de Difusión");
        broadcastGroups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                broadcastGroupsActionPerformed(evt);
            }
        });

        showContestForm.setText("Concursos");
        showContestForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showContestFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusTextField)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(homeButton)
                                .addGap(49, 49, 49)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(publicarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)
                            .addComponent(positionLabel)
                            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(notificaciones)
                                    .addComponent(broadcastGroups)
                                    .addComponent(showContestForm)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(showNotificationsButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                        .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                        .addComponent(myFriendsButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(usersButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(29, 29, 29))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(notificaciones))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(showNotificationsButton)
                            .addComponent(broadcastGroups))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(myFriendsButton))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(showContestForm)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(positionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(statusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(usersButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(logOutButton)
                            .addComponent(publicarButton)
                            .addComponent(jButton2)
                            .addComponent(homeButton))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mi perfil", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Mi perfil");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void statusTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusTextActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeButtonActionPerformed

    private void statusTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusTextFieldActionPerformed

    private void publicarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publicarButtonActionPerformed

    }//GEN-LAST:event_publicarButtonActionPerformed

    private void notificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notificacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notificacionesActionPerformed

    private void broadcastGroupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_broadcastGroupsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_broadcastGroupsActionPerformed

    private void myFriendsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myFriendsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myFriendsButtonActionPerformed

    private void showContestFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showContestFormActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showContestFormActionPerformed

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
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton broadcastGroups;
    private javax.swing.JButton homeButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton myFriendsButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton notificaciones;
    private javax.swing.JLabel positionLabel;
    private javax.swing.JButton postButtonState;
    private javax.swing.JButton publicarButton;
    private javax.swing.JButton showContestForm;
    private javax.swing.JButton showNotificationsButton;
    private javax.swing.JTextField statusText;
    private javax.swing.JTextField statusTextField;
    private javax.swing.JButton usersButton;
    private javax.swing.JList wallList;
    // End of variables declaration//GEN-END:variables
}

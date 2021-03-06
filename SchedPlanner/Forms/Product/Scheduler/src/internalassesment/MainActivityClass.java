/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalassesment;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 061264
 */
public class MainActivityClass extends javax.swing.JFrame {

    /**
     * Creates new form MainActivityClass
     */
    private ControlSystem myControlSystem;
    private static final String myStudentLabel = "Student";
    private static final String myAppointmentLabel = "Appointment";    
   
    public MainActivityClass() throws Exception {
        initComponents();
        myControlSystem = new ControlSystem(); 
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    myControlSystem.close();
                } catch (Exception ex) {
                    
                }
            }
        });
    }

   /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        add = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<String>();
        displayAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Tutoring System");

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--------------", "Student", "Appointment" }));

        displayAll.setText("Display All");
        displayAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayAll(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(displayAll, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayAll, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void add(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add
        String str = (String) jComboBox1.getSelectedItem();
        if (str.equals(myStudentLabel)) {
            ModifyStudent add = new ModifyStudent(myControlSystem.getAllStudents(), "Add");
            add.setVisible(true);
            add.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (str.equals(myAppointmentLabel)) {
            ModifyAppointment add = new ModifyAppointment(myControlSystem.getAllAppointments(), "Add");
            add.setVisible(true);
            add.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } else {
            displayErrorDialogBox("Select search by student or appointment");
        }
    }//GEN-LAST:event_add

      //opens search frame based on option
    private void search(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search
        String str = (String) jComboBox1.getSelectedItem();                      //reads selected item      
        if (str.equals(myStudentLabel)) {
            ModifyStudent search = new ModifyStudent(myControlSystem.getAllStudents(), "Search");
            search.setVisible(true);
            search.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (str.equals(myAppointmentLabel)) {
            SearchAppt search = new SearchAppt(myControlSystem.getAllAppointments());
            search.setVisible(true);
            search.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else {
            displayErrorDialogBox("Select search by student or appointment");
        }
    }//GEN-LAST:event_search

    private void displayAll(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayAll
        // TODO add your handling code here:
        String str = (String) jComboBox1.getSelectedItem();
        List list;
        if (str.equals(myStudentLabel)) {
            if (myControlSystem.getAllStudents().size() == 0) {
                displayErrorDialogBox("You have no current students in your list.");
            }
            else{
            list = new List("student", myControlSystem.getAllStudents(), myControlSystem.getAllStudents());
            list.setVisible(true);
            list.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }
        } else if (str.equals(myAppointmentLabel)) {
            if(myControlSystem.getAllAppointments().size()==0){
                displayErrorDialogBox("You have no current appointments in your list.");
            }
            else{
            list = new List(myControlSystem.getAllAppointments(), myControlSystem.getAllAppointments());
            list.setVisible(true);
            list.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }
        } else {
            displayErrorDialogBox("Select search by student or appointment");
        }
    }//GEN-LAST:event_displayAll

    public static void displayErrorDialogBox(String error) {
        javax.swing.JDialog searchErrorDialog = new javax.swing.JDialog();
        searchErrorDialog.add(new javax.swing.JLabel(error));
        searchErrorDialog.setSize(450, 200);
        searchErrorDialog.setVisible(true);
    }

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
            java.util.logging.Logger.getLogger(MainActivityClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainActivityClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainActivityClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainActivityClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainActivityClass().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MainActivityClass.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainActivityClass.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(MainActivityClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton displayAll;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalassesment;

import com.sun.glass.events.KeyEvent;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Alay
 */
public class SearchAppt extends javax.swing.JFrame {

    private ArrayList<Appointment> myAppointments;
    private ArrayList<String> myParams;
    
    /**
     * Creates new form SearchAppt
     */
    public SearchAppt(ArrayList<Appointment> appointments) {
        initComponents();
        myAppointments = appointments;
        myParams = new ArrayList<String>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myMonth = new javax.swing.JComboBox<String>();
        myDate = new javax.swing.JComboBox<String>();
        jLabel2 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        myYear = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        myMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        myDate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jLabel2.setText("Name");

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search(evt);
            }
        });

        myYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                myYearKeyTyped(evt);
            }
        });

        jLabel1.setText("Year");

        jLabel3.setText("Month");

        jLabel4.setText("Date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(search)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(myYear, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1)
                                .addGap(31, 31, 31)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(myMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(myDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void search(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search
        if(!addParams()){
            return;                                  
        } 
        ArrayList <Appointment> validAppts = findValidAppointments();                   //adds appt to an arraylist of valid appts if valid
        if(validAppts.size()!=0){                                                           //displays the arraylist of valid appts if its not empty
            List list = new List(validAppts, myAppointments);
            list.setVisible(true);
            list.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } else MainActivityClass.displayErrorDialogBox("No appointments found");            //displays error if it is empty
    }//GEN-LAST:event_search
        
    private ArrayList<Appointment> findValidAppointments(){
        ArrayList<Appointment> validAppts = new ArrayList<Appointment>();
        for(int x = 0;x<myAppointments.size();x++){                                             //begins traversing myAppointments
            boolean isValidAppt = true;                                                         //assumes that the current appointment in arraylist is valid
            Appointment appt = myAppointments.get(x);                                                   
            for(int y = 0;y<3;y++){                                                             //traverses thru first 3 pieces of appt information: Year, month, date
                if(!myParams.get(y).contains("--") && myParams.get(y).length()!=0){                                            //ignores any empty parameters
                    if(appt.getApptInfo()[y]!= (Integer.parseInt(myParams.get(y)))){        //comapres two appts using one piece of their information(year,month,date)
                        isValidAppt = false;                                                    //not a valid appt if the information is not equal
                        y=3;
                    }
                }
            } 
            if(name.getText().length()!=0){          //separately checks if names are equal because name is not part of the apptInfo[] in appt class         
                System.out.println(name.getText() + "\n" + appt.getName());
                if(name.getText().equals(appt.getName()) && isValidAppt){
                    System.out.println(1);
                    isValidAppt = true;                                                    //not a valid appt if names are not equal                                     
                }
                else {
                    System.out.println(2);
                    isValidAppt = false;
                }
            }
            System.out.println(isValidAppt);
            if(isValidAppt) validAppts.add(myAppointments.get(x)); 
        }
        return validAppts;
    }
    
    private boolean addParams(){
        myParams.clear();
        myParams.add(myYear.getText());
        myParams.add((String)myMonth.getSelectedItem());
        myParams.add((String) myDate.getSelectedItem());
        return isValidParams();
    }
    
    private void myYearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_myYearKeyTyped
        // TODO add your handling code here:
        char letter = evt.getKeyChar();
        if(!(Character.isDigit(letter)) || (letter == KeyEvent.VK_BACKSPACE) || (letter == KeyEvent.VK_DELETE))
        evt.consume();
    }//GEN-LAST:event_myYearKeyTyped

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed
    
    private boolean isValidParams(){       
        //check if all params are empty including name;
        String errorMessage = "Please enter at least the year";
        boolean isValidAppt = false;
        if(name.getText().length()>0)
            isValidAppt = true;
        else{
            for(int x = 0;x<myParams.size();x++){
                if(myParams.get(x).length()!=0 || !myParams.get(x).contains("--")){
                    isValidAppt = true;
                    x = myParams.size();
                }
            }
        }
        //check if year and date is entered without month
        if(((String)myYear.getText()).length()>0){
            if(((String)myMonth.getSelectedItem()).contains("--") && !((String)myDate.getSelectedItem()).contains("--")){
                errorMessage = "Please enter month to search for a specific day.";
                isValidAppt = false;
            }
            else isValidAppt = true;
        }
        else {           //check if month and/or date is entered without year
            if(!((String)myMonth.getSelectedItem()).contains("--") || !((String)myDate.getSelectedItem()).contains("--")){
                errorMessage = "Please enter the year to narrow your search";
                isValidAppt = false;
            }
            else isValidAppt = true;
        }
        if(!isValidAppt)
            MainActivityClass.displayErrorDialogBox(errorMessage);        
       return isValidAppt;
    }
   
    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
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
            java.util.logging.Logger.getLogger(SearchAppt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchAppt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchAppt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchAppt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchAppt(myAppointments).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> myDate;
    private javax.swing.JComboBox<String> myMonth;
    private javax.swing.JTextField myYear;
    private javax.swing.JTextField name;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalassesment;

import java.awt.event.*;
import java.io.FileNotFoundException;
import java.time.*;
import java.util.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ModifyAppointment extends javax.swing.JFrame {

    private ArrayList<Appointment> myAppointments;
    private ArrayList<String> myParameters;
    private boolean isSearch;
    private String myOption;                                                        //represent if this appt form is for adding or editing
    private static final int myNumParams = 11;
    private Appointment myApptToEdit;

  //constructor that is used if adding an appt
    public ModifyAppointment(ArrayList<Appointment> appointments, String option) {
        initComponents();
        myOption = option;
        myAppointments = appointments;
        myParameters = new ArrayList<String>(myNumParams);
        myApptToEdit = null;                                
        myApptToEdit = null;
        jLabel10.setText("");
    }
    
    //constructor that is used if editing an appt
    public ModifyAppointment(ArrayList<Appointment> appointments, Appointment apptToEdit, String option){
        initComponents();
        myOption = option;
        myAppointments = appointments;        
        myParameters = new ArrayList<String>(myNumParams);
        myApptToEdit = apptToEdit;
        modifyAppt.setText("Save changes");
        jLabel10.setText("Please fill out the appointment form to make any changes");    //requests user to reenter all the appt information with desired changes
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        modifyAppt = new javax.swing.JButton();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jComboBox7 = new javax.swing.JComboBox<>();
        jComboBox8 = new javax.swing.JComboBox<>();
        jComboBox9 = new javax.swing.JComboBox<>();
        firstName = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        year = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jLabel1.setText("Start Time");

        jLabel5.setText("End Time");

        modifyAppt.setText("Add");
        modifyAppt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyAppt(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "AM", "PM" }));

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "AM", "PM" }));

        jLabel2.setText("First Name");

        jLabel3.setText("Last Name");

        jLabel6.setText("Month");

        jLabel7.setText("Date");

        jLabel8.setText("Hour");

        jLabel11.setText("Minutes");

        jLabel12.setText("Time of Day");

        jLabel13.setText("Hour");

        jLabel14.setText("Minutes");

        jLabel15.setText("Time of Day");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Appointment Form");

        year.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                yearKeyTyped(evt);
            }
        });

        jLabel10.setText("Confirmatin/ Notification");

        jLabel16.setText("Year");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(66, 66, 66))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel16)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel15))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel12)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(114, 114, 114))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(modifyAppt))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(15, 15, 15)
                .addComponent(jLabel10)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(modifyAppt)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //responds when button is pressed
    private void modifyAppt(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyAppt
        if (myOption.equals("Add")) {                             //if the appt form is for adding an appt
            try {
                add();                                          //add appt
            } catch (Exception e) {

            }
        } else {
            try {
                edit();                                             //edit appt
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_modifyAppt

    private void yearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearKeyTyped
        // TODO add your handling code here:
        char letter = evt.getKeyChar();
        //allows only numbers to be entered to year text field
        if(!(Character.isDigit(letter)) || (letter == com.sun.glass.events.KeyEvent.VK_BACKSPACE) || (letter == com.sun.glass.events.KeyEvent.VK_DELETE))
        evt.consume();
    }//GEN-LAST:event_yearKeyTyped

    //adds all the params by storing a String type of the input entered in the drop down
    private void addParams() {
        myParameters.clear();                                                   //clears list in case there was a previous entry
        myParameters.add((String) year.getText());
        myParameters.add((String) jComboBox2.getSelectedItem());
        myParameters.add((String) jComboBox3.getSelectedItem());
        myParameters.add((String) jComboBox4.getSelectedItem());
        myParameters.add((String) jComboBox5.getSelectedItem());
        myParameters.add((String) jComboBox6.getSelectedItem());
        myParameters.add((String) jComboBox7.getSelectedItem());
        myParameters.add((String) jComboBox8.getSelectedItem());
        myParameters.add((String) jComboBox9.getSelectedItem());
    }

    private void add() throws Exception {
        addParams();
        if (!isValidAppt()) //ends the method if the appt is not valid
        {
            return;
        }
        String name = firstName.getText() + " " + lastName.getText();                       //reads all parameters for the date
        int years = Integer.parseInt(myParameters.get(0));
        int month = Integer.parseInt(myParameters.get(1));
        int dayOfMonth = Integer.parseInt(myParameters.get(2));
        int startTime = Appointment.convertToMilit(Integer.parseInt(myParameters.get(3)), Integer.parseInt(myParameters.get(4)), myParameters.get(5));    //converst start time to military time because that is how the constructor requires it 
        int endTime = Appointment.convertToMilit(Integer.parseInt(myParameters.get(6)), Integer.parseInt(myParameters.get(7)), myParameters.get(8));     //converst end time to military time because that is how the constructor requires it 
        Appointment appt = new Appointment(name, years, month, dayOfMonth, startTime, endTime);
        if (checkConflict(appt)) {                                                         //if there is no overlap between any appts
            myAppointments.add(appt);
            Appointment.quickSort(myAppointments, 0, myAppointments.size() - 1);
            Date date = appt.getDate();
            ControlSystem.scheduleReminders(appt);                                          //schedules reminder for the appt
            jLabel4.setText(name +"'s Appointment has been added");
        }
        else
        jLabel4.setText("");
    }

    private void edit() throws Exception {
        myAppointments.remove(myApptToEdit);        //editing an appointment is essentially creating a new one. current one is therefore removed
        add();
    }

    //returns true if the appt is a valid appt
    private boolean isValidAppt() {
        return (isValidParam() && isValidDate());
    }

    //returns true if all params are entered
    private boolean isValidParam() {
        for (int x = 0; x < myParameters.size(); x++) {                             //traverses through the user input which is stored in myParameters. *myParameters only includes the date and time info of appt
            if (myParameters.get(x).equals("---")) {                                //did the user not enter a parameter
                MainActivityClass.displayErrorDialogBox("Please enter all parameters");         //error displays to warn user that a parameter is missing
                return false;
            }
        }
        if (firstName.getText().isEmpty() && lastName.getText().isEmpty()) {          //did the user enter at least a first name or a last name
            MainActivityClass.displayErrorDialogBox("Please enter all parameters"); //error if both are empty
            return false;
        }
        return true;                                                                //returns true if all required parameters are entere
    }

    //returns true if date is in the future
    private boolean isValidDate() {
        LocalDateTime localDate = LocalDateTime.now();                             //local time to represent current time and date
        Instant instant = localDate.atZone(ZoneId.systemDefault()).toInstant();      //converts the local time to an instant. Instant represents an instant in time
        Date local = Date.from(instant);                                           //creates a date object using the instant
        Date apptDate = createDate();                                              //creates a date object based on the user input stored in myParameters
        if (local.compareTo(createDate()) < 0) //is the appt date in the future
        {
            return true;
        } else {
            MainActivityClass.displayErrorDialogBox("This date has alread passed.");       //displays error if the appt date is in past
            return false;
        }
    }

    //returns true if there is no overlap with future appts
    private boolean checkConflict(Appointment appt) {
        for (int x = 0; x < myAppointments.size(); x++) {                         //traverses the list of appts                               
            Appointment thisAppt = myAppointments.get(x);
            boolean isSameDate = true;
            for (int y = 0; y < 3; y++) {                                          //checks if the appt at this index is in same year, month and day
                if (appt.getApptInfo()[y] != thisAppt.getApptInfo()[y]) {
                    isSameDate = false; 
                    y=3;
                }
            }
            if(isSameDate){
                if(!checkTimeOverLap(appt,thisAppt))
                    return false;
            }
            
        }
        return true;
    }

    private boolean checkTimeOverLap(Appointment appt, Appointment thisAppt) {
        //is appt's start time betweent thisAppt's start time and end time
        if (appt.getApptInfo()[3] >= thisAppt.getApptInfo()[3] && appt.getApptInfo()[3] <= thisAppt.getApptInfo()[4]) {
            MainActivityClass.displayErrorDialogBox("This appointment conflicts with another appoinment on the same day at: " + thisAppt.getStartTime());
            return false;
        }
        //is appt's end time between thisAppt's start time and endtime
        if (appt.getApptInfo()[4] >= thisAppt.getApptInfo()[3] && appt.getApptInfo()[4] <= thisAppt.getApptInfo()[4]) {
            MainActivityClass.displayErrorDialogBox("This appointment conflicts with another appoinment on the same day at: " + thisAppt.getStartTime());
            return false;
        }
        return true;
    }

    //creates a temporary date object using the information filled out in the JFrame
    private Date createDate() {
        int year = Integer.parseInt(myParameters.get(0)) - 1900;
        int month = Integer.parseInt(myParameters.get(1)) - 1;
        int dayOfMonth = Integer.parseInt(myParameters.get(2));
        int hrs = Integer.parseInt(myParameters.get(3));
        int min = Integer.parseInt(myParameters.get(4));
        int startTime = Appointment.convertToMilit(hrs, min, myParameters.get(5));
        return new Date(year, month, dayOfMonth, startTime / 100, startTime % 100);
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
            java.util.logging.Logger.getLogger(ModifyAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if(myOption.equals("Add"))
                new ModifyAppointment(myAppointments, myOption).setVisible(true);
                else
                    new ModifyAppointment(myAppointments, myApptToEdit, myOption).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField firstName;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lastName;
    private javax.swing.JButton modifyAppt;
    private javax.swing.JTextField year;
    // End of variables declaration//GEN-END:variables
}
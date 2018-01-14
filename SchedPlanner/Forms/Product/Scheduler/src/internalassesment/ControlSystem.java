/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalassesment;

import java.io.*;
import java.time.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author 061264
 */
public class ControlSystem  extends Timer{

    //creates all privates    
    private Scanner in;
    private static ArrayList<Appointment> myTimerTasks = new ArrayList<Appointment>();                             //holds all the reminders for the appts that will be executed
    private ArrayList<Student> myStudents;                                          //holds all student information in alphabetical order                                                                                   
    private static ArrayList<Appointment> myFutureAppointments;                            //holds all upcoming appointments
    private ArrayList<Appointment> myPastAppointments;                              //holds all past appointments in order( closest appointments first)            
    private ArrayList<Appointment> myAllAppointments;                               //holds all appointments
    private static Timer myTimer;                                                   // timer object to schedule reminders for the appointments
    
    public ControlSystem() throws Exception {
        //initializes all privates
        myTimer = new Timer();                                                      
        myStudents = new ArrayList<Student>();
        myPastAppointments = new ArrayList<Appointment>();
        myFutureAppointments = new ArrayList<Appointment>();
        myAllAppointments = new ArrayList<Appointment>();
        open();                                                                    //adds existing student and appt info to list 
    } 

    public void open() throws Exception {
        readStudentInfo();                                                         //adds student to arraylist                         
        readAppointmentInfo();                                                     //adds appts to arraylist
        if(myFutureAppointments.size()>0)                                          //schedules reminders for upcoming appts if there ar any
        scheduleReminders(myFutureAppointments);
    }
    
    public static void scheduleReminders(ArrayList<Appointment> appts) throws Exception{         
        for (int x = 0; x < appts.size(); x++) {                                        //traverses the arraylist to schedule reminders for each appt
           scheduleReminders(appts.get(x));
        }
    }
    
    public static void scheduleReminders(Appointment appt) throws Exception {         
         Date date = scheduleDateForReminder(appt);                                     //schedules a reminder for the appt a day earlier
         Appointment task = new Appointment();
         myTimerTasks.add(task);
         myTimer.schedule(task, date); 
    }

    private static Date scheduleDateForReminder(Appointment appt) {
        Date date1 = appt.getDate();
        date1.setDate(date1.getDate()-1);
        return date1;
    }

    //reads student info from txt file    
    private void readStudentInfo() throws Exception {
        /*attempts to find the file with name "studentInfo.txt" */
        try {
            in = new Scanner(new File("studentInfo.txt"));

        } catch (Exception e) {                                                    
            File f = new File("studentInfo.txt");                      //creates new file if there is no existing "studentInfo.txt" file 
            f.createNewFile();                                                          
            return;                                                    //ends the method because the new file will obviously be empty                                                                       
        }
        /*begins to read from file*/
        while (in.hasNext()) {                                                      //reads the parametes for students until txt hits blank line          
            String firstName = in.next();
            String lastName = in.next();
            String phoneNumber = in.next();
            String emailAddress = in.next();
            myStudents.add(new Student(firstName, lastName, phoneNumber, emailAddress));    //creates student obj and adds to arraylist
        }
        if (!myStudents.isEmpty()) {
            Student.quickSort(myStudents, 0, myStudents.size() - 1);                                //sorts arraylist alphabetically        
        }
    }

    //reads appointment information from "appointmentInfo.txt" file
    private void readAppointmentInfo() throws Exception {
        try {                                                            //attempts to find the file with name "appointmentInfo.txt" 
            in = new Scanner(new File("appointmentInfo.txt"));
        } catch (Exception e) {                                          //creates new "appointment.txt" file                                    
            File f = new File("appointmentInfo.txt");
            f.createNewFile();
            return;                                                    //Ends method. No reason to read since file will be empty            
        }
        while (in.hasNext()) {                                        // Reads the paramters for appointments until scanner encounters blank line                          
            String name = in.nextLine();
            int year = Integer.parseInt(in.nextLine());
            int month = Integer.parseInt(in.nextLine());
            int dayOfMonth = Integer.parseInt(in.nextLine());
            int startTime = Integer.parseInt(in.nextLine());
            int endTime = Integer.parseInt(in.nextLine());
            Date apptDate = new Date(year - 1900, month-1, dayOfMonth, startTime/100, startTime%100);  //creates a date object using the information that was read
            LocalDateTime date = LocalDateTime.now();                                               //represents the local time
            Date currentDate = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());          //date object to represent local time
            Appointment appt = new Appointment(name, year, month, dayOfMonth, startTime, endTime);  //creates appointment
            if (currentDate.compareTo(apptDate)<0)            //compares the local date and appt's date. If date is in future add to myFutureAppts
                  myFutureAppointments.add(appt); 
            else myPastAppointments.add(appt);               //add to myPastAppts if in past
            myAllAppointments.add(appt);                        
        }
      //sort each arraylist chronologically
      Appointment.quickSort(myAllAppointments, 0, myAllAppointments.size() - 1);
      Appointment.quickSort(myPastAppointments, 0, myPastAppointments.size() - 1);
      Appointment.quickSort(myFutureAppointments, 0, myFutureAppointments.size() - 1);     
    }

    //returns arraylist of students
    public ArrayList<Student> getAllStudents() {
        return myStudents;
    }

    //returns arraylist of all appts
    public ArrayList<Appointment> getAllAppointments() {
        return myAllAppointments;
    }
    
    public static void editFuturesList(Appointment appt){
        int indexOf = myFutureAppointments.indexOf(appt);
        if(indexOf !=-1){
            myTimerTasks.remove(indexOf);
            myFutureAppointments.remove(indexOf);
        }
    }

    //returns arraylist of past appts
    public ArrayList<Appointment> getPastAppointments() {
        return myPastAppointments;
    }

    //returns arraylist of upcoming appts
    public ArrayList<Appointment> getFutureAppointments() {
        return myFutureAppointments;
    }

    //saves any changes made to arraylist to the text file    
    public void close() throws Exception {
        FileWriter rt = new FileWriter("studentInfo.txt");                         //creates filewriter and erases file 
        saveStudentData(rt);
        rt = new FileWriter("appointmentInfo.txt");  
        saveAppointmentData(rt);                                                   //closes to save changes to arraylist
    }
     
    private void saveStudentData(FileWriter rt) throws Exception {
        for (int x = 0; x < myStudents.size(); x++) {                              //starts traversing arraylist of students           
            Student student = myStudents.get(x);                                   //Student object at index x
            try {
                for(int y = 0;y<student.getStudentInfo().length;y++)           //traverses through the array holding student's information
                rt.write(student.getStudentInfo()[y] + "\n");                 //writes the information of Student at x and the information at y    
            } catch (IOException e) {
                
            }
        }
        rt.close();                                                                 //closes to save changes to arraylist
    }
    
    private void saveAppointmentData(FileWriter rt) throws Exception {
        for (int x = 0; x < myAllAppointments.size(); x++) {                     //starts traversing arraylist of appointments            
            rt.write(myAllAppointments.get(x).getName() + "\n");                //Appointment object at index x
            try {
                Appointment appt = myAllAppointments.get(x);            
                for(int y = 0;y<appt.getApptInfo().length;y++){                 //traverses through the array holding appointment's information
                    rt.write(Integer.toString((appt.getApptInfo())[y]) + "\n"); //writes the information of Appointment at x and the information at y    
                }
            } catch (IOException e) {
                
            }
        }
        rt.close();                                                                 //closes to save changes to arraylist
     }
    
}

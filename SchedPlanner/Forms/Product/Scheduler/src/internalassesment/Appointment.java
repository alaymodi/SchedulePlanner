/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalassesment;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import sun.audio.*;

/**
 *
 * @author 061264
 */
public class Appointment extends TimerTask {

    String myName;
    private int numApptParam = 5;                                                   //number of parameters for the date in an appointmetn
    private int[] myApptInfo = new int[5];                                          //holds the date information of an appointment
    private Date myStartTimeDate;                                                   //represents the the start time and the date of an appointment

    public Appointment(String name, int year, int month, int date, int startTime, int endTime) {
        myName = name;
        myApptInfo[0] = year;
        myApptInfo[1] = month;
        myApptInfo[2] = date;
        myApptInfo[3] = startTime;
        myApptInfo[4] = endTime;
        myStartTimeDate = new Date(myApptInfo[0] - 1900, myApptInfo[1] - 1, myApptInfo[2], myApptInfo[3] / 100, myApptInfo[3] % 100);
    }

    public Appointment() {

    }                                               // empty Appointment object

    //task that runs when a reminder is sent for an appointment
    @SuppressWarnings("empty-statement")
    public void run() {
        Reminder remind = new Reminder();
        remind.setVisible(true);
    }

    public String getName() {
        return myName;
    }

    public int[] getApptInfo() {
        return myApptInfo;
    }                                         //returns the date appt information in an array

    public int getYear() {
        return myApptInfo[0];
    }

    public int getMonth() {
        return myApptInfo[1];
    }

    public int getDayOfMonth() {
        return myApptInfo[2];
    }

    public static int convertToMilit(int hrs, int min, String timeOfDay) {              //converts a time to 0-2300 hr format
        if (timeOfDay.equalsIgnoreCase("AM") && hrs == 12) //if its 12:00 AM hrs is zero. returns the minutes only
        {
            return min;
        } else if (timeOfDay.equalsIgnoreCase("Pm") && hrs != 12) {                        //converts afternoon times
            return (hrs + 12) * 100 + min;
        } else {
            return (hrs * 100) + min;                                                   //returns 
        }
    }

    public String getStartTime() {
        int hrs = myApptInfo[3] / 100;
        String timeOfDay;                                                         //represents the time of day of start time: "AM" or "PM"
        if (hrs > 12) {                                                           // is the start time past noon
            hrs = hrs - 12;
            timeOfDay = "pm";
        } else if (hrs == 12) {                                                    //is the start time noon
            timeOfDay = "pm";
        } else {                                                                  // appointment is in the morning
            timeOfDay = "am";
        }
        if (hrs == 0) {
            hrs = 12;
        }
        if (myApptInfo[3] % 100 < 10) // are the minutes less than ten
        {
            return hrs + ":" + "0" + myApptInfo[3] % 100 + timeOfDay;                    //adds a zero to the minutes if it is. Ex if minutes = 3 adds a 0 so 12:03 is displayed instead of 12:3
        } else {
            return hrs + ":" + myApptInfo[3] % 100 + " " + timeOfDay;
        }
    }

    public String getStartHours() {
        int index = getStartTime().indexOf(":");                //gets hours by getting the index of the ":" from the start time string                   
        return getStartTime().substring(0, index);               // returns the hours by getting the substring of the start time up to the ":"
    }

    public String getStartMinutes() {
        int index = getStartTime().indexOf(":");                             // gets the index of the ":" in the start tiem   
        return getStartTime().substring(index + 1, index + 3);             // returns the minutes by getting the substring after the colon and before the time of day
    }

    public String getEndTime() {
        int hrs = myApptInfo[4] / 100;
        String timeOfDay;
        if (hrs > 12) {
            hrs = hrs - 12;
            timeOfDay = "pm";
        } else if (hrs == 12) {
            timeOfDay = "pm";
        } else {
            timeOfDay = "am";
        }
        if (hrs == 0) {
            hrs = 12;
        }
        if (myApptInfo[4] % 100 < 10) {
            return hrs + ":" + "0" + myApptInfo[4] % 100 + timeOfDay;
        } else {
            return hrs + ":" + myApptInfo[4] % 100 + " " + timeOfDay;
        }
    }

    public String getEndHours() {
        int index = getEndTime().indexOf(":");
        return getEndTime().substring(0, index);
    }

    public String getEndMinutes() {
        int index = getEndTime().indexOf(":");
        return getEndTime().substring(index, index + 2);
    }

    //returns a date object that represents start time of appt.

    public Date getDate() {
        return myStartTimeDate;
    }

    //returns the date of the appointment information in an []

    public int[] allInfo() {
        return myApptInfo;
    }

    public void setYear(int year) {
        myApptInfo[0] = year;
        myStartTimeDate.setYear(year);
    }

    public void setMonth(int month) {
        myApptInfo[1] = month;
        myStartTimeDate.setMonth(month - 1);
    }

    public void setDate(int date) {
        myApptInfo[2] = date;
        myStartTimeDate.setDate(date);
    }

    public void setStartTimeHrs(int startTimeHrs) {
        myApptInfo[3] = startTimeHrs;
        myStartTimeDate.setHours(startTimeHrs);
    }

    public void setStartTimeMin(int startTimeMin) {
        myApptInfo[4] = startTimeMin;
        myStartTimeDate.setMinutes(startTimeMin);
    }

    public void setEndTimeHrs(int endTimeHrs) {
        myApptInfo[5] = endTimeHrs;

    }

    public void setEndTimeMin(int endTimeMin) {
        myApptInfo[3] = endTimeMin;
    }

    public int compareTo(Appointment appt) {
        return this.getDate().compareTo(appt.getDate());
    }                           //compares two appointments based on their dates

    public String appointMentInfo() {
        String apptInfo = myName + "     ";
        apptInfo = apptInfo + getMonth() + "/" + getDayOfMonth() + "/" + getYear() + "     ";
        apptInfo = apptInfo + getStartTime() + " to " + getEndTime();
        return apptInfo;
    }

    public static void quickSort(ArrayList<Appointment> info, int first, int last) {
        if (first < 0 || last < 0) {
            return;
        }
        int f = first;
        int l = last;
        int midIndex = (first + last) / 2;
        Appointment obj = (Appointment) info.get(midIndex);
        do {
            while (((Appointment) info.get(f)).compareTo(obj) < 0) {
                f++;
            }
            while (((Appointment) info.get(l)).compareTo(obj) > 0) {
                l--;
            }
            if (f <= l) {
                swap(info, f, l);
                f++;
                l--;
            }
        } while (f < l);
        if (l > first) {
            quickSort(info, first, l);
        }
        if (f < last) {
            quickSort(info, f, last);
        }
    }

    private static void swap(ArrayList<Appointment> info, int x, int y) {
        Appointment ex = (Appointment) info.get(x);
        info.set(x, info.get(y));
        info.set(y, ex);
    }
}

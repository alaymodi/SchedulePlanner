/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalassesment;

import java.util.ArrayList;

/**
 *
 * @author 061264
 */
public class Student {    
    //parameters of student object stored in an array
    private String [] myStudentInfo = new String[4];  
    
    //student information is always stored in the array in this order
    public Student(String firstName, String lastName,String phoneNumber,String emailAddress){
        myStudentInfo[0] = firstName;
        myStudentInfo[1] = lastName;
        myStudentInfo[2] = phoneNumber;
        myStudentInfo[3] = emailAddress;
    }  
    
    public String getFirstName(){
        return myStudentInfo[0];
    }
   
    public String getLastName(){
        return myStudentInfo[1];
    }
    
    public String getPhoneNumber(){
        return myStudentInfo[2];
    }
    
    public String getEmailAddress(){
        try{
            return myStudentInfo[3];
        }
        catch(NullPointerException e){
            return "This student does not have an email address or has not been added";
        }
    }     
   
    public String [] getStudentInfo(){
        return myStudentInfo;
    }
    
    public void setStudentFirstName(String firstName){
        myStudentInfo[0]= firstName;
    }
    
    public void setStudentLastName(String lastName){
        myStudentInfo[1] = lastName;
    }
    
    public void setPhoneNumber(String phoneNumber){
        myStudentInfo[2] = phoneNumber;
    }
    
    public void setEmailAddress(String emailAddress){
       myStudentInfo[3] = emailAddress;
    }
    
    public String toString(){
        String info = getFirstName() + " " + getLastName() + " ";        
        if(!getEmailAddress().equals("---"))
            info += getEmailAddress() + "  ";        
        if(!getPhoneNumber().equals("---"))
            info += getPhoneNumber();        
        return info;
    }
    
    public int compareTo(Student student){
        for(int x =0;x<myStudentInfo.length;x++){
            if(myStudentInfo[x].compareToIgnoreCase(student.getStudentInfo()[x])!=0)
                return myStudentInfo[x].compareToIgnoreCase(student.getStudentInfo()[x]);
        }
        return 0;
    }
    
    /*sorts any arraylist of students using quicksort 
    algorithm and puts them in alphabetical order */
    public static void quickSort(ArrayList<Student> info, int first,int last){
        int f = first;
        int l = last;
        int midIndex = (first+last)/2;        
        Student obj = (Student) info.get(midIndex);
        do{
            while(((Student)info.get(f)).compareTo(obj)<0){
             f++;   
            }
            while(((Student)info.get(l)).compareTo(obj)>0){
             l--;   
            }            
            if(f<=l){
                swap(info,f,l); 
                f++;
                l--;
            }
        }while(f<l);
        if(l>first){
            quickSort(info,first,l);
        }
        if(f<last){
            quickSort(info,f,last);
        }                
    }
    
    private static void swap(ArrayList<Student> info, int x, int y){
        Student ex = (Student) info.get(x);
        info.set(x,info.get(y));
        info.set(y,ex);
    }  
}

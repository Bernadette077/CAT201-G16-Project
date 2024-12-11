package com.example.one;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Booking {

    private int bookingId;
    private User user;
    private ArrayList<Integer> bookedMachine= new ArrayList<Integer>();
    private ArrayList<String> bookedServices= new ArrayList<String>();
    private String bookingType;
    private LocalDate checkIn;
    Booking(int id,ArrayList<Integer> Machine,User user,String bookingType,LocalDate checkIn){
        setBookingId(id);
       setUser(user);// needs attention
        setBookingType(bookingType);
        setBookedMachine(Machine);

    }
    public void setBookingId(int id){
        bookingId=id;
    }
    public int getBookingId(){
        return bookingId;
    }
    public void setBookingType(String str){
        bookingType=str;
    }
    public String getBookingType(){
        return bookingType;
    }
    public void setBookedMachine(ArrayList<Integer> Machine){

        for(int i=0;i<Machine.size();i++){
            bookedMachine.add(Machine.get(i));
        }
    }
    public void setBookedServices(ArrayList<String> services){

        for(int i=0;i<services.size();i++){
            bookedServices.add(services.get(i));
        }
    }
    public ArrayList<Integer> getBookedMachine(){

        return bookedMachine;
    }
    public String toString(){
      String str="Booking id:"+Integer.toString(bookingId)+" Machine:";
      for(int i=0; i<bookedMachine.size();i++){
          str=str+bookedMachine.get(i)+",";

      }
      str=str+" Name: ";
      str=str+user.getName()+" Booking Type:"+bookingType+" ";
      return str;
    }
    public ArrayList<String> getBookedServices(){
        return bookedServices;
    }
     public void setUser(User u){
        this.user=new User(u.getName(),u.getBookingId(),u.getPhone(),u.getEmail());
     }

}




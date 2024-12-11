package com.example.one;

import java.time.LocalDate;
import java.util.ArrayList;

public class BookingSet {
    ArrayList<String> services= new ArrayList<String>();
    ArrayList<Integer>  Machine = new ArrayList<Integer>();
    ArrayList<Integer>  MachineInUse= new ArrayList<Integer>();
    ArrayList<Integer>  MachineFree = new ArrayList<Integer>();
    ArrayList<Booking> bookings= new ArrayList<Booking>();
    ArrayList<String> checkIns= new ArrayList<String>();
    int MachinePointer=60;

    public BookingSet(){
        populateServices();
        populateMachine();
        populateBookings();
        populateFreeMachine();
    }
    public void addCheckIn(int bookingId){
        checkIns.add(Integer.toString(bookingId));
    }
    private void populateServices(){  // urgent substract these machine while at it
        services.add("Dry Clean");
        services.add("Wash and Fold");
        services.add("Commercial Service");
    }

    private void populateMachine(){
        for(int i=60;i<300;i++){
            Machine.add(i);
        }
    }
    public void add(Booking b){
        bookings.add(b);
    }
    public Booking getBooking(int i){

        return bookings.get(i);
    }
    public int getBookingId(int i){
        return bookings.get(i).getBookingId();
    }
    public void removeBooking(int bookingId){
        for(int i=0;i<bookings.size();i++){
            if(bookings.get(i).getBookingId()==bookingId){
                for(int k=0;k<bookings.get(i).getBookedMachine().size();k++){
                    MachineFree.add(bookings.get(i).getBookedMachine().get(k));
                    MachineInUse.remove(bookings.get(i).getBookedMachine().get(k));

                }
                bookings.remove(i);
            }
        }
    }
    private void populateBookings(){
        ArrayList<Integer>  bmachine= new ArrayList<Integer>();

        //1
        bmachine.add(60);
        bmachine.add(61);
        bmachine.add(62);
        MachineInUse.add(60);
        MachineInUse.add(61);
        MachineInUse.add(63);

        User u= new User("Tom",1100,"041089877","tom@gmail.com");
        LocalDate checkIn=LocalDate.of(2022,06,26);
        Booking a=new Booking(1100,bmachine,u,"Dry Clean",checkIn);
        bookings.add(a);

        bmachine.clear();



    }

    public void populateFreeMachine(){
        MachineFree.clear();
        for(int i=0;i<Machine.size();i++){
            for(int j=0;j<MachineInUse.size();j++) {
                if (Machine.get(i) != MachineInUse.get(j)) {
                    MachineFree.add(Machine.get(i));
                }
            }
        }

    }


}






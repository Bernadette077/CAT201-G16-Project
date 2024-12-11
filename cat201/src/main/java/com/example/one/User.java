package com.example.one;

public class User {


        private String name;
        private int bookingId;
        private String phone;
        private String email;

        public User(String name, int bookingId,String phone, String email){
             setName(name);
             setEmail(email);
             setBookingId(bookingId);
             setPhone(phone);


        }
        //setters
        public void setName(String name){
            this.name=name;

        }
        public String getName(){
            return name;
        }
    public void setEmail(String email){
        this.email=email;

    }
    public String getEmail(){
        return email;
    }
        public void setBookingId(int bookingId){
            this.bookingId=bookingId;
        }

        public int getBookingId(){
            return bookingId;
        }
        public void setPhone(String phone){
            this.phone=phone;
        }

        public String getPhone(){
            return phone;
        }





    }



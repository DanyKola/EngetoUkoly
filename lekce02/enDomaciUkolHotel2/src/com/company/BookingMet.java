package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class BookingMet {
    private ArrayList<Booking> listOfbooking = new ArrayList<>();

    //Výpis rezervací
    public void extractBoking(){
        for (Booking book:listOfbooking){
            System.out.println( book.getGuest()+ " "+ book.getGuest2()+" "+book.getRooms()+ " "+book.getBookingStart()+" - "+book.getBookingEnd()+" "+book.getTypeOfBooking());
        }
    }
    //Metoda přidat rezervaci
    public void addBooking(Booking booking){
        listOfbooking.add(booking);
    }



}

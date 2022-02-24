package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Guest guests1 = new Guest("Adéla", "Malíková", LocalDate.of(1993, 3, 13));
        Guest guests2 = new Guest("Jan", "Dvořáček", LocalDate.of(1995, 5,5));

        Rooms rooms1 = new Rooms(1, 1,true,true, BigDecimal.valueOf(1000));
        Rooms rooms2 = new Rooms(2, 1,true,true, BigDecimal.valueOf(1000));
        Rooms rooms3 = new Rooms(3, 3,false,true, BigDecimal.valueOf(2400));



        BookingMet bookingMet = new BookingMet();
        bookingMet.addBooking(new Booking(guests1,rooms1, LocalDate.of(2021,7,19),LocalDate.of(2021, 7,20), TypeOfBooking.SLUŽEBNÍ));
        bookingMet.addBooking(new Booking(guests2, rooms3, LocalDate.of(2021, 9, 1),LocalDate.of(2021, 9, 1), TypeOfBooking.SOUKROMÍ));
        bookingMet.addBooking(new Booking(guests2,guests1, rooms3, LocalDate.of(2021, 9, 1),LocalDate.of(2021, 9, 1), TypeOfBooking.SOUKROMÍ));


//Vypiš na obrazovku hosty a jejich popis (description)
        System.out.println("__________Výpis hostů_____________");
        System.out.println(guests1);
        System.out.println(guests2);

//Vypiš na obrazovku pokoje a jejich popis (description).
        System.out.println("__________Výpis pokojů_____________");
        System.out.println(rooms1);
        System.out.println(rooms2);
        System.out.println(rooms3);



        ArrayList<Booking> booking = new ArrayList<>();
        booking.add(new Booking(guests1, rooms1, LocalDate.of(2021, 7, 19),LocalDate.of(2021, 7, 26), TypeOfBooking.SLUŽEBNÍ));
        booking.add(new Booking(guests2, rooms3, LocalDate.of(2021, 9, 1),LocalDate.of(2021, 9, 1), TypeOfBooking.SOUKROMÍ));
        booking.add(new Booking(guests2,guests1, rooms3, LocalDate.of(2021, 9, 1),LocalDate.of(2021, 9, 1), TypeOfBooking.SOUKROMÍ));

//Vypiš seznam všech rezervací.
        System.out.println("__________Výpis rezervací_____________");
        for (Booking vypis : booking){
            System.out.println("REZEVACE: Host: " +vypis.getGuest()+" "+vypis.getGuest2()+" " +vypis.getRooms()+ ",  Rezervace: od " + vypis.getBookingStart()+ " do "+vypis.getBookingEnd());
        }

//Výpis rezervací pomocí metody extractBoking
        System.out.println("__________Výpis rezervací pomocí metody_____________");
        bookingMet.extractBoking();
    }




}

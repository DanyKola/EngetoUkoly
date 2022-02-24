package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Booking {
    private Guest guest;
    private Guest guest2;
    private Rooms rooms;
    private LocalDate bookingStart;
    private LocalDate bookingEnd;
    private Enum TypeOfBooking;



    public Booking(Guest guests, Rooms rooms, LocalDate bookingStart, LocalDate bookingEnd, Enum typeOfBooking) {
        this.guest = guests;
        this.rooms = rooms;
        this.bookingStart = bookingStart;
        this.bookingEnd = bookingEnd;
        this.TypeOfBooking = typeOfBooking;
    }



    public Booking(Guest guests, Guest guests2, Rooms rooms, LocalDate bookingStart, LocalDate bookingEnd, Enum typeOfBooking) {
        this.guest = guests;
        this.guest2 = guests2;
        this.rooms = rooms;
        this.bookingStart = bookingStart;
        this.bookingEnd = bookingEnd;
        this.TypeOfBooking = typeOfBooking;
    }

    public Booking() {
    }


    public Guest getGuest2() {
        return guest2;
    }

    public void setGuest2(Guest guest2) {
       this.guest2 = guest2;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    public LocalDate getBookingStart() {
        return bookingStart;
    }

    public void setBookingStart(LocalDate bookingStart) {
        this.bookingStart = bookingStart;
    }

    public LocalDate getBookingEnd() {
        return bookingEnd;
    }

    public void setBookingEnd(LocalDate bookingEnd) {
        this.bookingEnd = bookingEnd;
    }

    public Enum getTypeOfBooking() {
        return TypeOfBooking;
    }

    public void setTypeOfBooking(Enum typeOfBooking) {
        this.TypeOfBooking = typeOfBooking;
    }



/*
    @Override
    public String toString() {
        return "REZERVACE: " +
                "Host: " + guests.getName()+" " +guests.getSurname()+

                ", Pokoj: číslo " + rooms.getRoomNumber() +
                ", Rezervace: od " + bookingStart +
                ", do " + bookingEnd +
                ", Typ rezervace: " + typeOfBooking
                ;
    }*/

}


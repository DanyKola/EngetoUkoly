package com.company;

import java.math.BigDecimal;

public class Rooms {
    private int roomNumber;
    private int numberOfBets;
    private boolean isBalcony = true;
    private boolean isSeaViews;
    private BigDecimal price;

    public Rooms(int roomNumber, int numberOfBets, boolean isBalcony, boolean isSeaViews, BigDecimal price) {
        this.roomNumber = roomNumber;
        this.numberOfBets = numberOfBets;
        this.isBalcony = isBalcony;
        this.isSeaViews = isSeaViews;
        this.price = price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumberOfBets() {
        return numberOfBets;
    }

    public void setNumberOfBets(int numberOfBets) {
        this.numberOfBets = numberOfBets;
    }

    public boolean isBalcony() {
    return isBalcony;

    }

    public void setBalcony(boolean balcony) {
        isBalcony = balcony;
    }

    public boolean isSeaViews() {
        return isSeaViews;
    }

    public void setSeaViews(boolean seaViews) {
        isSeaViews = seaViews;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "POKOJ: Pokoj číslo:" + roomNumber + ", Počet lůžek:" +numberOfBets +", Obsahuje balkon: " +isBalcony+ ", Má výhled na moře: "+isSeaViews +", Cena: "+price+ "Kč/noc";
    }
}

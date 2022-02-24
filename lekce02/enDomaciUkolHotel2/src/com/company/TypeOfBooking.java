package com.company;

public enum TypeOfBooking {
    SOUKROMÍ ("soukromé"),
    SLUŽEBNÍ ("služební");

    String description;

    TypeOfBooking(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description ;
    }
}

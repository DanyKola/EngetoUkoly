package com.company;

public class Ucitel {
    private String Jmeno;
    private String Prijmeni;

    public Ucitel(String jmeno, String prijmeni) {
        Jmeno = jmeno;
        Prijmeni = prijmeni;
    }


    public String getJmeno() {
        return Jmeno;
    }

    public void setJmeno(String jmeno) {
        Jmeno = jmeno;
    }

    public String getPrijmeni() {
        return Prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        Prijmeni = prijmeni;
    }



}

package com.company;

public class Student extends Ucitel {
    private int key;
    private int rokNarozeni;
    private String studentskeCislo;


    public Student(int key, String jmeno, String prijmeni, int rokNarozeni, String studentskeCislo) {
        super(jmeno, prijmeni);
        this.rokNarozeni = rokNarozeni;
        this.studentskeCislo = studentskeCislo;
        this.key = key;
    }

    @Override
    public String toString() {
        return "# " +key+ " # "+studentskeCislo + " - "+ getJmeno()+ " "+getPrijmeni()+" ("+rokNarozeni+")";

    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getRokNarozeni() {
        return rokNarozeni;
    }

    public void setRokNarozeni(int rokNarozeni) {
        this.rokNarozeni = rokNarozeni;
    }

    public String getStudentskeCislo() {
        return studentskeCislo;
    }

    public void setStudentskeCislo(String studentskeCislo) {
        this.studentskeCislo = studentskeCislo;
    }
}
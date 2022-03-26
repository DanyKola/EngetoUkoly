package com.company;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class SkolniTrida implements InterfaceTrida {
    public static final String DELIMETR = "\t";
    public static final String FILE_NAME = "SkolniTrida.txt";

    private String nazev;
    private int rocnik;
    private Ucitel ucitel;
    private List<Student> studentList = new ArrayList<>();

    public SkolniTrida(String nazev, int rocnik, Ucitel ucitel, List<Student> studentList) {
        this.nazev = nazev;
        this.rocnik = rocnik;
        this.ucitel = ucitel;
        this.studentList = studentList;
    }

    public SkolniTrida(String nazev, int rocnik, Ucitel ucitel) {
        this.nazev = nazev;
        this.rocnik = rocnik;
        this.ucitel = ucitel;
    }

    public String getNazev() {
        return nazev;
    }

    public int getRocnik() {
        return rocnik;
    }

    public Ucitel getUcitel() {
        return ucitel;
    }

//Počet studentů
    @Override
    public int pocetStudentu() {
        return studentList.size();
    }


//přidej studenta
    @Override
    public void pridejStudenta(Student novyStudent) {
        studentList.add(novyStudent);
    }

//1. Vypíše školní třídu v následujícím formátu:
    @Override
    public void prochazeniStudentu() {
        for (Student s : studentList) {
            System.out.println(s);
        }

    }
//2. Vypíše školní třídu v následujícím formátu:

    public void vypisKomplex() {
        System.out.println(getNazev() + ", " + ucitel.getJmeno() + " " + ucitel.getPrijmeni());
        for (Student s : studentList) {
            System.out.println(s.getStudentskeCislo() + ", " + s.getJmeno() + " " + s.getPrijmeni());
        }

    }

//3. Ukázka formátu zápisu do souboru:
    public void vypisZapisuDoSouboru() {
        System.out.println(getNazev() + DELIMETR + ucitel.getJmeno() + DELIMETR + ucitel.getPrijmeni());
        for (Student s : studentList) {
            System.out.println(s.getJmeno() + DELIMETR + s.getPrijmeni() + DELIMETR + s.getRokNarozeni() + DELIMETR + s.getStudentskeCislo());
        }

    }

//3. Zápis do souboru:
    public void saveToFile(String fileName, String DELIMETR) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.write(getNazev() + DELIMETR + ucitel.getJmeno() + DELIMETR + ucitel.getPrijmeni() + "\n");

            for (Student st : studentList) {
                String outputLine = st.getJmeno() + DELIMETR;
                outputLine += st.getPrijmeni() + DELIMETR;
                outputLine += st.getRokNarozeni() + DELIMETR;
                outputLine += st.getStudentskeCislo() + "\n";
                writer.print(outputLine);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


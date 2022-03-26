package com.company;

import java.util.ArrayList;
import java.util.List;

import static com.company.SkolniTrida.DELIMETR;
import static com.company.SkolniTrida.FILE_NAME;

public class Main {

    public static void main(String[] args) {
        SkolniTrida skolni = new SkolniTrida("4.C", 4, new Ucitel("Jan", "Novák"));

        skolni.pridejStudenta(new Student(1, "Petr", "Svoboda", 2011, "ID001"));
        skolni.pridejStudenta(new Student(2, "Milan", "Říha ", 2010, "ID123"));
        skolni.pridejStudenta(new Student(3, "Jindřich", "Nový", 2012, "ID345"));


//1. Vypíše školní třídu v následujícím formátu:
        System.out.println("####################################");
        System.out.println("Třída: " + skolni.getNazev() + " (ročník:" + skolni.getRocnik() + ")");
        System.out.println("Třídní učitel: " + skolni.getUcitel().getPrijmeni() + ", " + skolni.getUcitel().getJmeno());
        System.out.println("Počet studentů: " + skolni.pocetStudentu());
        System.out.println("####################################");
        skolni.prochazeniStudentu();


//2. Vypíše školní třídu v následujícím formátu:
        System.out.println("____________");
        skolni.vypisKomplex();

//3. Ukázka formátu zápisu do souboru:
        System.out.println("____________");
        skolni.vypisZapisuDoSouboru();

//3. Zápis do souboru
        try {
            skolni.saveToFile(FILE_NAME, DELIMETR);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }
}

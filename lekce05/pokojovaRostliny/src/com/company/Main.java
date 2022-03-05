package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String FILE_NAME = "kvetiny.txt";
    public static final String DELIMETR = "\t";
    public static final String VYSTUP_TXT = "vystup.txt";

    public static void main(String[] args) throws PlantException {
        ListPlans list = new ListPlans();
        try {
//12.B Načtěte seznam květin ze souboru kvetiny.txt.
            list.loadFromFile(FILE_NAME, DELIMETR);
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }


        for (Plant p : list.getPlantListALL()){
//13. Vypište na obrazovku informace o zálivce pro všechny květiny.
            System.out.println(p.getWateringInfo());

        }
//14.Přidejte dvě nové květiny do seznamu. Jednu květinu odeberte.
     list.addPlant(new Plant("Narciska",7, LocalDate.of(2021, 1, 3), LocalDate.of(2020,11,5)));
     list.addPlant(new Plant("Bazalka v kuchyni", 7, LocalDate.of(2021, 1, 3), LocalDate.of(2020,11,5)));

        list.removePlant(1);

//15, Uložte seznam květin do nového souboru a ověřte, že je jeho obsah správný. Výsledný soubor by měl vypadat takto:
        try {
            list.saveToFile(VYSTUP_TXT,DELIMETR);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }


    }
}

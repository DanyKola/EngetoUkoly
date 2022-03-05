package com.company;

import java.time.LocalDate;

public class Plant {
//Vygenerovaná frekvence
    public static final int FREQUENCY_OF_WATERING = 7;

    //1. U každé rostliny budeme mít uložen
    private String name;
    private String notes;
    private int frequencyOfWatering; //frekvence zalívání
    private LocalDate watering; //datum poslední zálivky
    private LocalDate planted; //zasazena


    //2. Vytvořte tři konstruktory:
//2.1. jeden pro nastavení všech atributů
    public Plant(String name, String notes,  int frequencyOfWatering, LocalDate watering,LocalDate planted) {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.frequencyOfWatering = frequencyOfWatering;
    }

    //2.2. druhý nastaví jako poznámku prázdný řetězec a datum poslední zálivky nastaví na dnešní datum.
    public Plant(String name, int frequencyOfWatering, LocalDate planted, LocalDate of) {
        this.name = name;
        this.notes = "";
        this.frequencyOfWatering = frequencyOfWatering;
        this.watering = LocalDate.now();
        this.planted = planted;


    }

// Třetí nastaví totéž co druhý a navíc výchozí frekvenci zálivky na 7 dnů a datum zasazení na dnešní datum. (Uživatel tedy bude zadávat pouze název rostliny.)
    public Plant(String name ) {
        this.name = name;
        this.notes = "";
        this.frequencyOfWatering = FREQUENCY_OF_WATERING;
        this.watering = LocalDate.now().plusDays(7);
        this.planted = LocalDate.now();

    }



//3. Vytvořte výchozí přístupové metody pro všechny atributy.


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public void setWatering(LocalDate lastWatering) throws PlantException {
        LocalDate date = getPlanted();
        if (watering.isBefore(date)) {
            throw new PlantException("Datum zasazení nesmí být později než zalití kytky");
        }
        this.watering = lastWatering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) {
        this.frequencyOfWatering = frequencyOfWatering;
    }

//4. Připravte metodu getWateringInfo(), která vrátí název květiny, datum poslední zálivky a datum doporučené další zálivky. (Metoda vrátí textový řetězec, obsahující požadované informace.)

    public String getWateringInfo() {
        return "Název květiny: " + name + ", Datum poslední zálivky: " + watering + ", Datum doporučené další zálivky: " + watering.plusDays(FREQUENCY_OF_WATERING);
    }

    @Override
    public String toString() {
        return "Název květiny: " + name + ", Datum poslední zálivky: " + watering + ", Datum doporučené další zálivky: " + watering.plusDays(FREQUENCY_OF_WATERING)+ "\n" ;
    }


}


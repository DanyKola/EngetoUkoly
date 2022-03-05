package com.company;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListPlans {
    public static final String DELIMETR = "\t";
    public static final String FILE_NAME = "kvetiny.txt";

    //8. Vytvořte třídu pro ukládání seznamu pokojových květin. Jako atribut bude mít kolekci, uchovávající květiny.
   private List<Plant> plantList = new ArrayList<>();



//9. Přidejte metody pro přidání nové květiny, získání květiny na zadaném pořadí a odebrání květiny ze seznamu.
    //přidání nové květiny
    public void addPlant(Plant newPlant){
        plantList.add(newPlant);
    }
    //odebrání květiny
    public  void removePlant(int plant){
        plantList.remove(plant);
    }

    //získání květiny na zadaném pořadí
    public int indexPlant(int index){
        Plant element = plantList.get(index);
        System.out.println("Výpis: " +element.getName()+ " "+ element.getNotes()+ " "+ element.getPlanted()+" "+element.getWatering());
        return index;
    }

//10. Přidejte do seznamu květin metodu pro načtení květin ze souboru
        //V případě chybného vstupu vyhoďte výjimku.

    public void loadFromFile(String FileName, String DELIMETR){
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(FILE_NAME)));){
            while (scanner.hasNext()){
                String inputLine = scanner.nextLine();
                String[] parts = inputLine.split(DELIMETR);
                String name =parts[0];
                String notes = parts[1];
                int frequencyOfWatering = Integer.parseInt(parts[2]); //frekvence zalívání
                LocalDate watering = LocalDate.parse(parts[3]);
                LocalDate planted = LocalDate.parse(parts[4]);


                Plant plant = new Plant(name, notes, frequencyOfWatering, watering, planted);
                plantList.add(plant);

            }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (DateTimeException e){
                System.err.println("Špatně zadané datum" +e.getLocalizedMessage());
            } catch (NumberFormatException e){
            System.err.println("Špatně zadané číslo" +e.getLocalizedMessage());
        }

    }
//11. Přidejte do seznamu květin metodu pro uložení aktualizovaného seznamu do souboru.
    public void saveToFile(String fileName, String DELIMETR){
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))){
            for (Plant plant : plantList){
                String outputLine =plant.getName()+DELIMETR;
                outputLine += plant.getNotes()+DELIMETR;
                outputLine += plant.getFrequencyOfWatering()+DELIMETR;
                outputLine += plant.getWatering().toString()+DELIMETR;
                outputLine += plant.getPlanted().toString()+"\n";
                writer.print(outputLine);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//12.A Vrací kopii
    public List<Plant> getPlantListALL(){
        return new ArrayList<>(plantList);
    }
    }

package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    //region Demo
    /**
     * Ukázka použítí metody {@link Support#safeReadInt()}
     *
     * Tato metoda použije metodu {@link Support#safeReadInt() k načtení
     * jednoho čísla od uživatele a vypsání tohoto čísla na výstup.
     *
     * Podobně můžeš používat metodu {@link Support#safeReadInt()}
     * i v dalších metodách.
     */

    public static void readOneIntFromInputAndPrintIt() {

    }
    //endregion

    //region Úlohy na cykly
    /**
     * Čte čísla, která zadává uživatel a vypisuje je na výstup.
     * Metoda pokračuje ve čtení opakovaně tak dlouho, dokud uživatel zadává kladná čísla či nulu.
     *
     * Jakmile uživatel zadá záporné číslo, metoda skončí.
     */

//1 - výpis Array
    public static void readIntsFromInputAndPrintItUntilNegative() {
        int input = Support.safeReadInt();


        do {
            System.out.println("You entered: "+input);
            input= Support.safeReadInt();
        } while (input>=0);

    }

    /**
     * Čte čísla ze vstupu tak dlouho, dokud uživatel nezadá záporné číslo.
     * Jako návratovou hodnotu vrátí součet zadaných čísel (záporné číslo by nemělo být zahrnuto).
     *
     * @return Součet všech zadaných čísel (záporné číslo ukončující vstup není zahrnuto).
     */

//2. Součet Array -poslední záporný index
    public static int sumAllInputUntilNegative() {
        int input = 0;
        int suma = 0;

         while(input >= 0){
             suma+=input;
             input = Support.safeReadInt();
             }
            return suma;
         }



    /**
     * Čte čísla ze vstupu tak dlouho, dokud uživatel nezadá záporné číslo.
     * Všechna načtená čísla uloží do listu, který vrátí jako návratovou hodnotu.
     *
     * @return List načtených hodnot (záporná hodnota není zahrnuta v listu)
     */
//3. Vrací list -----
    public static List storeAllInputInArrayListUntilNegative() {
        int input = 0;
        ArrayList<Integer> list = new ArrayList();

        do {
            input= Support.safeReadInt();
            list.add(input);

        } while(input >= 0);
        list.remove(list.size()-1);
         return list;
    }

    /**
     * Dostane jako parametr list čísel. Vypíše čísla na obrazovku. Každé číslo vypiš na samostatný řádek.
     * @param list List čísel, která se mají vypsat.
     */
//4. samostatný řádek
    public static void printAllIntegersFromList(List<Integer> list) {
        for (Integer separateLine : list) {
            System.out.println(separateLine);
        }
    }

        /*
         int input = Support.safeReadInt();
        String number = Integer.toString(input);
        ArrayList <String> list2 = new ArrayList<String>();
        System.out.println("You entered: "+input);

        list2.add(number.replace("","\n"));
        for (String array : list2){
            System.out.println(array);
        }
    }
         */


    /**
     * Sečte hodnoty z listu a vrátí výsledek jako návratovou hodnotu.
     * @param list List čísel, která chceme sečíst.
     * @return Součet všech čísel v listu.
     */

//5. Sečíst list
    public static Integer sumAllIntegersFromList(List<Integer> list) {
        Integer suma = 0;
        for (Integer sumaList : list) {
            suma += sumaList;
        }
        return suma;
    }


    /*
        Integer sum = 0;
       input = Support.safeReadInt();
        ArrayList <Integer> list3 = new ArrayList();
        list3.add(input);
        for (Integer hodnoty : list3){
            sum +=hodnoty;
        }

      return sum;
    }
     */

    //endregion

    //region Podmínky
    /**
     * Vypíše čísla ze seznamu, která jsou menší než zadaný limit.
     * @param list Seznam čísel, která máme zkontrolovat.
     * @param limit Limit - vypsána budou pouze čísla z listu, která jsou menší než limit
     */
 //6. Vypíše čísla, která jsou menší než zadaný limit
    public static void printIntegersUnderLimit(List<Integer> list, int limit) {

        for (Integer nextItem : list){
            if (nextItem< limit){
                System.out.println(nextItem);
            }
        }
    }

    /**
     * Vypíše čísla ze zadaného listu.
     * Při výpisu ale nahradí:
     * - číslo 1 slovem "one",
     * - číslo 2 slovem "two",
     * - číslo 3 slovem "three"
     * Ostatní čísla vypíše jako číselnou hodnotu.
     * Například pokud dostane jako parametr seznam [5, 3, 1, 48, 2],
     * vypíše: 5, three, one, 48, two.
     * @param list Seznam čísel, která se mají vypsat.
     */
    //7. Když zadáš určité číslo vypíše se určitý text
    public static void printIntegersWithReplace(List<Integer> list) {
        for (Integer withReplace : list){
            switch (withReplace){
                case 1:
                    System.out.println("one");
                    break;
                case 2:
                    System.out.println("two");
                    break;
                case 3:
                    System.out.println("three");
                    break;
                default:
                    System.out.println(withReplace);
                    break;
            }
        }

    }
    //endregion

    public static void main(String[] args) {
        // Příklad:
        System.out.println("--- Example - read and print one integer ---");
        readOneIntFromInputAndPrintIt();
        // ---
        System.out.println("--- Task 1 - read and print integers until negative ---");
        readIntsFromInputAndPrintItUntilNegative();
        // ---
        System.out.println("--- Task 2 - sum all integers until negative ---");
        System.out.println("Total sum: " + sumAllInputUntilNegative());;
        // ---
        System.out.println("--- Task 3 - read integers to list until negative ---");
        List<Integer> list = storeAllInputInArrayListUntilNegative();
        System.out.println(list);
        // ---
        System.out.println("--- Task 4 - print all integers from list ---");
        printAllIntegersFromList(list);
        // ---
        System.out.println("--- Task 5 - sum all integers in list ---");
        System.out.println("Total sum: " + sumAllIntegersFromList(list));
        // ---
        System.out.println("--- Task 6 - print integers under 5 from list ---");
        printIntegersUnderLimit(list, 5);
        // ---
        System.out.println("--- Task 7 - print integers - replace: 1 => \"one\", 2 => \"two\", 3 => \"three\" ---");
        printIntegersWithReplace(list);
    }
}

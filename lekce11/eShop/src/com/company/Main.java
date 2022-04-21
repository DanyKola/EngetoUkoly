package com.company;

import java.math.BigDecimal;


public class Main {

    public static void main(String[] args) {
        Method method = new Method();

//1.
        System.out.println(method.loadItemById(10));

//2.
        method.deleteAllOutOfStockItems();

//3.

        System.out.println(method.loadAllAvailableItems());

//4.
        method.saveItem(new Item(11, "P567", "M09", "Váza skleněná", "30x13x10, čirá", 0, BigDecimal.valueOf(243.9)));


//5.
        method.updatePrice(6, BigDecimal.valueOf(100));

    }
}



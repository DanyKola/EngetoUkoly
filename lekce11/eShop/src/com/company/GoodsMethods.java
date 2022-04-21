package com.company;

import java.math.BigDecimal;

public interface GoodsMethods {

    /**
     * This method loads an item with given id
     * @param id - id of the item which we want to load
     * @return
     */
    String loadItemById(Integer id);

    /**
     * This method deletes all items that are not in stock
     */
    void deleteAllOutOfStockItems();

    /**
     * This method loads all items that are in stock
     * @return
     */
    String loadAllAvailableItems();

    /**
     * This method saves the given item
     * @param item - item to be saved
     */
    void saveItem(Item item);

    /**
     * This method updates a price of an item
     * @param id - id of an item which price is to be updated
     * @param newPrice - new price
     */
    void updatePrice(Integer id, BigDecimal newPrice);

}


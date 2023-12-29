package main.java.com.inventorymanagerapp;

import main.java.com.inventorymanagerapp.controller.InventoryController;

public class Main {
    public static void main(String[] args) {
        InventoryController controller = new InventoryController();
        controller.listInventoryItems();
    }
}

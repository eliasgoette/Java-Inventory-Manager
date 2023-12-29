package main.java.com.inventorymanagerapp;

import main.java.com.inventorymanagerapp.controller.InventoryController;
import main.java.com.inventorymanagerapp.repository.SerializedFileInventoryRepository;

public class Main {
    public static void main(String[] args) {
        String filePath = "./";

        SerializedFileInventoryRepository repository = new SerializedFileInventoryRepository(filePath);
        InventoryController controller = new InventoryController(repository);
        controller.listInventoryItems();
    }
}

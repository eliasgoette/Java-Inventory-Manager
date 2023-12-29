package main.java.com.inventorymanagerapp.controller;

import main.java.com.inventorymanagerapp.model.InventoryItem;
import main.java.com.inventorymanagerapp.repository.InventoryRepository;
import java.util.List;

public class InventoryController {
    private InventoryRepository inventoryRepository;

    public InventoryController() {}

    public void listInventoryItems() {
        List<InventoryItem> items = inventoryRepository.findAll();

        for (InventoryItem inventoryItem : items) {
            System.out.println(inventoryItem);
        }
    }

    public void addInventoryItem(InventoryItem item) {
        inventoryRepository.create(item);
    }
}

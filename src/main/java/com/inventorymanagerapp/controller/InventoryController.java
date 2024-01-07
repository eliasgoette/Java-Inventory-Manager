package main.java.com.inventorymanagerapp.controller;

import main.java.com.inventorymanagerapp.model.InventoryItem;
import main.java.com.inventorymanagerapp.repository.InventoryRepository;
import java.util.List;

public class InventoryController {
    private InventoryRepository inventoryRepository;

    public InventoryController(InventoryRepository repository) {
        inventoryRepository = repository;
    }

    public List<InventoryItem> listInventoryItems() {
        List<InventoryItem> items = inventoryRepository.findAll();

        return items;
    }

    public InventoryItem getItemById(String id) {
        InventoryItem item = inventoryRepository.findById(id);
        return item;
    }

    public void addInventoryItem(InventoryItem item) {
        inventoryRepository.create(item);
    }

    public void removeInventoryItem(String id) {
        inventoryRepository.delete(id);
    }

    public void updateInventoryItem(String id, InventoryItem item) {
        inventoryRepository.update(id, item);
    }
}

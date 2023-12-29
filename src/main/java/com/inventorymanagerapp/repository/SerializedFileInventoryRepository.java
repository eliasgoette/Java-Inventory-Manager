package main.java.com.inventorymanagerapp.repository;

import main.java.com.inventorymanagerapp.model.InventoryItem;

import java.io.*;
import java.util.*;

public class SerializedFileInventoryRepository implements InventoryRepository {
    private final String filePath;

    private Map<String, InventoryItem> inventoryMap = new HashMap<>();

    public SerializedFileInventoryRepository(String filePath) {
        this.filePath = filePath;
        loadInventory(); // Load existing inventory items from the file
    }

    private void loadInventory() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            inventoryMap = (Map<String, InventoryItem>) ois.readObject();
        } catch (FileNotFoundException e) {
            // It's okay if the file doesn't exist yet
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load inventory items", e);
        }
    }

    private void saveInventory() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(inventoryMap);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save inventory items", e);
        }
    }

    @Override
    public InventoryItem findById(String id) {
        return inventoryMap.get(id);
    }

    @Override
    public List<InventoryItem> findAll() {
        return new ArrayList<>(inventoryMap.values());
    }

    @Override
    public boolean create(InventoryItem item) {
        try {
            if (item != null && item.getId() != null) {
                inventoryMap.put(item.getId(), item);
                saveInventory(); // Save the updated map to the file
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public boolean update(String id, InventoryItem changes) {
        try {
            if (inventoryMap.containsKey(id)) {
                inventoryMap.replace(id, changes);
                saveInventory(); // Save the updated map to the file
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public boolean delete(String id) {
        try {
            if (inventoryMap.containsKey(id)) {
                inventoryMap.remove(id);
                saveInventory(); // Save the updated map to the file
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
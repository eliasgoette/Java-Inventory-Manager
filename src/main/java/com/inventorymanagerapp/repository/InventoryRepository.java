package main.java.com.inventorymanagerapp.repository;

import main.java.com.inventorymanagerapp.model.InventoryItem;
import java.util.List;

public interface InventoryRepository {
    InventoryItem findById(String id);
    List<InventoryItem> findAll();

    boolean create(InventoryItem item);
    boolean update(String id, InventoryItem changes);
    boolean delete(String id);
}

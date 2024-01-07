package main.java.com.inventorymanagerapp.view;

import main.java.com.inventorymanagerapp.controller.InventoryController;

public interface InventoryView {
    InventoryController inventoryController = null;

    public void initializeUI();
    public void startApplication();
    public void updateInventoryList();
}

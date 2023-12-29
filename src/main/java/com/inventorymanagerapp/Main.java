package main.java.com.inventorymanagerapp;

import javax.swing.SwingUtilities;

import main.java.com.inventorymanagerapp.controller.InventoryController;
import main.java.com.inventorymanagerapp.repository.SerializedFileInventoryRepository;
import main.java.com.inventorymanagerapp.view.InventoryView;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String filePath = "./";
    
            SerializedFileInventoryRepository repository = new SerializedFileInventoryRepository(filePath);
            InventoryController controller = new InventoryController(repository);
            InventoryView app = new InventoryView(controller);

            app.startApplication();
        });
    }
}

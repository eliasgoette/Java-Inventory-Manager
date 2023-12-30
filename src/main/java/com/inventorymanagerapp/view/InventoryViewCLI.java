package main.java.com.inventorymanagerapp.view;

import java.util.Scanner;

import main.java.com.inventorymanagerapp.controller.InventoryController;
import main.java.com.inventorymanagerapp.model.InventoryItem;

public class InventoryViewCLI implements InventoryView {
    private InventoryController inventoryController;
    private boolean running;
    private Scanner scanner;

    public InventoryViewCLI(InventoryController controller) {
        this.inventoryController = controller;
        this.scanner = new Scanner(System.in);
        initializeUI();
    }

    public void initializeUI() {
        System.out.println("Inventory Manager");
        updateInventoryList(); // Initial update of the inventory list
    }

    public void startApplication() {
        this.running = true;

        while (running) {
            getUserInput();
        }
    }

    private void getUserInput() {
        System.out.println("Type nothing and press [enter] for help");
        String input = scanner.nextLine();

        switch (input.toLowerCase()) {
            case "create":
                // displayCreate();
                break;

            case "exit":
                running = false;
                break;
        
            default:
                displayHelp();
                break;
        }
    }

    private void displayHelp() {
        System.out.println();
        System.out.println("Commands:");
        System.out.println();
        System.out.println("create => create item");
        System.out.println("read => display all items in stock");
        System.out.println("update => update item");
        System.out.println("del => delete item");
        System.out.println("exit => close application");
        System.out.println();
    }

    public void updateInventoryList() {
        StringBuilder inventoryListText = new StringBuilder("Current items in stock:\n");

        for (InventoryItem item : inventoryController.listInventoryItems()) {
            inventoryListText.append(item).append("\n");
        }

        System.out.println(inventoryListText);
    }

    public void addItem() {
        // Create a placeholder item
        InventoryItem newItem = new InventoryItem("Placeholder Item", 100);
        inventoryController.addInventoryItem(newItem);
        updateInventoryList();
        System.out.println("Item added successfully!");
    }
}
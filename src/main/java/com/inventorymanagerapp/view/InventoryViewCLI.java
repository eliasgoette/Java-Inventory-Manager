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
            displayStartMenu();
        }
    }

    public void stopApplication() {
        running = false;
    }

    private void displayStartMenu() {
        System.out.println("Inventory Manager Home");
        System.out.println("Type nothing and press [enter] for help");
        String input = scanner.nextLine();

        switch (input.toLowerCase()) {
            case "create":
                displayCreate();
                break;

            case "del":
                displayDelete();
                break;

            case "exit":
                stopApplication();
                break;
        
            default:
                displayHelp();
                break;
        }
    }

    private void displayCreate() {
        System.out.println();
        System.out.println("Create item");

        System.out.println();
        System.out.println("Please enter name, then [enter]");
        String name = scanner.nextLine();

        System.out.println();
        System.out.println("Please enter quantity, then [enter]");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.println();
        InventoryItem newItem = new InventoryItem(name, quantity);
        System.out.println("Preview: " + newItem.toString());

        System.out.println("Confirm? [y/n]");
        boolean confirmation = scanner.nextLine().toLowerCase().equals("y");
        if(confirmation) {
            // Create item using controller
            this.inventoryController.addInventoryItem(newItem);
            System.out.println("Item created");
        }
        else {
            System.out.println("Item discarded");
        }

        System.out.println();
        System.out.println("Create another item? [y/n]");
        if(scanner.nextLine().toLowerCase().equals("y")) {
            displayCreate();
        }

        System.out.println();
    }

    private void displayDelete() {
        System.out.println();
        System.out.println("Delete item");

        System.out.println();
        System.out.println("Please provide an ID to delete, then press [enter]");
        String deleteId = scanner.nextLine();

        if(deleteId != null) {
            InventoryItem deleteItem = inventoryController.getItemById(deleteId);
            System.out.println("Item: " + deleteItem.toString());

            System.out.println("Confirm? [y/n]");
            boolean confirmation = scanner.nextLine().toLowerCase().equals("y");
            if(confirmation) {
                // Delete item using controller
                this.inventoryController.removeInventoryItem(deleteId);
                System.out.println("Item deleted");
            }
            else {
                System.out.println("Deletion cancelled");
            }
        }

        System.out.println();
        System.out.println("Delete another item? [y/n]");
        if(scanner.nextLine().toLowerCase().equals("y")) {
            displayDelete();
        }

        System.out.println();
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

        displayReturnCommand();
    }

    private void displayReturnCommand() {
        System.out.println();
        System.out.println("Press [enter] to return");
        
        scanner.nextLine();
        System.out.println();
    }

    public void updateInventoryList() {
        StringBuilder inventoryListText = new StringBuilder("Current items in stock:\n");

        for (InventoryItem item : inventoryController.listInventoryItems()) {
            inventoryListText.append(item).append("\n");
        }

        System.out.println(inventoryListText);
    }
}
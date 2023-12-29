package main.java.com.inventorymanagerapp.view;

import javax.swing.*;
import main.java.com.inventorymanagerapp.controller.InventoryController;
import main.java.com.inventorymanagerapp.model.InventoryItem;

public class InventoryView {
    private InventoryController inventoryController;
    private JFrame frame;
    private JTextArea inventoryListTextArea;

    public InventoryView(InventoryController controller) {
        this.inventoryController = controller;
        initializeUI();
    }

    private void initializeUI() {
        // Create the frame.
        frame = new JFrame("Inventory Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create components
        JPanel panel = new JPanel();
        inventoryListTextArea = new JTextArea(10, 30);
        inventoryListTextArea.setEditable(false);
        JButton addButton = new JButton("Add Item");
        addButton.addActionListener(e -> addItem());

        // Layout the components.
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxlayout);

        panel.add(new JLabel("Inventory Manager"));
        panel.add(new JScrollPane(inventoryListTextArea));
        panel.add(addButton);

        // Set the panel to the frame
        frame.add(panel);

        updateInventoryList(); // Initial update of the inventory list
    }

    public void startApplication() {
        // Display the window.
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }

    private void updateInventoryList() {
        StringBuilder inventoryListText = new StringBuilder("Current items in stock:\n");

        for (InventoryItem item : inventoryController.listInventoryItems()) {
            inventoryListText.append(item).append("\n"); // Assuming InventoryItem has a meaningful toString()
        }

        inventoryListTextArea.setText(inventoryListText.toString());
    }

    private void addItem() {
        // Create a placeholder item
        InventoryItem newItem = new InventoryItem("Placeholder Item", 100);
        inventoryController.addInventoryItem(newItem);
        updateInventoryList();
        JOptionPane.showMessageDialog(frame, "Item added successfully!");
    }
}

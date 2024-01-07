package main.java.com.inventorymanagerapp.view;

import javax.swing.*;
import main.java.com.inventorymanagerapp.controller.InventoryController;
import main.java.com.inventorymanagerapp.model.InventoryItem;

public class InventoryViewGUI implements InventoryView {
    private InventoryController inventoryController;
    private JFrame frame;
    private JTextArea inventoryListTextArea;

    public InventoryViewGUI(InventoryController controller) {
        this.inventoryController = controller;
        initializeUI();
    }

    public void initializeUI() {
        // Create the frame.
        frame = new JFrame("Inventory Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create components
        JPanel panel = new JPanel();
        inventoryListTextArea = new JTextArea(10, 30);
        inventoryListTextArea.setEditable(false);
        JButton addButton = new JButton("Add Item");
        addButton.addActionListener(e -> displayCreate());

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

    public void updateInventoryList() {
        StringBuilder inventoryListText = new StringBuilder("Current items in stock:\n");

        for (InventoryItem item : inventoryController.listInventoryItems()) {
            inventoryListText.append(item).append("\n");
        }

        inventoryListTextArea.setText(inventoryListText.toString());
    }

    public void displayCreate() {
        // Create a placeholder item
        InventoryItem newItem = new InventoryItem("Placeholder Item", 100);
        inventoryController.addInventoryItem(newItem);
        updateInventoryList();
        JOptionPane.showMessageDialog(frame, "Item added successfully!");
    }

    public void displayDelete() {
        JOptionPane.showMessageDialog(frame, "Delete not implemented yet");
    }
}
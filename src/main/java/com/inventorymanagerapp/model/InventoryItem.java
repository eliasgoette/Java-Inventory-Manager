package main.java.com.inventorymanagerapp.model;

import java.io.Serializable;

public class InventoryItem implements Serializable {
    private static final long serialVersionUID = 1L;  // Unique identifier for serialization

    private String id;
    private String name;
    private int quantity;

    // Constructor, getters, setters, and toString method remain the same
    public InventoryItem(String name, int quantity) {
        this.id = System.currentTimeMillis() + "";
        this.name = name;
        this.quantity = quantity;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "{ id: " + this.id + "; name: " + this.name + "; quantity: " + this.quantity + "; }";
    }
}
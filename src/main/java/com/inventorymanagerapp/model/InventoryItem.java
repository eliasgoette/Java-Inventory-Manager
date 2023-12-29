package main.java.com.inventorymanagerapp.model;

public class InventoryItem {
    private String id;
    private String name;
    private int quantity;

    public InventoryItem(String n, int q) {
        this.id = "P " + Math.random();
        this.name = n;
        this.quantity = q;
    }

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
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
}
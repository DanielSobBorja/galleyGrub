package edu.poniperro.orders;

import java.util.ArrayList;
import java.util.List;

import edu.poniperro.items.Item;
import edu.poniperro.items.ItemFactory;

public class Order implements Comanda {
    
    private double total;
    private List<Item> items;
    

    public Order() {
        items = new ArrayList<>();
    }

    // Interface methods
    @Override
    public void addItem(String name, double price) {
        this.addItem(name, price, null);
    }

    @Override
    public void addItem(String name, double price, String extra) {
        Item item = ItemFactory.getItem(name, price, extra);
        items.add(item);
    }

    @Override
    public int size() {
        return this.items.size();
    }

    @Override
    public List<Item> items() {
        return this.items;
    }

    @Override
    public double getTotal() {
        return this.total;
    }

    @Override
    public void updateTotal(double addition) {
        this.total += addition;
    }

    @Override
    public void display() {
        System.out.println("\n\t --- ORDER ---");
        for (Item i : items) {
            itemDisplay(i);
        }
    }

    // Class methods
    private void itemDisplay(Item item) {
    	System.out.print("\t" + item + "\n");
    }
}
package danisob.galleygrub;

import java.util.ArrayList;
import java.util.List;

public class Order implements Comanda {
    
    private double total;
    private List<Item> itemList;

    public Order() {
        itemList = new ArrayList<>();
    }

    // Interface methods
    @Override
    public void addItem(String name, double price) {
        this.addItem(name, price, null);
    }

    @Override
    public void addItem(String name, double price, String extra) {
        Item item = ItemFactory.getItem(name, price, extra);
        updateTotal(price);
        itemList.add(item);
    }

    @Override
    public int size() {
        return this.itemList.size();
    }

    @Override
    public List<Item> itemList() {
        return this.itemList;
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
        for (Item i : itemList) {
            itemDisplay(i);
        }
    }

    // Class methods
    private void itemDisplay(Item item) {
    	System.out.print("\t" + item + "\n");
    }
}
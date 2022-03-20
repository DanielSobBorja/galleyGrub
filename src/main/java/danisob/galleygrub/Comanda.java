package danisob.galleygrub;

import java.util.List;

public interface Comanda {
    
    public void addItem(String name, double price);
    public void addItem(String name, double price, String extra);
    public int size();
    public List<Item> items();
    public double getTotal();
    public void updateTotal(double quantity);
    public void display();

}

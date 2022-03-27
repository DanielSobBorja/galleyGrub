package edu.poniperro.galleygrub.items;

import edu.poniperro.galleygrub.Prices;

public class Item implements Product {

	protected String name;
	protected double price;
	protected String extra = "";

    public Item(String name, double price) {
        this(name, price, "");
    }

    public Item(String name, double price, String extra) {
        this.name = name;
        this.price = price;
        this.extra = extra;
        ItemFactory.addItem(ItemFactory.size(), this);
    }
    
    @Override
    public String name() {
        return this.name;
    }

    @Override
    public double price() {
        return this.price;
    }
    
    @Override
    public String extra() {
        return this.extra;
    }

    @Override
    public boolean isRegular() {
        return this.extra().isBlank();
    }

	
    @Override 
    public String toString() {
    	String extraStr = this.isRegular() ? "" : " w/ " + this.extra();
    	String extraNum = this.isRegular() ? "" : " + " + String.format("%.2f", Prices.getPrices().get(this.extra())) + "$";
    	return this.name() + extraStr + "...." + String.format("%.2f", this.price()) + "$" + extraNum; 
    }
	 

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Item)) return false;
        Item i = (Item) o;
        return this.hashCode() == i.hashCode();
    }

    @Override
    public int hashCode() {
        int result=17;
        result=31*result+((int)this.price*100);
        result=31*result+(this.name != null ? this.name.hashCode() : 0);
        result=31*result+(this.extra != null ? this.extra.hashCode() : 0);
        return result;
    }
    

}

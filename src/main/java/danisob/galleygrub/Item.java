package danisob.galleygrub;

public class Item implements Product {

    private String name;
    private double price;
    private String extra;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Item(String name, double price, String extra) {
        this.name = name;
        this.price = price;
        this.extra = extra;
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
        //return extra == null ? true : false; // regular si no tiene extras?
        return false; // FIXME:
    }

    @Override
    public String toString() {
        return this.name() + "...." + this.price() + "$";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true; // sí mismo
        if (!(o instanceof Item)) return false;
        Item i = (Item) o;
        return this.name == i.name();
    }

    @Override
    public int hashCode() {
        int result=17;
        result=31*result+((int)this.price*100);
        result=31*result+(this.name!=null ? this.name.hashCode():0);
        result=31*result+(this.extra!=null ? this.extra.hashCode():0);
        return result;
    }
    

}
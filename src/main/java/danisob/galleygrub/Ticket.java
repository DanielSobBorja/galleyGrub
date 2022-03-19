package danisob.galleygrub;

public interface Ticket {

    public Comanda getOrder();
    public void setChain(Extra extra);
    public Extra getChain();
    public double total();
    public void sumExtrasCharge();
    public void print();
    
}
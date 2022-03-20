package danisob.galleygrub;

import danisob.galleygrub.extras.Extra;

public interface Ticket {

    public Comanda getOrder();
    public void setChain(Extra extra);
    public Extra getChain();
    public double total();
    public void sumExtrasCharge();
    public void print();
    
}
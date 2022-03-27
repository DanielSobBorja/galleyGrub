package edu.poniperro.galleygrub.receipts;

import edu.poniperro.galleygrub.extras.Extra;
import edu.poniperro.galleygrub.orders.Comanda;

public interface Ticket {

    public Comanda getOrder();
    public void setChain(Extra extra);
    public Extra getChain();
    public double total();
    public void sumExtrasCharge();
    public void print();
    
}
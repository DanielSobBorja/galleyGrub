package edu.poniperro.receipts;

import edu.poniperro.extras.Extra;
import edu.poniperro.orders.Comanda;

public interface Ticket {

    public Comanda getOrder();
    public void setChain(Extra extra);
    public Extra getChain();
    public double total();
    public void sumExtrasCharge();
    public void print();
    
}
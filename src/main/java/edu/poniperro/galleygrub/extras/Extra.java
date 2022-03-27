package edu.poniperro.galleygrub.extras;

import edu.poniperro.galleygrub.orders.Comanda;

import java.util.Optional;


public abstract class Extra {

    protected Optional<Extra> nextExtra = Optional.ofNullable(null);
    
    public Extra() {}
    
    public void setNextExtra(Extra extra) {
    	nextExtra = Optional.of(extra);
    }
    
    public abstract void sumExtras(Comanda comanda);
    
}

package edu.poniperro.extras;

import edu.poniperro.orders.Comanda;

import java.util.Optional;


public abstract class Extra {
	
    protected static final String CHEESE = "cheese";
    protected static final String SAUCE = "sauce";
    protected static final String SIZE_LARGE = "large";
    //protected String extraProduct;
    protected Optional<Extra> nextExtra;
    
    public Extra() {
    	
    }
    
    public void setNextExtra(Extra extra) {
    	nextExtra = Optional.of(extra);
    }
    
    public abstract void sumExtras(Comanda comanda);
    
}

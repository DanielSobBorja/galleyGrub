package danisob.galleygrub;

import java.util.Optional;

public abstract class Extra {
	
    private static final String CHEESE = "cheese";
    private static final String SAUCE = "sauce";
    private static final String SIZE_LARGE = "large";
    private String extraProduct;
    private Optional<Extra> nextExtra;
    
    public Extra() {
    	
    }
    
    public void setNextExtra() {
    	
    }
    
    public abstract void sumExtras(Comanda comanda);
    
}

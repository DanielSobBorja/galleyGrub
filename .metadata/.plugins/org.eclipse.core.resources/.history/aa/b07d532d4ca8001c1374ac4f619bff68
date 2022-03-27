package danisob.galleygrub;

import java.util.HashMap;
import java.util.Map;

public class Prices {

    private static HashMap<String, Double> prices = new HashMap<String, Double>();
    
    public static HashMap<String, Double> getPrices() {
    	return prices;
    }

    public static void init_prices() {
        prices.put("cheese", 0.25);
        prices.put("sauce", 0.50);
        prices.put("medium", 0.25);
        prices.put("large", 0.50);
    }

    public static void display() {
        for (Map.Entry<String, Double> entry : prices.entrySet()) {
            System.out.println("\t" + entry.getKey()+"....+"+ String.format("%.2f",entry.getValue()) + "$");
        }
    }
}

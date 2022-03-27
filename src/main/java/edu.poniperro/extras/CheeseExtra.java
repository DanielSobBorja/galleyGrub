package edu.poniperro.extras;


import edu.poniperro.Prices;
import edu.poniperro.items.Item;
import edu.poniperro.orders.Comanda;

public class CheeseExtra extends Extra {
	
	private double CHEESE_PRICE = Prices.getPrices().get("cheese");
	
	public CheeseExtra() {
		
	}
	
	@Override
	public void sumExtras(Comanda comanda) {
		int quantity = 0;
		for (Item i : comanda.items()) {
			if (i.extra() == CHEESE) {
				quantity++;
			}
		}
		comanda.updateTotal(CHEESE_PRICE * quantity);
		if (nextExtra != null) {
			nextExtra.ifPresent(n -> n.sumExtras(comanda));
		}
	}
}

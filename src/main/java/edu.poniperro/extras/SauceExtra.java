package edu.poniperro.extras;

import edu.poniperro.Prices;
import edu.poniperro.items.Item;
import edu.poniperro.orders.Comanda;

public class SauceExtra extends Extra {
	
	private double SAUCE_PRICE = Prices.getPrices().get("sauce");
	
	public SauceExtra() {
		
	}
	
	@Override
	public void sumExtras(Comanda comanda) {
		int quantity = 0;
		for (Item i : comanda.items()) {
			if (i.extra() == SAUCE) {
				quantity++;
			}
		}
		comanda.updateTotal(SAUCE_PRICE * quantity);
		if (nextExtra != null) {
			nextExtra.ifPresent(n -> n.sumExtras(comanda));
		}
	}
}

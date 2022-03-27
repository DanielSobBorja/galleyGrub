package edu.poniperro.extras;

import edu.poniperro.orders.Comanda;
import edu.poniperro.items.Item;
import edu.poniperro.Prices;

public class SizeLargeExtra extends Extra {
	
	private double LARGE_PRICE = Prices.getPrices().get("large");
	
	public SizeLargeExtra() {
		
	}
	
	@Override
	public void sumExtras(Comanda comanda) {
		int quantity = 0;
		for (Item i : comanda.items()) {
			if (i.extra() == SIZE_LARGE) {
				quantity++;
			}
		}
		comanda.updateTotal(LARGE_PRICE * quantity);
		if (nextExtra != null) {
			nextExtra.ifPresent(n -> n.sumExtras(comanda));
		}
	}
}

package edu.poniperro.extras;

import edu.poniperro.items.Item;
import edu.poniperro.orders.Comanda;

public class Regular extends Extra {
	
	public Regular() {
		
	}
	
	@Override
	public void sumExtras(Comanda comanda) {
		for (Item i : comanda.items()) {
			comanda.updateTotal(i.price());
		}
		if (nextExtra != null) {
			nextExtra.ifPresent(n -> n.sumExtras(comanda));
		}
		
	}
}

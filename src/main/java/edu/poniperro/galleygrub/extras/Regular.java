package edu.poniperro.galleygrub.extras;

import edu.poniperro.galleygrub.items.Item;
import edu.poniperro.galleygrub.orders.Comanda;

import java.util.Optional;

public class Regular extends Extra {
	
	public Regular() {}
	
	@Override
	public void sumExtras(Comanda comanda) {
		Optional<Double> itemPrices = comanda.items().stream()
				.map(Item::price)
				.reduce(Double::sum);

		if (itemPrices.isPresent()) {
			comanda.updateTotal(itemPrices.get());
		}

		this.nextExtra.ifPresent(chain -> chain.sumExtras(comanda));
	}
}

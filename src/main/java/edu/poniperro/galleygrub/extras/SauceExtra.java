package edu.poniperro.galleygrub.extras;

import edu.poniperro.galleygrub.orders.Comanda;

import java.util.Optional;

public class SauceExtra extends Extra {

	public SauceExtra() {}
	
	@Override
	public void sumExtras(Comanda comanda) {
		Optional<Double> saucePrice = comanda.items().stream()
				.filter(item -> item.extra().equalsIgnoreCase(Extras.SAUCE.name()))
				.map(item -> Extras.SAUCE.getPrice())
				.reduce(Double::sum);

		if (saucePrice.isPresent()) {
			comanda.updateTotal(saucePrice.get());
		}

		this.nextExtra.ifPresent(n -> n.sumExtras(comanda));
	}
}

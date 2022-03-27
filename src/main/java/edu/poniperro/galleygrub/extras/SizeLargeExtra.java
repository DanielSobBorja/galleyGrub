package edu.poniperro.galleygrub.extras;

import edu.poniperro.galleygrub.orders.Comanda;

import java.util.Optional;

public class SizeLargeExtra extends Extra {
	
	public SizeLargeExtra() {}
	
	@Override
	public void sumExtras(Comanda comanda) {
		Optional<Double> largePrice = comanda.items().stream()
						.filter(item -> item.extra().equalsIgnoreCase(Extras.LARGE.name()))
								.map(item -> Extras.LARGE.getPrice())
										.reduce(Double::sum);

		if (largePrice.isPresent()) {
			comanda.updateTotal(largePrice.get());
		}

		this.nextExtra.ifPresent(n -> n.sumExtras(comanda));

	}
}

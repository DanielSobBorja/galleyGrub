package edu.poniperro.galleygrub.extras;

import edu.poniperro.galleygrub.orders.Comanda;

import java.util.Optional;

public class CheeseExtra extends Extra {
	
	public CheeseExtra() {}
	
	@Override
	public void sumExtras(Comanda comanda) {
		Optional<Double> cheesePrice = comanda.items().stream()
				.filter(item -> item.extra().equalsIgnoreCase(Extras.CHEESE.name()))
				.map(item -> Extras.CHEESE.getPrice())
				.reduce(Double::sum);
		
		if (cheesePrice.isPresent()) {
			comanda.updateTotal(cheesePrice.get());
		}

		this.nextExtra.ifPresent(n -> n.sumExtras(comanda));
	}
}

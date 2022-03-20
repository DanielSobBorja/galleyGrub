package danisob.galleygrub.extras;

import danisob.galleygrub.Comanda;
import danisob.galleygrub.Item;
import danisob.galleygrub.Prices;

public class CheeseExtra extends Extra {
	
	private double CHEESE_PRICE = Prices.getPrices().get("cheese");
	
	public CheeseExtra() {
		
	}
	
	@Override
	public void sumExtras(Comanda comanda) {
		int quantity = 0;
		for (Item i : comanda.items()) {
			if (i.extra() == "cheese") {
				quantity++;
			}
		}
		comanda.updateTotal(CHEESE_PRICE * quantity);
		if (nextExtra != null) {
			nextExtra.ifPresent(n -> n.sumExtras(comanda));
		}
	}
}

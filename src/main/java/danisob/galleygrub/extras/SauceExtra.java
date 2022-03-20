package danisob.galleygrub.extras;

import danisob.galleygrub.Comanda;
import danisob.galleygrub.Item;
import danisob.galleygrub.Prices;

public class SauceExtra extends Extra {
	
	private double SAUCE_PRICE = Prices.getPrices().get("sauce");
	
	public SauceExtra() {
		
	}
	
	@Override
	public void sumExtras(Comanda comanda) {
		int quantity = 0;
		for (Item i : comanda.items()) {
			if (i.extra() == "sauce") {
				quantity++;
			}
		}
		comanda.updateTotal(SAUCE_PRICE * quantity);
		if (nextExtra != null) {
			nextExtra.ifPresent(n -> n.sumExtras(comanda));
		}
	}
}

package danisob.galleygrub.extras;

import danisob.galleygrub.Comanda;
import danisob.galleygrub.Item;
import danisob.galleygrub.Prices;

public class SizeLargeExtra extends Extra {
	
	private double LARGE_PRICE = Prices.getPrices().get("large");
	
	public SizeLargeExtra() {
		
	}
	
	@Override
	public void sumExtras(Comanda comanda) {
		int quantity = 0;
		for (Item i : comanda.items()) {
			if (i.extra() == "large") {
				quantity++;
			}
		}
		comanda.updateTotal(LARGE_PRICE * quantity);
		if (nextExtra != null) {
			nextExtra.ifPresent(n -> n.sumExtras(comanda));
		}
	}
}

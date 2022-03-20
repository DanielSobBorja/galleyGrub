package danisob.galleygrub.extras;

import danisob.galleygrub.Comanda;
import danisob.galleygrub.Item;

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

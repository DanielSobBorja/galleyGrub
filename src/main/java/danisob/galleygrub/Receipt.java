package danisob.galleygrub;

public class Receipt implements Ticket {
    
    private double total;
    private Comanda order;

    public Receipt(Comanda order) {
    	this.total = order.getTotal();
    	this.order = order;
    }

    @Override
    public Comanda getOrder() {
        return order;
    }
    
    @Override
    public void setChain(Extra extra) {
        // FIXME:
    }

    @Override
    public Extra getChain() {
        return null; // FIXME:
    }

    @Override
    public double total() {
    	return this.total;
    }

    @Override
    public void sumExtrasCharge() {
        // FIXME:
    }

    @Override
    public void print() {
    	System.out.println("\n\t --- ORDER ---");
    	if (this.order instanceof Order) {
    		Order ord = (Order) this.order;
    		for (Item i : ord.itemList()) {
    			String extraStr = i.extra() == null ? "" : " w/ " + i.extra();
    	        System.out.print("\t" + i.name() + extraStr + "...." + i.price() + "$\n");
            }
    		return;
    	}
    	System.out.println("Cannot print order of type " + this.order.getClass());
        
    }


}
package danisob.galleygrub;

import danisob.galleygrub.extras.Extra;

public class Receipt implements Ticket {
    
    private double total;
    private Comanda order;
    private Extra firstExtra;

    public Receipt(Comanda order) {
    	this.order = order;
    }

    @Override
    public Comanda getOrder() {
        return this.order;
    }
    
    @Override
    public void setChain(Extra extra) {
        this.firstExtra = extra;
    }

    @Override
    public Extra getChain() {
        return this.firstExtra;
    }

    @Override
    public double total() {
    	this.sumExtrasCharge();
    	this.total = order.getTotal();
    	return this.total;
    }

    @Override
    public void sumExtrasCharge() {
    	if (firstExtra != null) {
    		this.firstExtra.sumExtras(order);
    	}
    }

    @Override
    public void print() {
    	System.out.println("\n\t --- RECEIPT ---");
    	if (this.order instanceof Order) {
    		Order ord = (Order) this.order;
    		String extraStr;
    		String extraNum;
    		for (Item i : ord.items()) {
    			extraStr = "";
    			extraNum = "";
    			if (!i.isRegular()) {
    				extraStr = " w/ " + i.extra();
    				extraNum = " + " + String.format("%.2f", Prices.getPrices().get(i.extra())) + "$";
    			}
    	        System.out.print("\t" + i.name() + extraStr + "...." + String.format("%.2f",i.price()) + "$" + extraNum + "\n");
            }
    		System.out.println("\tTOTAL --------> " + String.format("%.2f", this.total) + "$");
    		return;
    	}
    	System.out.println("Cannot print comanda of type " + this.order.getClass());
        
    }


}
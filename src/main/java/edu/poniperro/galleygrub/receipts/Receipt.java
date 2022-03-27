package edu.poniperro.galleygrub.receipts;

import edu.poniperro.galleygrub.Prices;
import edu.poniperro.galleygrub.extras.Extra;
import edu.poniperro.galleygrub.items.Item;
import edu.poniperro.galleygrub.orders.Comanda;
import edu.poniperro.galleygrub.orders.Order;

public class Receipt implements Ticket {
    
    private double total = 0d;
    private Comanda order;
    private Extra firstExtra = null;

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
        if (this.total == 0d) {
            this.sumExtrasCharge();
            this.total = this.order.getTotal();
        }
    	return this.total;
    }

    @Override
    public void sumExtrasCharge() {
    	if (this.firstExtra != null) {
            this.firstExtra.sumExtras(this.order);
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
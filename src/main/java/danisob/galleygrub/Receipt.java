package danisob.galleygrub;

public class Receipt implements Ticket {
    
    private double total;

    public Receipt(Comanda order) {
        this.total = order.getTotal();
    }

    @Override
    public Comanda getOrder() {
        return null; // FIXME:
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
        return 0.0; // FIXME:
    }

    @Override
    public void sumExtrasCharge() {
        // FIXME:
    }

    @Override
    public void print() {
        // FIXME:
    }

    

}
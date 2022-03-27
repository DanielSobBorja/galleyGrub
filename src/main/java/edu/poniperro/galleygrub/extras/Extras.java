package edu.poniperro.galleygrub.extras;

public enum Extras {
    CHEESE(0.25d), SAUCE(0.50d), MEDIUM(0.25d), LARGE(0.50d);

    private Double price = 0d;

    private Extras(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return this.price;
    }
}

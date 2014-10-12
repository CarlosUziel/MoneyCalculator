package moneycalculator;

public class Money {

    private final float quantity;
    private final Currency currency;

    public Money(float quantity, Currency currency) {
        this.quantity = quantity;
        this.currency = currency;
    }

    public float getQuantity() {
        return quantity;
    }

    public Currency getCurrency() {
        return currency;
    }

}

package View.Process;

import Model.ExchangeRate;
import Model.Money;

public class Exchanger {

    private final float quantity;
    private final ExchangeRate exchangeRate;

    public Exchanger(float quantity, ExchangeRate exchangeRate) {
        this.quantity = quantity;
        this.exchangeRate = exchangeRate;
    }

    public Money getMoney() {
        return new Money(getExchange(), exchangeRate.getCurrencyTo());
    }

    private float getExchange() {
        return quantity * exchangeRate.loadRate();
    }
}

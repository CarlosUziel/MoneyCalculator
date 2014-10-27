package Model;

import Model.Currency;

public class ExchangeRate {

    private final Currency currency0;
    private final Currency currency1;
    private final float rate;

    public ExchangeRate(Currency currency0, Currency currency1, float rate) {
        this.currency0 = currency0;
        this.currency1 = currency1;
        this.rate = rate;
    }

    public Currency getCurrency0() {
        return currency0;
    }

    public Currency getCurrency1() {
        return currency1;
    }

}

package View.Persistence;

import Model.Currency;
import Model.ExchangeRate;

public class ExchangeRateLoader {

    private final Currency currencyFrom;
    private final Currency currencyTo;

    public ExchangeRateLoader(Currency currencyFrom, Currency currencyTo) {
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
    }

    public ExchangeRate load() {
        return new ExchangeRate(currencyFrom, currencyTo);
    }

}

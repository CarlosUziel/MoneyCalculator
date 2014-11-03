package View.Persistence;

import Model.Currency;
import Model.ExchangeRate;

public class ExchangeRateLoader {

    public ExchangeRate load(Currency currencyFrom, Currency currencyTo) {
        return new ExchangeRate(currencyFrom, currencyTo,
                readRate(currencyFrom, currencyTo));
    }

    private float readRate(Currency currencyFrom, Currency currencyTo) {
        return (float) 0.1;
    }
}

package Model;

public final class ExchangeRate {

    private final Currency currencyFrom;
    private final Currency currencyTo;

    public ExchangeRate(Currency currencyFrom, Currency currencyTo) {
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
    }

    public Currency getCurrencyFrom() {
        return currencyFrom;
    }

    public Currency getCurrencyTo() {
        return currencyTo;
    }

    public float loadRate() {
        //Usar campos currencyFrom y currencyTo
        return 0;
    }

}

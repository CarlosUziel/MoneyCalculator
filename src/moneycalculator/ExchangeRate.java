package moneycalculator;

public class ExchangeRate {
    
    private final Currency currency0;
    private final Currency currency1;

    public ExchangeRate(Currency currency0, Currency currency1) {
        this.currency0 = currency0;
        this.currency1 = currency1;
    }

    public Currency getCurrency0() {
        return currency0;
    }

    public Currency getCurrency1() {
        return currency1;
    }
    
    
}

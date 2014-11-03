package View.UI;

import Model.CurrencySet;
import Model.Exchange;
import Model.Money;

public class ExchangeDialog {

    private final CurrencySet currencySet;

    public ExchangeDialog(CurrencySet currencySet) {
        this.currencySet = currencySet;
    }

    public Exchange returnExchange() {
        //Devolver un Exchange que contenga un Money (cantidad y currency iniciales) y el currency destino.
        return new Exchange(new Money(1, currencySet.search()), currencySet.search());
    }

}

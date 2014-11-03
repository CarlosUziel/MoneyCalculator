package View.UI;

import Model.CurrencySet;
import Model.Exchange;

public class ExchangeDialog {

    private final CurrencySet currencySet;
    private final Exchange exchange;

    public ExchangeDialog(CurrencySet currencySet) {
        this.currencySet = currencySet;
        this.exchange = loadExchange();
    }

    public Exchange getExchange() {
        return exchange;
    }

    private Exchange loadExchange() {
        return null;
    }
}

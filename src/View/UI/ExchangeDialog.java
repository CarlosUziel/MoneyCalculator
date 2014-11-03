package View.UI;

import Model.CurrencySet;
import Model.Exchange;

public class ExchangeDialog {

    private final CurrencySet currencySet;
    private Exchange exchange;

    public ExchangeDialog(CurrencySet currencySet) {
        this.currencySet = currencySet;
    }
    private Exchange loadExchange() {
        return null;
    }

    public Exchange getExchange() {
        return exchange;
    }

}

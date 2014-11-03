package Control;

import Model.CurrencySet;
import Model.Exchange;
import Model.ExchangeRate;
import Model.Money;
import View.Persistence.ExchangeRateLoader;
import View.Process.Exchanger;
import View.UI.ExchangeDialog;
import View.UI.MoneyDisplay;

public class ExchangeCommand {

    private final CurrencySet currencySet;

    public ExchangeCommand(CurrencySet currencySet) {
        this.currencySet = currencySet;
    }

    public void exec() {
        //LLamar a ExchangeDialog - Devuelve un exchange
        ExchangeDialog exchangeDialog = new ExchangeDialog(currencySet);
        Exchange exchange = exchangeDialog.returnExchange();
        //Llama a ExchangeRateLoader y devuelve un ExchangeRate
        ExchangeRate exchangeRate = new ExchangeRateLoader(exchange.getMoney().getCurrency(),exchange.getCurrencyTo()).load();
        //LLama a Exchanger y se obtiene un money
        Money money = new Exchanger(exchange.getMoney().getQuantity(), exchangeRate).getMoney();
        //Llama a MoneyDispaly que muestra el dinero final
        new MoneyDisplay(money);
    }

}

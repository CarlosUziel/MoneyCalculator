package Control;

import Model.CurrencySet;
import Model.Exchange;
import Model.ExchangeRate;
import Model.ExchangeRateSet;
import Model.Money;
import View.Process.Exchanger;
import View.UI.ExchangeDialog;
import View.UI.MoneyDisplay;

public class ExchangeCommand implements Command {

    private final CurrencySet currencySet;
    private final ExchangeRateSet exchangeRateSet;
    private final ExchangeDialog exchangeDialog;
    private final MoneyDisplay moneyPanel;

    // TODO Poner exchange rate set en vez de connection
    public ExchangeCommand(CurrencySet currencySet, ExchangeRateSet exchangeRateSet, ExchangeDialog exchangeDialog, MoneyDisplay moneyPanel) {
        this.currencySet = currencySet;
        this.exchangeRateSet = exchangeRateSet;
        this.exchangeDialog = exchangeDialog;
        this.moneyPanel = moneyPanel;
    }

    @Override
    public void execute() {
        Exchange exchange = readExchange(exchangeDialog);
        ExchangeRate exchangeRate = readExchangeRate(exchange);
        Money money = readMoney(exchange, exchangeRate);
        displayMoney(moneyPanel, money);
    }

    private Exchange readExchange(ExchangeDialog exchangeDialog) {
        return exchangeDialog.getExchange();
    }

    private ExchangeRate readExchangeRate(Exchange exchange){
        return exchangeRateSet.getExchangeRate(exchange);
    }

    private Money readMoney(Exchange exchange, ExchangeRate exchangeRate) {
        return new Exchanger(exchange.getMoney().getQuantity(), exchangeRate).getMoney();
    }

    private void displayMoney(MoneyDisplay moneyPanel, Money money) {
        moneyPanel.display(money);
    }

    @Override
    public boolean available() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

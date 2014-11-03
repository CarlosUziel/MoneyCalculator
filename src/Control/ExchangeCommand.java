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
        ExchangeDialog exchangeDialog = readExchangeDialog(currencySet);
        Exchange exchange = readExchange(exchangeDialog);
        ExchangeRate exchangeRate = readExchangeRate(exchange);
        Money money = readMoney(exchange, exchangeRate);
        readMoneyDisplay(money);
    }
    
    private ExchangeDialog readExchangeDialog(CurrencySet currencySet){
        return new ExchangeDialog(currencySet);
    }
    
    private Exchange readExchange(ExchangeDialog exchangeDialog){
        return exchangeDialog.getExchange();
    }
    
    private ExchangeRate readExchangeRate(Exchange exchange){
        return new ExchangeRateLoader().load(exchange.getMoney().getCurrency(), exchange.getCurrencyTo());
    }
    
    private Money readMoney(Exchange exchange, ExchangeRate exchangeRate){
        return new Exchanger(exchange.getMoney().getQuantity(), exchangeRate).getMoney();
    }

    private MoneyDisplay readMoneyDisplay(Money money){
        return new MoneyDisplay(money);
    }
}

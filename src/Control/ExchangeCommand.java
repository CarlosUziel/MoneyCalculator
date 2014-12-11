package Control;

import Model.CurrencySet;
import Model.Exchange;
import Model.ExchangeRate;
import Model.Money;
import View.Persistence.DatabaseExchangeRateLoader;
import View.Process.Exchanger;
import View.UI.ExchangeDialog;
import View.UI.MoneyDisplay;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExchangeCommand {

    private final CurrencySet currencySet;

    public ExchangeCommand(CurrencySet currencySet) {
        this.currencySet = currencySet;
    }

    public void exec() throws SQLException {        
        Exchange exchange = readExchange(exchangeDialog);
        ExchangeRate exchangeRate = readExchangeRate(exchange);
        Money money = readMoney(exchange, exchangeRate);
        readMoneyDisplay(money);
    }
    
    private Exchange readExchange(ExchangeDialog exchangeDialog){
        return exchangeDialog.getExchange();
    }
    
    private ExchangeRate readExchangeRate(Exchange exchange) throws SQLException{
        return new DatabaseExchangeRateLoader(createConnection("orcl.db")).load(exchange.getMoney().getCurrency(), exchange.getCurrencyTo());
    }
    
    private Money readMoney(Exchange exchange, ExchangeRate exchangeRate){
        return new Exchanger(exchange.getMoney().getQuantity(), exchangeRate).getMoney();
    }

    private MoneyDisplay readMoneyDisplay(Money money){
        return new MoneyDisplay(money);
    }

    private Connection createConnection(String dbPath) throws SQLException {
        DriverManager.registerDriver(new org.sqlite.JDBC());
        return DriverManager.getConnection("jdbc:sqlite:" + dbPath);
    }
}

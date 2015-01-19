package Model;

import View.Persistence.DatabaseExchangeRateLoader;
import java.sql.Connection;

public class ExchangeRateSet {
    private final Connection connection;

    public ExchangeRateSet(Connection connection) {
        this.connection = connection;
    }
    
    public ExchangeRate getExchangeRate(Exchange exchange){
        return new DatabaseExchangeRateLoader(connection).load(exchange.getMoney().getCurrency(), exchange.getCurrencyTo());
    }
}

package App;

import Control.ExchangeCommand;
import Model.Currency;
import Model.CurrencySet;
import View.Persistence.DatabaseCurrencySetLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Aplication {

    private static CurrencySet currencySet;
    private static ExchangeCommand exchangeCommand;

    public static void main(String[] args) throws SQLException {
        currencySet = new DatabaseCurrencySetLoader(createConnection("192.168.56.101:5560")).load();
        ArrayList<Currency> currencies = currencySet.getCurrencySet();
        
        for (Currency currency : currencies) {
            System.out.println(currency.getCode());
        }
        
//        exchangeCommand = new ExchangeCommand(currencySet);
//        exchangeCommand.exec();
    }
    
    private static Connection createConnection(String dbPath) throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
        return DriverManager.getConnection("jdbc:oracle:thin:" + dbPath, "system", "orcl");
    }
}

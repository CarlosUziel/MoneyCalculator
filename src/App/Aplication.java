package App;

import Control.ExchangeCommand;
import Model.Currency;
import Model.CurrencySet;
import View.Persistence.DatabaseCurrencySetLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.driver.OracleDriver;

public class Aplication {

    private static CurrencySet currencySet;
    private static ExchangeCommand exchangeCommand;

    public static void main(String[] args) throws SQLException {
        Connection connection = createConnection("jdbc:oracle:thin:@localhost:1521:orcl");

//        currencySet = new DatabaseCurrencySetLoader(connection).load();
//        ArrayList<Currency> currencies = currencySet.getCurrencySet();
//        
//        for (Currency currency : currencies) {
//            System.out.println(currency.getCode());
//        }
//        exchangeCommand = new ExchangeCommand(currencySet);
//        exchangeCommand.exec();
    }

    private static Connection createConnection(String dbPath) throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        return DriverManager.getConnection(dbPath, "system", "orcl");
    }
}

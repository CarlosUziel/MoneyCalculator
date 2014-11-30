package App;

import Control.ExchangeCommand;
import Model.CurrencySet;
import View.Persistence.DatabaseCurrencySetLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Aplication {

    private static CurrencySet currencySet;
    private static ExchangeCommand exchangeCommand;

    public static void main(String[] args) throws SQLException {
        currencySet = new DatabaseCurrencySetLoader(createConnection("orcl.db")).load();
        exchangeCommand = new ExchangeCommand(currencySet);
        exchangeCommand.exec();
    }
    
    private static Connection createConnection(String dbPath) throws SQLException {
        DriverManager.registerDriver(new org.sqlite.JDBC());
        return DriverManager.getConnection("jdbc:sqlite:" + dbPath);
    }
}

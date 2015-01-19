package App;

import Model.ExchangeRateSet;
import Control.ExchangeCommand;
import Model.CurrencySet;
import Swing.ApplicationFrame;
import View.Persistence.DatabaseCurrencySetLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Aplication {

    private static CurrencySet currencySet;
    private static ExchangeRateSet exchangeRateSet;
    private static ExchangeCommand exchangeCommand;

    public static void main(String[] args) throws SQLException {
        Connection connection = createOracleConnection("192.168.56.101:1521:ORCL");

        currencySet = new DatabaseCurrencySetLoader(connection).load();
        exchangeRateSet = new ExchangeRateSet(connection);
        ApplicationFrame frame = new ApplicationFrame(currencySet);
        exchangeCommand = new ExchangeCommand(currencySet, exchangeRateSet, frame.getExchangeDialog(), frame.getMoneyPanel());
        frame.registerCommand(exchangeCommand);
    }

    private static Connection createOracleConnection(String dbPath) throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        return DriverManager.getConnection("jdbc:oracle:thin:@" + dbPath, "system", "orcl");
    }
}

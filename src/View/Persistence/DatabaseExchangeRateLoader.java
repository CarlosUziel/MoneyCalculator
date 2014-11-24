package View.Persistence;

import Model.Currency;
import Model.ExchangeRate;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseExchangeRateLoader implements ExchangeRateLoader {

    private final Connection connection;

    public DatabaseExchangeRateLoader(Connection connection) {
        this.connection = connection;
        
    }

    @Override
    public ExchangeRate load(Currency currencyFrom, Currency  currencyTo) {
        try {
            return processQuery(connection.createStatement().executeQuery(
                    "Select rate "
                            + "FROM CURRENCY "
                            + "WHERE currencyFrom = " + currencyFrom
                            + " AND currencyTo = " + currencyTo));
        } catch (SQLException ex) {
            return null;
        }
    }

    private ExchangeRate processQuery(ResultSet resultSet) throws SQLException {
        ArrayList<Currency> currencySet = new ArrayList<>();
        while (resultSet.next()) {
            currencySet.add(processCurrency(resultSet));
        }
        return new ExchangeRate(currencySet);
    }

    private Currency processCurrency(ResultSet resultSet) throws SQLException {
        return new Currency(
                resultSet.getInt("code"),
                resultSet.getString("name"),
                resultSet.getString("symbol"));
    }

}

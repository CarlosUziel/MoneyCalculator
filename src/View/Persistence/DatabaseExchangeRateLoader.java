package View.Persistence;

import Model.Currency;
import Model.ExchangeRate;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseExchangeRateLoader implements ExchangeRateLoader {

    private final Connection connection;

    public DatabaseExchangeRateLoader(Connection connection) {
        this.connection = connection;

    }

    @Override
    public ExchangeRate load(Currency currencyFrom, Currency currencyTo) {
        try {
            return processQuery(connection.createStatement().executeQuery(
                    "Select * "
                    + "FROM EXCHANGE_RATE "
                    + "WHERE CURRENCYFROM = " + currencyFrom.getCode()
                    + " AND CURRENCYTO = " + currencyTo.getCode()),
                    currencyFrom, currencyTo);
        } catch (SQLException ex) {
            return null;
        }
    }

    private ExchangeRate processQuery(ResultSet resultSet, Currency currencyFrom, Currency currencyTo) throws SQLException {
        return new ExchangeRate(
                currencyFrom,
                currencyTo,
                resultSet.getFloat("rate"));
    }

}

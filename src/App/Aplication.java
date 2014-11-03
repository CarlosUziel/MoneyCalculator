package App;

import Control.ExchangeCommand;
import Model.CurrencySet;
import View.Persistence.CurrencySetLoader;

public class Aplication {

    private static CurrencySet currencySet;
    private static ExchangeCommand exchangeCommand;

    public static void main(String[] args) {
        currencySet = new CurrencySetLoader().load();
        exchangeCommand = new ExchangeCommand(currencySet);
        exchangeCommand.exec();
    }
}

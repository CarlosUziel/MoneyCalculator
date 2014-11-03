package App;

import Control.ExchangeCommand;
import Model.CurrencySet;
import View.Persistence.CurrencySetLoader;

public class Aplication {

    CurrencySet currencySet = new CurrencySetLoader().load();
    ExchangeCommand exchangeCommand = new ExchangeCommand(currencySet);
    exchangeCommand.exec();
}

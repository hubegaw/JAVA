package collections;

import model.entities.ICurrency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyDataCollection implements IDataCollection {
    protected List<ICurrency> currencies;

    public CurrencyDataCollection() {
        currencies = new ArrayList<>();
    }

    @Override
    public String ToString() {
        String currenciesList = "";
        for(ICurrency curr : currencies) {
            currenciesList += curr.getName() + ' ' + curr.getCode() + ' ' + curr.getRate() + ' ' + curr.getFactor() + "\n";
        }
        return currenciesList;
    }

    @Override
    public List<ICurrency> getCurrencyList() {
        return currencies;
    }

    @Override
    public ICurrency getCurrencyByCode(ICurrency currency) {
        for(ICurrency curr : currencies){
            if(currency.getCode().equals(curr.getCode()))
                return curr;
        }
        return null;
    }
}

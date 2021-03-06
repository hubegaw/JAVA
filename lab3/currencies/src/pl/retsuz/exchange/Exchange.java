package pl.retsuz.exchange;

import pl.retsuz.currency.ICurrency;

public class Exchange implements IExchange {
    @Override
    public double exchange(ICurrency src, ICurrency tgt, double amt) {
       return (amt * src.getRate())/ tgt.getRate();
    }
}

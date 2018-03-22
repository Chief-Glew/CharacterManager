package com.chiefglew.dndcharacter.application.items.currency;

import com.chiefglew.dndcharacter.application.GenericHandler;
import com.chiefglew.dndcharacter.exceptions.MissingCurrencyException;
import com.chiefglew.dndcharacter.exceptions.notEnoughFundsException;

import java.util.Arrays;
import java.util.List;

@Deprecated
public abstract class CurrencyStore extends GenericHandler<CurrencyStore>{
    private String symbol;
    private int divisor;
    private int amount;

    public CurrencyStore(String symbol, int divisor, int amount) {
        this.symbol = symbol;
        this.divisor = divisor;
        this.amount = amount;
    }

    public void withdraw(List<Currency> currencies) throws MissingCurrencyException, notEnoughFundsException {
        for (Currency currency : currencies){
            if (currency.getSymbol() == symbol){
                int requiredAmount = currency.getAmount();
                if (requiredAmount > amount){
                    int difference = (requiredAmount - amount);
                    int amountShort = difference/divisor;
                    if (difference%divisor != 0){
                        amountShort+=1;
                    }
                    handleNotEnoughFunds(amountShort);
                    amount+=amountShort*divisor;
                }
                amount-=requiredAmount;
                currencies.remove(currency);
            }
        }
        if (!currencies.isEmpty()){
            withdrawFromNext(currencies);
        }
    }

    protected abstract void handleNotEnoughFunds(int requiredAmount) throws MissingCurrencyException, notEnoughFundsException;


    protected void withdrawFromNext(List<Currency> currencies) throws MissingCurrencyException, notEnoughFundsException {
        if (!isNextNull()) {
            next.withdraw(currencies);
        }
        else{
            throw new MissingCurrencyException(currencies);
        }
    }

    protected void withdrawFromNext(Currency... currencies) throws MissingCurrencyException, notEnoughFundsException {
        withdrawFromNext(Arrays.asList(currencies));
    }

    public int getAmount() {
        return amount;
    }

    public String getSymbol() {
        return symbol;
    }

    public void deposit(Currency currency) throws MissingCurrencyException {
        if (currency.getSymbol() == symbol){
            amount+=currency.getAmount();
        }
        else{
            depositIntoNext(currency);
        }
    }

    private void depositIntoNext(Currency currency) throws MissingCurrencyException {
        if (!isNextNull()) {
            next.deposit(currency);
        }
        else{
            throw new MissingCurrencyException(currency);
        }
    }
}

package com.chiefglew.dndcharacter.exceptions;

public class notEnoughFundsException extends Throwable {
    public notEnoughFundsException() {
        super("The account is short by some some amount of money");
    }
}

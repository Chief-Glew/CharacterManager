package com.chiefglew.dndcharacter.exceptions;

public class notEnoughFundsException extends Throwable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public notEnoughFundsException() {
        super("The account is short by some some amount of money");
    }
}

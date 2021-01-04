package org.bank.service;

import java.util.Date;
import java.util.List;

import org.bank.Models.Operation;
import org.omg.SendingContext.RunTime;

public interface BankAccount{

/**
 * Deposit In my Account 
 * @param amount
 */
	public void deposit(float amount);
	/**
	 * withdraw In my Account 
	 * @param amount
	 */
	public void withdraw(float amount);
	/**
	 * Viewing all transcations on the account  
	 * @param time
	 * @return
	 */
	public List<Operation> getOperationsAfter(Date time);
	/**
	 * Viewing all transcations on the account
	 */
	public void getALLOperation();


}

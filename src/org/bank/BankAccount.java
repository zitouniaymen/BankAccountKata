package org.bank;

import java.util.Date;
import java.util.List;

import org.omg.SendingContext.RunTime;

public interface BankAccount{

/**
 * depot dans le compte 
 * @param amount
 */
	public void deposit(float amount);
	/**
	 * withdraw de la compte
	 * @param amount
	 */
	public void withdraw(float amount);
	/**
	 * Affichage de la liste des operations à partir d'une date donner  
	 * @param time
	 * @return
	 */
	public List<Operation> getOperationsAfter(Date time);
	/**
	 * Afffichage de toutes les opèrations dans le comptes 
	 */
	public void getALLOperation();


}

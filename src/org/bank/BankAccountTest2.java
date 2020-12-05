package org.bank;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.bank.Models.Operation;
import org.bank.Models.StandardBankAccount;

public class BankAccountTest2 {

	public static void main(String[] args) {

		StandardBankAccount first = new StandardBankAccount(new Date(), 1000, 1000);
		StandardBankAccount second = new StandardBankAccount(new Date(), 1650, 4000);
	
		
		/**
		 * faire un deposite sur le compte
		 */
		first.deposit(1000);
		/**
		 * faire un withdraw sur le compte
		 */
		first.withdraw(1000);

		first.deposit(2500);

		first.withdraw(1500);
		/**
		 * Affichage de toutes les operations sur le compte
		 */
		first.getALLOperation();

		/**
		 * Affichage de la liste des operations avec une date precise 
		 */
		ZoneId defaultZoneId = ZoneId.systemDefault();
		LocalDate localDate = LocalDate.of(2020, 12, 04);
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
		if (first.getOperationsAfter(date) != null) {
			for (Operation op : first.getOperationsAfter(date)) {
				System.out.println(op.getOperation() + " BALANCE " + op.getBalance() + " AMOUNT  " + op.getAmount()
						+ " DATE " + op.getDate());
			}
		}

	}

}

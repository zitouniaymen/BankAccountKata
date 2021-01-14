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
		 * Deposit In my Account
		 */
		first.deposit(1000);
		/**
		 * un withdraw In my Accounte
		 */
		first.withdraw(1000);

		first.deposit(2500);

		first.withdraw(1500);
		/**
		 *
Viewing all transcations on the account
		 */
		first.getALLOperation();

		/**
Display of the list of operations with a specific date
		 */
		ZoneId defaultZoneId = ZoneId.systemDefault();
		LocalDate localDate = LocalDate.of(2021, 01, 03);
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
		if (first.getOperationsAfter(date) != null) {
			for (Operation op : first.getOperationsAfter(date)) {
				
				System.out.println(op.getOperation()	+ " DATE " + op.getDate() + " AMOUNT  " + op.getAmount()
				+ " BALANCE " + op.getBalance());
		
			}
		}

	}

}

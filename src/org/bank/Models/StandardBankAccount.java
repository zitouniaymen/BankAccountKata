package org.bank.Models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.bank.service.BankAccount;
/**
 * 
 * @author Zitouni
 *
 */
public class StandardBankAccount implements BankAccount {
	/**
	 * Date of Deposit and Balance  In my Account
	 */
	private Date date;
	private float amount;
	private float balance;
	/**
	 * list of transactions  In My Comptes
	 */
	private List<Operation> theOperations = new ArrayList<Operation>();
	/**
	 * Transactions carried out on the account
	 */
	private Tache tache;

	public StandardBankAccount(Date date, float amount, float balance) {
		super();
		this.date = date;
		this.amount = amount;
		this.balance = balance;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public List<Operation> getTheOperations() {
		return theOperations;
	}

	public void setTheOperations(List<Operation> theOperations) {
		this.theOperations = theOperations;
	}
/**
 * make a Deposit In my Account
 */
	@Override
	public void deposit(float amount) {
		
		try {
			System.out.println(" Start Deposit In my Account ");
			float newBalance = balance + amount;
			balance = newBalance;
			Date date = Calendar.getInstance().getTime();
			Operation op = new Operation(Tache.DEPOSIT_COUNT.toString(), date, amount, balance);
			this.theOperations.add(op);
			System.out.println("Deposit In My Account: " + "AMOUNT " + amount + " BALANCE " + balance + " DATE " + date);

		} catch (Exception e) {
			
			e.getMessage();
		}finally {
			System.out.println("End Deposit In The Account");
		}

	}
/**
 *  see the history  of my operations with date
 *   I want to see the history (operation, date, amount, balance) with date 
 */
	@Override
	public List<Operation> getOperationsAfter(Date time) {
		System.out.println("Start of the list of operations from the date: "+time);
		List<Operation> result = new ArrayList<Operation>();
		for (Operation op : this.theOperations) {
			if (op.getDate().compareTo(time) >= 0) {
				result.add(op);

			}else
			{
				System.out.println(" No Operations In The Account For The:  "+time +" ");
				return null;
				
			}

		}
		return result;
	}
/**
 * make a withdrawal from my account
 */
	@Override
	public void withdraw(float amount) {
		
		try {
			System.out.println(" Start withdraw in the account ");
			float newBalance = balance - amount;
			balance = newBalance;
			Date date = Calendar.getInstance().getTime();
			this.theOperations.add(new Operation(Tache.WITHFRAWAL_COUNT.toString(), date, amount, balance));
			System.out.println("withdraw in the account: " + "AMOUNT " + amount + " BALANCE " + balance + " DATE " + date);
		} catch (Exception e) {
			e.getMessage();
		}finally {
			System.out.println(" End withdraw In The Account ");
		}

	}
/**
 *  see the history  of my operations
 */
	//I want to see the history (operation, date, amount, balance) 
	@Override
	public void getALLOperation() {
		System.out.println("The List of Operations On The Account: ");
		for (Operation op : this.getTheOperations()) {

			
			System.out.println(op.getOperation() + " DATE " + op.getDate() + " AMOUNT  " + op.getAmount()+ " BALANCE " + op.getBalance()
			);
		}
		
	}


}

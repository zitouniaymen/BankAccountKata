package org.bank;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/**
 * 
 * @author Zitouni
 *
 */
public class StandardBankAccount implements BankAccount {
	private Date date;
	private float amount;
	private float balance;
	private List<Operation> theOperations = new ArrayList<Operation>();
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
 * make a deposit in my account
 */
	@Override
	public void deposit(float amount) {
		
		try {
			System.out.println(" Debut deposit dans le compte ");
			float newBalance = balance + amount;
			balance = newBalance;
			Date date = Calendar.getInstance().getTime();
			Operation op = new Operation(Tache.DEPOSIT_COUNT.toString(), date, amount, balance);
			this.theOperations.add(op);
			System.out.println("deposit dans le compte  " + "AMOUNT " + amount + " BALANCE " + balance + " DATE " + date);

		} catch (Exception e) {
			
			e.getMessage();
		}finally {
			System.out.println(" fin deposit dans le compte ");
		}

	}
/**
 *  see the history  of my operations with date
 */
	@Override
	public List<Operation> getOperationsAfter(Date time) {
		System.out.println(" Debut de la  liste des operation à partir de la date "+time);
		List<Operation> result = new ArrayList<Operation>();
		for (Operation op : this.theOperations) {
			if (op.getDate().compareTo(time) >= 0) {
				result.add(op);

			}else
			{
				System.out.println(" il n'a pas d'pèrations dans le compte pour la  "+time +" ");
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
			System.out.println(" Debut withdraw dans le compte ");
			float newBalance = balance - amount;
			balance = newBalance;
			Date date = Calendar.getInstance().getTime();
			this.theOperations.add(new Operation(Tache.WITHFRAWAL.toString(), date, amount, balance));
			System.out.println("withdraw dans le compte " + "AMOUNT " + amount + " BALANCE " + balance + " DATE " + date);
		} catch (Exception e) {
			e.getMessage();
		}finally {
			System.out.println(" fin withdraw dans le compte ");
		}

	}
/**
 *  see the history  of my operations
 */
	@Override
	public void getALLOperation() {
		System.out.println("La liste des operations sue le compte ");
		for (Operation op : this.getTheOperations()) {
			System.out.println(op.getOperation() + " BALANCE " + op.getBalance() + " AMOUNT  " + op.getAmount()
					+ " DATE " + op.getDate());
		}
		
	}


}

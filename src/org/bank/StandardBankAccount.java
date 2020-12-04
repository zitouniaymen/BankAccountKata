package org.bank;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StandardBankAccount implements BankAccount {
	private Date date;
	private float amount;
	private float balance;
	private List<Operation> theOperations = new ArrayList<Operation>();

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

	@Override
	public void deposit(float amount) {
		
		try {
			System.out.println(" Debut deposit dans le compte ");
			float newBalance = balance + amount;
			balance = newBalance;
			Date date = Calendar.getInstance().getTime();
			Operation op = new Operation();
			op.setOperation("deposit");
			op.setDate(date);
			op.setBalance(balance);
			op.setAmount(amount);
			this.theOperations.add(op);
			System.out.println("deposit dans le compte  " + "AMOUNT " + amount + " BALANCE " + balance + " DATE " + date);

		} catch (Exception e) {
			e.getMessage();
		}finally {
			System.out.println(" fin deposit dans le compte ");
		}

	}

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

	@Override
	public void withdraw(float amount) {
		
		try {
			System.out.println(" Debut withdraw dans le compte ");
			float newBalance = balance - amount;
			balance = newBalance;
			Date date = Calendar.getInstance().getTime();
			this.theOperations.add(new Operation("withdraw", date, amount, balance));
			System.out.println("withdraw dans le compte " + "AMOUNT " + amount + " BALANCE " + balance + " DATE " + date);
		} catch (Exception e) {
			e.getMessage();
		}finally {
			System.out.println(" fin withdraw dans le compte ");
		}

	}

	@Override
	public void getALLOperation() {
		System.out.println("La liste des operations sue le compte ");
		for (Operation op : this.getTheOperations()) {
			System.out.println(op.getOperation() + " BALANCE " + op.getBalance() + " AMOUNT  " + op.getAmount()
					+ " DATE " + op.getDate());
		}
		
	}


}

package org.bank;

import java.util.Date;
/**
 * 
 * @author Zitouni
 *Declaration de la class Operation 
 */
public class Operation {

	private String operation;
	private Date date;
	private float amount;
	private float balance;
	public Operation(String operation, Date date, float amount, float balance) {
		super();
		this.operation = operation;
		this.date = date;
		this.amount = amount;
		this.balance = balance;
	}
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
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
	
	
}

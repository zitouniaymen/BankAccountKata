package org.bank;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.jupiter.api.Test;

class StandardBankTest {


	StandardBankAccount first = new StandardBankAccount(new Date(), 1000, 1000); 
	StandardBankAccount second = new StandardBankAccount(new Date(), 1000, 1000);  
	List<Operation> theOperationstest= new ArrayList<Operation>();
	ZoneId defaultZoneId = ZoneId.systemDefault();
	LocalDate localDate = LocalDate.of(2020, 12, 04);
	Date dateTest = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
	
	 private static boolean isNotMatch(List<Operation> clist1, List<Operation> clist2) {
	        return clist1.size() != clist2.size() || !clist1.equals(clist2);
	      }
	 /**
	  * Test make a deposit in my account
	  */
	@Test
	void deposittest() {
		first.deposit(1000);
		assertTrue(first.getBalance()== 2000);
}
/**
 * Test  make a withdrawal from my account
 */
	@Test
	void withdrawtest() {
		first.withdraw(1000);
		assertTrue(first.getBalance()== 0);
	}
	/**
	 * see the history with date
	 */
	@Test
	public void getOperationsAfterTest() 
	{
	    Date date = Calendar.getInstance().getTime();

	Operation op=	new Operation("deposit",date,1000,2000);
	Operation op1=	new Operation("withdraw",date,1000,1000);
	theOperationstest.add(op);
	theOperationstest.add(op1);
boolean rest=isNotMatch(theOperationstest, first.getOperationsAfter(dateTest));
	assertTrue(rest== true);
	}
	/**
	 * see the ALL history 
	 */
	@Test
	void getALLOperationtest() {
		
	    Date date = Calendar.getInstance().getTime();

	Operation op=	new Operation("deposit",date,1000,2000);
	Operation op1=	new Operation("withdraw",date,1000,1000);
	theOperationstest.add(op);
	theOperationstest.add(op1);
boolean rest=isNotMatch(theOperationstest, first.getTheOperations());
	assertTrue(rest== true);


	

}
	   @After
	    public void finalize() {
	     
		   theOperationstest.clear();
	    }
	
}

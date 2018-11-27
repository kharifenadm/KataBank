package kadoum.katabankKadoum;

import java.math.BigDecimal;

import org.junit.*;
import junit.framework.TestCase;

public class KataBankAccountTest extends TestCase{
	
	/**
	 * In order to save money
		As a bank client
		I want to make a deposit in my account
	 */
	
	@Test
	public void testIsClientLambdaWithAccount() throws Exception {
		AccountImpl account = new AccountImpl (1,"bankA",new BigDecimal(5000));		
		ClientImpl cl = new ClientImpl("lambda",account);		
		Assert.assertTrue(cl.getAccount()!=null);		
	}
	
	@Test
	public void testClientLambdaDeposits50IntoAccount1() throws Exception {
		AccountImpl account = new AccountImpl (1, "bankA",new BigDecimal(5000));		
		ClientImpl cl = new ClientImpl("lambda",account);		
	
		cl.deposit(new BigDecimal(50));
		Assert.assertTrue(cl.getAccount().getSavings().doubleValue()==5050.0);
		
		
	}
	
	
	/**
	 * US 2:
	In order to retrieve some or all of my savings
	As a bank client
	I want to make a withdrawal from my account
	 */
	
	@Test
	public void testClientLambdaWithdraws50fromAccount1() throws Exception {
		AccountImpl account = new AccountImpl (1, "bankA",new BigDecimal(5000));		
		ClientImpl cl = new ClientImpl("lambda",account);	
		
		cl.withdrawal(new BigDecimal(50));
		Assert.assertTrue(cl.getAccount().getSavings().doubleValue()==4950.0);	
	}
	
	@Test
	public void testClientLambdaWithdrawsAllfromAccount1() throws Exception {
		AccountImpl account = new AccountImpl (1, "bankA",new BigDecimal(5000));		
		ClientImpl cl = new ClientImpl("lambda",account);	
		
		cl.withdrawal(new BigDecimal(5000));
		Assert.assertTrue(cl.getAccount().getSavings().doubleValue()==0.0);	
	}
	
	@Test
	public void testClientLambdaWithdrawsMoreThanSavingsfromAccount1() throws Exception {
		AccountImpl account = new AccountImpl (1, "bankA",new BigDecimal(5000));		
		ClientImpl cl = new ClientImpl("lambda",account);	
		
		cl.withdrawal(new BigDecimal(6000));
		Assert.assertTrue(cl.getAccount().getSavings().doubleValue()==-1000.0);	
	}
	
	/**
	 * In order to check my operations
	As a bank client
	I want to see the history (operation, date, amount, balance) of my operations
	 */
	@Test
	public void testClientLambdaChecksHistoricForAccount1() throws Exception {
		
		
		AccountImpl account = new AccountImpl (1, "bankA",new BigDecimal(5000));		
		ClientImpl cl = new ClientImpl("lambda",account);	
		
		cl.withdrawal(new BigDecimal(25));	
		cl.withdrawal(new BigDecimal(50));
		cl.deposit(new BigDecimal(50));
		
		Assert.assertTrue(account.getOperationLst().get(0).getAmount().doubleValue()==25.0);
		Assert.assertTrue(account.getOperationLst().get(0).getBalance().doubleValue()==4975.0);
		
		Assert.assertTrue(account.getOperationLst().get(1).getAmount().doubleValue()==50.0);
		Assert.assertTrue(account.getOperationLst().get(1).getBalance().doubleValue()==4925.0);		
		
		Assert.assertTrue(account.getOperationLst().get(2).getAmount().doubleValue()==50.0);
		Assert.assertTrue(account.getOperationLst().get(2).getBalance().doubleValue()==4975.0);

	}

}

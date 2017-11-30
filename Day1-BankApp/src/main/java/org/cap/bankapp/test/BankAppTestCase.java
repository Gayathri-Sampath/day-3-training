package org.cap.bankapp.test;

import static org.junit.Assert.*;

import org.cap.dao.AccountDao;
import org.cap.dto.Account;
import org.cap.dto.Address;
import org.cap.dto.Customer;
import org.cap.exception.InsufficientBalanceException;
import org.cap.exception.InvalidInitialAmountException;
import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BankAppTestCase {
	private AcccountService accountService;
	@Mock
	private AccountDao accountDao;
	
	@Before 
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		accountService=new AccountServiceImpl(accountDao);
	}
@After
public void tearDown()
{
	accountService=new AccountServiceImpl();
}
	@Test
	public void test_addnumbers() {
		// accountService=new AccountServiceImpl();
		 assertEquals(50,accountService.addNumbers(30,20));

		fail("Not yet implemented");
	}
	public void test_when_customer_is_null() throws InvalidInitialAmountException
	{
		//accountService= new AccountServiceImpl();
		Customer customer=null;
		accountService.addAccount(customer, 1000);
	
	}
	
	public void test_with_invalid_initial_amount()
	{
		//accountService= new AccountServiceImpl();
		Customer customer=new Customer();
		customer.setCustName("gayathri");
		Address addr=new Address();
		addr.setAddressLine("Vellore");
		customer.setCustAddress(addr);
		
	}
	@Test
	public void test_addAccount_with_valid_customer() throws InvalidInitialAmountException
	{
		Customer customer=new Customer();
		customer.setCustName("gayathri");
		Account account=new Account();
		account.setCustomer(customer);
		account.setAmount(1500);
		//decl
		Mockito.when(accountDao.createAccount(account)).thenReturn(true);
		//actual
		Account new_account=accountService.addAccount(customer, 1500);
		//verification
		Mockito.verify(accountDao).createAccount(account);
		assertEquals(1500,new_account.getAmount(),0.0);
		
	}
	@Test
	public void test_with_withdraw_amount() throws InsufficientBalanceException
	{
		Customer customer=new Customer();
		customer.setCustName("gayathri");
		Account account=new Account();
		account.setAccountNo(111);
		account.setAmount(1500);
		Mockito.when(accountDao.findAccountById(111)).thenReturn(account);
		accountService.withdraw(111, 1300);
		//Account new_account=accountService.withdraw(111, 1300);
		Mockito.verify(accountDao).findAccountById(111);
		Account updatedAccount=accountService.withdraw(111, 1300);
		assertEquals(200, updatedAccount.getAmount(),0.0);
		//assertEquals("gayathri",updatedAccount.get
		
	}

}

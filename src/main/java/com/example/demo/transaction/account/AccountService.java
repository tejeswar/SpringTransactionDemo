package com.example.demo.transaction.account;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
//@Transactional(rollbackFor = Exception.class)
//@EnableTransactionManagement
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
//	@Autowired
//	DataSource ds;
	
	public void saveAccount(BankAccount account) {
		accountRepository.save(account);
		System.out.println("Account got saved successfully... ");
	}
	
	public void insertDummyAccounts() {
		BankAccount acc1 = new BankAccount("Tapnesh",5000);
		BankAccount acc2 = new BankAccount("Satya",4000);
		BankAccount acc3 = new BankAccount("Teju",3000);
		//BankAccount acc4 = new BankAccount("",);
		List<BankAccount> listOfAccounts = new ArrayList<BankAccount>();
		listOfAccounts.add(acc1);
		listOfAccounts.add(acc2);
		listOfAccounts.add(acc3);
		
		accountRepository.saveAll(listOfAccounts);
		System.out.println("All accounts got inserted successfully....");
		
	}
	
	
	
	
	//@Transactional
	
	public void tranferAmount(BankAccount srcAccount,BankAccount targetAccount,double amount) throws Exception {
		
		//try {
		//test();
		
		addAmount(srcAccount,-amount);
		//throwRuntimeException();
		throwCheckedException();
		addAmount(targetAccount,amount);
//		
		System.out.println("Transaction got successful.....");
	}
	public void addAmount(BankAccount srcAccount, double amount) {
		Optional<BankAccount> optionalSrcAccount = accountRepository.findById(srcAccount.getId());
		BankAccount srcBankAccount = optionalSrcAccount.get();
		srcBankAccount.setBalance(srcBankAccount.getBalance()+amount);
		accountRepository.save(srcBankAccount);		
		System.out.println("Amount got updated successfully...");
		
	}

	public void test() {
		System.out.println("is trn here enabled?--- "+TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Endo f test mehodd");
		
	}

	
	@Transactional(rollbackFor = Exception.class)
	//@Transactional()
	public void makeTransaction(BankAccount srcAccount, BankAccount targetAccount, long transferAmount) throws Exception {
	//public void makeTransaction(BankAccount srcAccount, BankAccount targetAccount, long transferAmount){
		System.out.println("is trn--- "+TransactionSynchronizationManager.isActualTransactionActive());
		try {
		tranferAmount(srcAccount,targetAccount,transferAmount);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new RuntimeException("Runtime exception happened...");
			throw new Exception("Explicitely rethrowing runtime exceptions... ");
		}
		
		System.out.println("Transaction got successfully...");
		
		
	}
	
	public void throwRuntimeException(){
		throw new RuntimeException("something bad happend...");
	}
	
	public void throwCheckedException() throws Exception {
		throw new Exception("Explicitely throwing checked exception...");
	}

	public void directCallMethod() {
		System.out.println("get method here enabled?--- "+TransactionSynchronizationManager.isActualTransactionActive());
		callPrivateMethod1();
		System.out.println("Inside direct call method...");
		
	}
    @Transactional
	private void callPrivateMethod1() {
		System.out.println("private method txn enabled?--- "+TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("End of private method call");
		
	}
	
	
	
}

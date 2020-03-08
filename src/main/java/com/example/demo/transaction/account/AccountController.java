package com.example.demo.transaction.account;


/*
 * The transaction has to start from the root method of the service class ...otherwise it will not work.
 */

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
public class AccountController {

	 @Autowired
	 private AccountService accountService;
	 @Autowired
	 private AccountRepository accountRepository;
	 
	 
	 public void insertDummyAccounts() {
		 accountService.insertDummyAccounts();
	 }
	 
    public void makeDummyTransaction(){
    	
    BankAccount srcAccount = 	getSrcAccount();
    BankAccount targetAccount = 	getTargetAccount();
	System.out.println("Source Account : "+srcAccount);	
	System.out.println("Target Account : "+targetAccount);
	long transferAmount = 777;
	try {
		accountService.makeTransaction(srcAccount,targetAccount,transferAmount);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//accountService.tranferAmount(srcAccount,targetAccount,transferAmount);
	
	}
    
	private BankAccount getTargetAccount() {
		Optional<BankAccount> optionalSrcAcc = accountRepository.findById((long) 3);
		BankAccount bankAccount = optionalSrcAcc.get();
		
		return bankAccount;
	}

	private BankAccount getSrcAccount() {
		Optional<BankAccount> optionalTargetAcc = accountRepository.findById((long) 1);
		BankAccount bankAccount = optionalTargetAcc.get();
		return bankAccount;
	}
	
}

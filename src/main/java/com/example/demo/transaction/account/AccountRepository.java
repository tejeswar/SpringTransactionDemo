package com.example.demo.transaction.account;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



public interface AccountRepository extends CrudRepository<BankAccount, Long>{

}


package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.transaction.account.AccountController;
import com.example.demo.transaction.account.AccountService;


@SpringBootApplication
@EnableJpaRepositories
public class SpringTransactionDemoApplication implements CommandLineRunner{

	@Autowired
    private AccountController accountController;
	
	@Autowired
    private AccountService accountService;
	

    private static final Logger log = LoggerFactory.getLogger(SpringTransactionDemoApplication.class);
	
	public static void main(String[] args) {
        SpringApplication.run(SpringTransactionDemoApplication.class, args);
        System.out.println("End of StartApplicationTransaction-main appl..");
    }
	 @Override
	    public void run(String... args) {

	        log.info("Starting the StartApplicationTransaction Application...");
	        //accountController.insertDummyAccounts();
	        accountController.makeDummyTransaction();
	       // accountService.directCallMethod();
}
}

/*
CREATE TABLE `bank_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `balance` double NOT NULL,
  `full_name` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


INSERT INTO `transaction`.`bank_account` (`id`, `balance`, `full_name`) VALUES ('4', '2000', 'soumya');

*/
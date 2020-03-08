this project I had created to learn the transaction in spring


https://o7planning.org/en/11661/spring-boot-jpa-and-spring-transaction-tutorial.   = with UI transfer account




https://www.youtube.com/watch?v=4BD6pF7dkkc. == h2 in memory configuration with transaction.
Spring Transaction Management: Finally Understandable | Spring Core - Masterclass
https://www.youtube.com/watch?v=hBO44wKy2zQ = simple GitHub application = Declarative Transaction Management with Spring Boot
https://www.youtube.com/watch?v=hskHMSlvm6U = Spring & CGLIB: Finally Understandable | Spring Core - Masterclass



https://www.marcobehler.com/guides/spring-transaction-management-transactional-in-depth#_how_spring_and_jpa_hibernate_transaction_management_works




https://dzone.com/articles/7-things-to-know-getting-started-with-spring-boot

https://netsurfingzone.com/spring/transactional-rollbackfor-example-using-spring-boot/
https://dzone.com/articles/spring-boot-transactions-tutorial-understanding-tr.   = interesting

https://dzone.com/articles/spring-boot-transaction-management-hello-world-exa.  =. employee and healthorg
https://www.logicbig.com/tutorials/spring-framework/spring-data-access-with-jdbc/transactional-roll-back.html. = orders





https://dzone.com/articles/magic-around-spring-boot-auto-configuration 
System.out.println("is trn--- "+TransactionSynchronizationManager.isActualTransactionActive());








For this to complete,it requires in depth knowledge of environment of kubernetes.Also it requires some security related setting  in kubernetes.As we are able to deploy other microservice components in kubernetes we can close it so that we can move forward in other topics…













On which method you should put the @Transactional annotation?

Ans : We have to put the @Transactional on the root method which is getting called from the controller layer.
         The method has to be public only.
         The transaction will Get rolled back for only Runtimeexception .If you want ur transaction to get rolled back for checked exception then you have to
         Specifically mention it on ur code.

How exception handling and @Transactional annotation affect each other ?

Ans : The Method on which we have put transactional annotation must throw or rethrow exception in order to make transaction annotation work as expected.
          If we simply shallow the exception 



Let us first understand the difference between the mvn package and install ? 



























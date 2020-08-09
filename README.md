# AutomationPractice
Selenium +TestNG code for automationpractice website

The Automation Practice folder structure is as follows :<br>
=====src/main/java==========<br>
com.yourlogo._base<br>
--Setup.java<br>          (This java file contains the setup for a selenium test - webdriver setup, testData setup, log4j setup etc)
  
com.yourlogo.modules<br>
--Registration.java      (This java file contains steps to register a fresh email id)<br>
--Login.java              (This java file contains steps to login into application)<br>
--BuyProduct.java         (This java file contains steps to buy a product and verify the order details)<br>

com.yourlogo.testdata<br>
--TestData.java          (This java file extracts data from Excel and it copies to a HashMap for use.)<br>
--TestDataYourLogo.xlsx  (This excel file contains all the data used for Registration and Login)<br>

com.yourlogo.utilities
--Utility.java           (This java file contains method to take screenshot of inframe and full page and save it to screenshots package)

======src/test/java==========<br>
com.yourlogo.screenshots<br>
(Contains all screenshots of the testing done on modules)<br>

com.yourlogo.test<br>
--Test_Registration.java   (This Java file contains TestNG annotations with tests with validation for fields on Registration page.<br>
--Test_Login.java         (This Java file contains TestNG annotations with tests with validation for fields on Login page)<br>
--Test_BuyProduct.java    (This Java file contains TestNG annotations with tests test to buy product by either BankWire or Cheque<br>

======src/test/resources==========<br>
Contains log4j2.properties 

================================<br>
(These aare TestNG XML files for TestNG java files of same name)<br>
--Test_Registration.xml <br>
--Test_Login.xml<br>
--Test_BuyProduct.xml<br>

# AutomationPractice
Selenium +TestNG code for automationpractice website

The Automation Practice folder structure is as follows :<br>
=====src/main/java==========<br>
com.yourlogo._base   (This package contains the basic setup)<br>
--Setup.java<br>
  
com.yourlogo.accountcreation<br>
--Registration.java      (This java file contains steps to register a fresh email id)<br>
    
com.yourlogo.buyproduct<br>
--BuyProduct.java         (This java file contains steps to login, buy a product, verify the order details)<br>

com.yourlogo.testdata<br>
--TestData.java          (This java file extracts data from Excel and it copies to a HashMap for use.)<br>
--TestDataYourLogo.xlsx  (This excel file contains all the data used for Registration and Login)<br>
    
======src/main/test==========<br>
com.yourlogo.test<br>
--Test_Registration.java   (This Java file contains TestNG annotations with tests with validation for fields on Registration page.<br>
--Test_Login.java         (This Java file contains TestNG annotations with tests with validation for fields on Login page)<br>
--Test_BuyProduct.java    (This Java file contains TestNG annotations with tests test to buy product by either BankWire or Cheque<br>

================================<br>
(These aare TestNG XML files for TestNG java files of same name)<br>
--Test_Registration.xml <br>
--Test_Login.xml<br>
--Test_BuyProduct.xml<br>

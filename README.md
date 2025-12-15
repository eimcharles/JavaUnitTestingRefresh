### Java Unit Testing, Test Driven Development refresher and learning ressource.

#### This repository serves as a refresh on core Java unit testing principles and a learning ressource for AssertJ and Mockito libraries.

![AssertJ](https://img.shields.io/badge/Assertions-AssertJ-FFD166?logo=assertj&logoColor=black)
![Mockito](https://img.shields.io/badge/Mocking-Mockito-FFD166?logo=jest&logoColor=black)

--- 

#### Test Driven Development

##### TDD Cycle (repeated for every piece of functionality): 
- **Red**: Write a failing test.
- **Green**: Write just enough code to make the test pass.
- **Refactor**: Clean up code with the safety of passing the test.
  
--- 
#### Example Classes and Unit Test Classes using AssertJ:
| Class Name                                                                                                     | Unit Test Class       | 
|----------------------------------------------------------------------------------------------------------------|-----------------------|
| [Booking.java](src/main/java/org/eimc/booking/Booking.java)                                                    | [BookingTest.java](src/test/java/org/eimc/booking/BookingTest.java)|
| [Car.java](src/main/java/org/eimc/car/Car.java)                                                                | [CarTest.java](src/test/java/org/eimc/car/CarTest.java)|
| [User.java](src/main/java/org/eimc/user/User.java)                                                             | [UserTest.java](src/test/java/org/eimc/user/UserTest.java)| 
| [ArrayBookingDAO.java](src/main/java/org/eimc/booking/dao/ArrayBookingDAO.java)                                    | [ArrayBookingDAOTest.java](src/test/java/org/eimc/booking/ArrayBookingDAOTest.java)| 
| [ArrayCarDAO.java](src/main/java/org/eimc/car/dao/ArrayCarDAO.java)                                                | [ArrayCarDAOTest.java](src/test/java/org/eimc/car/ArrayCarDAOTest.java)| 
| [ArrayUserDAO.java](src/main/java/org/eimc/user/dao/ArrayUserDAO.java)                                             | [ArrayUserDAOTest.java](src/test/java/org/eimc/user/ArrayUserDAOTest.java)| 
| [EmailValidator.java](src/main/java/org/eimc/emailValidator/EmailValidator.java)                               | [EmailValidatorTest.java](src/test/java/org/eimc/emailValidator/EmailValidatorTest.java)|
| [PasswordValidator.java](src/main/java/org/eimc/passwordValidator/PasswordValidator.java)                      | [PasswordValidatorTest.java](src/test/java/org/eimc/passwordValidator/PasswordValidatorTest.java)| 
| [ShippingCostCalulator.java](src/main/java/org/eimc/shippingCostCalculator/ShippingCostCalculator.java)        | [ShippingCostCalulatorTest.java](src/test/java/org/eimc/shippingCostCalculator/ShippingCostCalculatorTest.java)|

--- 
#### Examples Results of Unit Test using AssertJ:
<img width="1212" height="751" alt="Screenshot 2025-12-15 at 6 00 48 PM" src="https://github.com/user-attachments/assets/fc9c4495-ca6f-479d-a0e0-70401ff73c9b" />

--- 
  

# Polymorphism Payment Lab

## Objectives

- To learn [interface](https://docs.oracle.com/javase/tutorial/java/concepts/interface.html)
- To learn `Comparable` interface
- To learn [lambda function](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)

# Section 1 - Setting up the classes
## Part 1 - Payment
1. Create a `Payment` interface
  - The class should define a `getId()` method which returns a Long
  - The class should define a `getPayerName()` method which returns a String
  - The class should define a `getShortDescription` method which returns a String

## Part 2 - Credit Card
1. Create a `CreditCardTest` test class
2. Create a `CreditCard` class which implements the `Payment` interface
3. Add the required methods from the interface
4. Add getter and setter test for an id
  - Add a Long id field
  - Add a getter and setter method to make the test pass
5. Repeat step 4 for the following fields:
  - String payerName
  - String number
  - int expiredMonth
  - int expiredYear
6. Implement the `getShortDescription` to return `CC [payerName] [last 4 digit of the number] [expiredMonth]/[expiredYear]`
  - ex: `CC Tia Mowry 4551 10/2019`
7. You may create any type of constructor or methods that will with this lab

## Part 3 - Check
1. Create a `CheckTest` test class
2. Create a `Check` class which implements the `Payment` interface
3. Add the required methods from the interface
4. Add getter and setter test for an id
  - Add a Long id field
  - Add a getter and setter method to make the test pass
5. Repeat step 4 for the following fields:
  - String payerName
  - String routing number
  - String accountNumber
6. Implement the `getShortDescription` to return `Check [payerName] ***[last 4 digit of the account]`
  - ex: `Check Tia Mowry ***4551`
7. You may create any type of constructor or methods that will with this lab

## Part 4 - Paypal
1. Create a `PayPalTest` test class
2. Create a `PayPal` class which implements the `Payment` interface
3. Add the required methods from the interface
4. Add getter and setter test for an id
  - Add a Long id field
  - Add a getter and setter method to make the test pass
5. Repeat step 4 for the following fields:
  - String payerName
  - String email
6. Implement the `getShortDescription` to return `Paypal [payerName] [email]`
  - ex: `Paypal Tia Mowry tia@mowry.com`
7. You may create any type of constructor or methods that will with this lab

# Section 2 - Comparable
Note: You may use the String/Long compareTo methods in your code
1. Edit the `Payment` class to extends the Comparable interface
  - `public interface Payment extends Comparable<Payment>`
  - This indicate that payment can be comparable, which means it can be sorted
2. Fix the syntax error in your CreditCard, Check, and Paypal class by adding the compare method
3. Create a test for the `compareTo` method. Compare using the getShortDescription()
  - Example: Given Payment of type Paypal with the short description of `Paypal Tia Mowry tia@mowry.com` and a Check with the short description of `Check Tia Mowry ***4551`, then the `compareTo` method should return a number larger than 0
  - The `compareTo` method will return number larger than 0 if this payment comes after payment2
  - The `compareTo` method will return number 0 if this payment has the same information
  - The `compareTo` method will return number less than 0 if this payment comes before payment2
4. Add the code necessary to make the test pass
5. Create a new `PaymentSortByPayer` class which implements `java.util.Comparator`
  - This class will sort by payer name
  - `public class PaymentSortByPayer implements Comparator<Payment>`
6. Add the required `compare` method from the Comparator
7. Create a test to compare two payment
    - The `compare` method will return number larger than 0 if payment1 comes after payment2
    - The `compare` method will return number 0 if the payment has the same information
    - The `compare` method will return number less than 0 if payment1 comes before payment2

# Section 3 - PaymentPresenter
1. Create a `PaymentPresenterTest`
2. Create a test case to test the `toString` method of the PaymentPresenter class
  - When there is no payment
    
    ```
      Payment[] payments = new Payment[0];
      PaymentPresenter presenter = new PaymentPresenter();
      String expected = "";

      String actual = presenter.toString(payments);

      assertEquals(expected, actual);
    ```
    
  - When there are multiple payments, you need to sort it first, then build the string using the short description
    
  ```
    Payment[] payments = new Payment[2];
    Payment paypal = new PayPayl(4L, "Tia Mowry", "tia@mowry.com");
    Payment check = new Check(81L, "Tia Mowry", "11432543", "134344551")

    payment[0] = paypal;
    payment[1] = check;
    
    PaymentPresenter presenter = new PaymentPresenter();
    String expected = "Check Tia Mowry ***4551\nPaypal Tia Mowry tia@mowry.com\n";

    String actual = presenter.toString(payments);
    assertEquals(expected, actual);
  ```
    
  3. Create a test case to test the `toStringByPayerName` method of the PaymentPresenter class
    - When there are multiple payments, you need to sort by calling the `PaymentSortByPayer` class to sort, then build the string using the short description

    ```
      Payment[] payments = new Payment[2];
      Payment paypal = new PayPayl(4L, "Tamara Mowry", "tamara@mowry.com");
      Payment check = new Check(81L, "Tia Mowry", "11432543", "134344551")

      payment[0] = paypal;
      payment[1] = check;

      PaymentPresenter presenter = new PaymentPresenter();
      String expected = "Paypal Tamara Mowry tamara@mowry.com\nCheck Tia Mowry ***4551\n";

      String actual = presenter.toStringByPayerName(payments);
      assertEquals(expected, actual);
    ```
    
  4. Create a test case to test the `toStringById` method of the PaymentPresenter class
    - When there are multiple payments, you need to sort by creating a lambda to sort the payment by id, then build the string using the short description

    ```
      Payment[] payments = new Payment[2];
      Payment paypal = new PayPayl(120L, "Tamara Mowry", "tamara@mowry.com");
      Payment check = new Check(81L, "Tia Mowry", "11432543", "134344551")

      payment[0] = paypal;
      payment[1] = check;

      PaymentPresenter presenter = new PaymentPresenter();
      String expected = "Paypal Tamara Mowry tamara@mowry.com\nCheck Tia Mowry ***4551\n";

      String actual = presenter.toStringById(payments);
      assertEquals(expected, actual);
    ```

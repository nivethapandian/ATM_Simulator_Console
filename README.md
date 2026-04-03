# Console-Based ATM Simulator

A robust, console-based ATM simulator built in Java. This project demonstrates core Object-Oriented Programming (OOP) principles and rigorous exception handling by simulating a real-world banking interface.

## Features

This is a modular implementation.

* **Secure Login System:** Requires account number and PIN authentication. Accounts lock after 3 consecutive failed attempts.
* **Balance Enquiry:** Users can check their current account balance at any time.
* **Cash Deposit:** Allows users to deposit funds into their account securely.
* **Cash Withdrawal:** Allows users to withdraw funds, strictly enforcing balance limits.
* **Transaction History:** Maintains and displays a chronological list of all deposits and withdrawals during the session.

## Technologies Used

* **Language:** Java (JDK 8+)
* **Environment:** Console / Terminal

## Table Of Contents
1. [Excepiton Handling](#exception-handling)
2. [Run](#run)
3. [Test Credentials](#test-credentials)
4. [Project Structure](#project-structure)

## Exception Handling

This project emphasizes defensive programming and custom error handling. The following scenarios are explicitly managed:

| Scenario | Exception Handled | Type |
| :--- | :--- | :--- |
| User enters letters instead of numbers | `NumberFormatException` | Built-in |
| Withdrawal exceeds available balance | `InsufficientFundsException` | **Custom** |
| Depositing/Withdrawing negative amounts | `InvalidAmountException` | **Custom** |
| Wrong PIN entered 3 times | `AccountLockedException` | **Custom** |

## Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/nivethapandian/ATM_Simulator_Console.git
   ```
2. **Navigate to the directory:**
   ```bash
   cd atm_simulator
   ```
3. **Run in an IDE or Terminal**

   **If terminal:**
   
   3.1 **Compile the Java file:**
       ```bash
       javac ATMSimulator.java
       ```
   
   3.2 **Run the application**
       ```bash
       java ATMSimulator
       ```
   
## Test Credentials

To log in and test the system, use the following hardcoded credentials:

 - **Account Number:** 123456
 - **PIN:**  8910

## Project Structure

 - **ATMSimulator:** The main driver class that handles the console UI, user inputs, and menu loops.

 - **BankAccount:** Handles state (balance, PIN, transaction history) and core logic (deposit, withdraw).

 - **Custom Exceptions:** InsufficientFundsException, InvalidAmountException, and AccountLockedException are defined to handle specific invalid states.

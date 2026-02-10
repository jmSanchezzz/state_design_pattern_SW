## Seatwork 2: State Design Pattern (Bank Account)

### Problem Description

A bank needs to manage different states of customer accounts, including **active**, **suspended**, and **closed**. Each state has specific rules and restrictions regarding allowed operations, and accounts have associated attributes like **account number** and **balance**.

- **Active accounts**: Allow deposits and withdrawals.
- **Suspended accounts**: Disallow deposit and withdrawal transactions, but allow viewing account information.
- **Closed accounts**: Disallow all transactions and viewing of account information.

Currently, the system relies on conditional statements within the `Account` class to check the account state and determine valid actions. This approach becomes cumbersome and error-prone as the number of states and their associated logic grows.

### Goal

Implement the **State** design pattern to improve code maintainability and flexibility.

### Requirements

1. **Define Account States**  
	Create separate classes representing different account states: `ActiveState`, `SuspendedState`, and `ClosedState`.

2. **Implement State Interface**  
	Define an interface `AccountState` with methods for common actions like `deposit`, `withdraw`, `activate`, `suspend`, and `close`.

3. **Implement State Behaviors**  
	Each concrete state class implements the `AccountState` interface, providing specific behavior for its respective state. For example:
	- `ActiveState` allows deposits and withdrawals.
	- `SuspendedState` disallows deposits and withdrawals.
	- `ClosedState` disallows all transactions.

4. **Update Account Class**
	- Include attributes for `accountNumber` and `balance`.
	- Remove state-specific logic from the `Account` class.
	- Introduce a reference to the current `AccountState` object.
	- Delegate actions like `deposit`, `withdraw`, `activate`, `suspend`, and `close` to the current state object through its corresponding methods.

### Logic

- If the account is **active**: you can either suspend it or close it.
- If the account is **suspended**: you can either activate or close it. No deposits and withdrawals allowed.
- If the account is **closed**: you can neither suspend nor activate it. No deposits and withdrawals allowed.

### Composition of `Account`

- `accountNumber: String`
- `balance: Double`
- `accountState: AccountState`

**Methods:**

- `deposit(Double depositAmount): void`
- `withdraw(Double withdrawAmount): void`
- `suspend(): void`
- `activate(): void`
- `close(): void`
- `toString()` – displays account number and balance

> **Note:** No `if-else` or `switch` will be used for state decisions. All behavior differences must be handled through the state classes.

### Test Class: `AccountTest`

```java
public class AccountTest(){
	 public static void main (String[] args){

		  Account myAccount = new Account("1234", 10000.0); // set acct to active state
		  myAccount.activate(); // displays "Account is already activated!"

		  // Suspend the account
		  myAccount.suspend(); // displays "Account is suspended!"

		  // Activate the account
		  myAccount.activate(); // displays "Account is activated!"

		  // Deposit to the account
		  myAccount.deposit(1000.0); // update balance and display account number and
											  // current balance. Call the toString() method in deposit().

		  // Withdraw from the account
		  myAccount.withdraw(100.0); // update balance and display account number and
											  // current balance. Call the toString() method in withdraw().

		  // Close the account
		  myAccount.close(); // displays "Account is closed!"

		  // Activate the account
		  myAccount.activate(); // displays "You cannot activate a closed account!"

		  // Suspend the account
		  myAccount.suspend(); // displays "You cannot suspend a closed account!"

		  // Withdraw from the account
		  myAccount.withdraw(500.0); // Show message "You cannot withdraw on a closed account!".
											  // Call the toString() to show current balance and account number.

		  // Deposit to the account
		  myAccount.deposit(1000.0); // Show message "You cannot deposit on closed account!".
											  // Call the toString() to show current balance and account number.
	 }
}
```

public class AccountTest {
	public static void main (String[] args) {

		Account myAccount = new Account("1234", 10000.0); //set acct to active state
		myAccount.activate();
		myAccount.suspend();
		myAccount.activate();
		myAccount.deposit(1000.0);
		myAccount.withdraw(100.0);
		myAccount.close();
		myAccount.activate();
		
		//Withdraw to the account
		myAccount.withdraw(500.0);// Show message "You cannot withdraw on a closed account!". Call the toString() to show current balance and account number.

		//Deposit to the account
		myAccount.deposit(1000.0);// Show message "You cannot deposit on closed account!". Call the toString() to show current balance and account number.
	}
}

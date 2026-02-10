public class ActiveState implements AccountState {

    @Override
    public void activate(Account account) {
        System.out.println("Account is already activated!");
    }

    @Override
    public void suspend(Account account) {
        account.setState(new SuspendedState());
        System.out.println("Account is suspended!");
    }

    @Override
    public void close(Account account) {
        account.setState(new ClosedState());
        System.out.println("Account is closed!");
    }

    @Override
    public void deposit(Account account, double amount) {
        account.setBalance(account.getBalance() + amount);
        System.out.println("Deposited: " + amount + ". New balance: " + account.getBalance());
        System.out.println(account.toString());
    }

    @Override
    public void withdraw(Account account, double amount) {
        if (amount > account.getBalance()) {
            System.out.println("Insufficient funds for withdrawal of: " + amount);
        } else {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdrew: " + amount + ". New balance: " + account.getBalance());
            System.out.println(account.toString());
        }
    }
}
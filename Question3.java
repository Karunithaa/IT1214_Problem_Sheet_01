class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }

    public String toString() {
        return "Account Number: " + accountNumber +", Holder: " + accountHolder +", Balance: " + balance;
    }
}

class Bank {
    private BankAccount[] accounts;
    private int accountCount;

    public Bank() {
        accounts = new BankAccount[5];
        accountCount = 0;
    }

    public void addAccount(BankAccount account) {
        if (accountCount < accounts.length) {
            accounts[accountCount++] = account;
        } else {
            System.out.println("Bank account limit reached. Cannot add more accounts.");
        }
    }

    public void withdrawFromAccount(int accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            try {
                account.withdraw(amount);
                System.out.println("Withdrawal of " + amount + " from account " + accountNumber + " successful.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error for account " + accountNumber + ": " + e.getMessage());
            }
        } else {
            System.out.println("Account number " + accountNumber + " not found.");
        }
    }

    private BankAccount findAccount(int accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }
        }
        return null;
    }

    public void displayAllAccounts() {
        System.out.println("Bank Account Details:");
        for (int i = 0; i < accountCount; i++) {
            System.out.println(accounts[i]);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Bank b1 = new Bank();

        b1.addAccount(new BankAccount(1001, "Alice", 5000.0));
        b1.addAccount(new BankAccount(1002, "Bob", 3000.0));

        b1.withdrawFromAccount(1001, 6000.0); 
        b1.withdrawFromAccount(1002, 1000.0);

        b1.displayAllAccounts();
    }
}

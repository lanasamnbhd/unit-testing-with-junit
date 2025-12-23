public class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Yatırılacak tutar 0'dan büyük olmalıdır.");
        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Çekilecek tutar 0'dan büyük olmalıdır.");
        }
        if (amount > this.balance) {
            throw new RuntimeException("Yetersiz bakiye.");
        }
        this.balance -= amount;
    }

    public double getBalance() {
        return this.balance;
    }
}

package com.ndnhuy;

public class Account {

    private String name;

    private long balance;

    public Account(String name) {
        this(name, 0);
    }

    public Account(String name, long balance) {
        this.name = name;
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public boolean canTransfer(long amt) {
        validateAmount(amt);
        return balance - amt >= 0;
    }

    public void validateAmount(long amt) {
        if (amt < 0) {
            throw new IllegalArgumentException("amt must be >= 0");
        }
    }

    public void increase(long amt) {
        validateAmount(amt);
        balance += amt;
    }

    public void decrease(long amt) {
        if (!canTransfer(amt)) {
            throw new IllegalArgumentException("balance is not enough");
        }
        balance -= amt;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}

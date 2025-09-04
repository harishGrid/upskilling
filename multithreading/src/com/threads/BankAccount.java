package com.threads;

public class BankAccount {
    private int balance = 1000;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(balance);
        } else {
            System.out.println(" insufficient funds for withdrawal");
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Runnable depositTask = () -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(100);
                sleep(100);
            }
        };

        Runnable withdrawTask = () -> {
            for (int i = 0; i < 5; i++) {
                account.withdraw(150);
                sleep(150);
            }
        };

        Thread t1 = new Thread(depositTask, "Deposit");
        Thread t2 = new Thread(withdrawTask, "Withdraw");

        t1.start();
        t2.start();
    }

    private static void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { }
    }
}
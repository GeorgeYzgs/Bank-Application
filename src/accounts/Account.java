/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts;

/**
 *
 * @author George.Giazitzis
 */
public abstract class Account implements IBaserate {

    private String name;
    private String sSN;
    private double balance;
    protected String accountNumber;
    protected double rate;
    static int index = 10000;

    public Account(String name, String sSN, double initDeposit) {
        index++;
        this.name = name;
        this.sSN = sSN;
        this.balance = initDeposit;
        this.accountNumber = setAccountNumber();
        setRate();
    }

    public abstract void setRate();

    public void compoundInterest() {
        double accruedInterest = balance * (rate / 100);
        balance += accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        printBalance();
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Depositing: $" + amount);
        printBalance();
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawing: $" + amount);
            printBalance();
        } else {
            System.out.println("Insufficient Funds");
        }
    }

    public void printBalance() {
        System.out.println("Your balance is: $" + balance);
    }

    public void transfer(String destination, double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Transferring: $" + amount + " to Account: " + destination);
        } else {
            System.out.println("Insufficient Funds");
        }
    }

    private String setAccountNumber() {
        String sSNLastDigits = sSN.substring(sSN.length() - 2, sSN.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));
        return sSNLastDigits + uniqueID + randomNumber;
    }

    public void showInfo() {
        System.out.println("NAME: " + name
                + "\nACCOUNT NUMBER: " + accountNumber
                + "\nBALANCE: $" + balance
                + "\nRATE: " + rate + "%");
    }
}

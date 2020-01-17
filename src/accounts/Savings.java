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
public class Savings extends Account {

    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    public Savings(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

       @Override
    public void setRate() {
        rate = getBaseRate() - .25;
    }

    private void setSafetyDepositBox() {
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
    }

    @Override
    public void showInfo() {
        System.out.println("Account Type: Savings ");
        super.showInfo();
        System.out.println("Saving Account Features: "
                + "\nSafety Deposit Box ID: " + safetyDepositBoxID
                + "\nSafety Deposit Box Key: " + safetyDepositBoxKey);
    }  
}

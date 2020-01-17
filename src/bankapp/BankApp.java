/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

import accounts.*;
import database.AccountDatabase;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author George.Giazitzis
 */
public class BankApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Account> accounts = AccountDatabase.createAccounts("NewBankAccounts.csv");   
        for (Account acc : accounts) {
            acc.showInfo();
        }
    }
}

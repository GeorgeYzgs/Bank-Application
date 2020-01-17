/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import accounts.Account;
import accounts.Checking;
import accounts.Savings;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author George.Giazitzis
 */
public class AccountDatabase {

    public static List<String[]> read(String file) {
        List<String[]> data = new LinkedList();
        String dataRow;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((dataRow = br.readLine()) != null) {
                String[] dataRecord = dataRow.split(",");
                data.add(dataRecord);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Could not Find File!");
            ex.getMessage();
        } catch (IOException ex) {
            System.out.println("Could not Read File!");
            ex.getMessage();
        }
        return data;
    }

    public static List<Account> createAccounts(String path) {
        List<Account> list = new LinkedList();
        List<String[]> newAccountHolders = read(path);
        for (String[] account : newAccountHolders) {
            String name = account[0];
            String sSN = account[1];
            String accountType = account[2];
            double initDeposit = Double.parseDouble(account[3]);
            if (accountType.equalsIgnoreCase("Savings")) {
                list.add(new Savings(name, sSN, initDeposit));
            } else if (accountType.equalsIgnoreCase("Checking")) {
                list.add(new Checking(name, sSN, initDeposit));
            } else {
                System.out.println("Error Reading Account Type");
            }
        }
        return list;
    }
}

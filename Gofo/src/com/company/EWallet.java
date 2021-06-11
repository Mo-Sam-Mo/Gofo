package com.company;

/**
 * this class holds the wallet function and the balance in it
 *
 * @version 2.1
 * @author Hanan , Mohamed, Fatima
 */

public class EWallet {
    protected double balance = 0;

    /**
     * it takes money from the wallet
     *
     * @param amount the amount to take it
     * @return true if balance is enough
     */
    public boolean withdraw(double amount){
        if(balance>=amount){
            balance -= amount;
            return true;
        }else{
            System.out.println("Your don't enough money in your eWallet");
            return false;
        }
    }

    /**
     * it increase money to the wallet
     *
     * @param amount the amount to add it
     * @return true if amount is positive
     */
    public boolean deposit(double amount){
        if (amount < 0)
            return false ;
        balance += amount;
        return true;
    }
}


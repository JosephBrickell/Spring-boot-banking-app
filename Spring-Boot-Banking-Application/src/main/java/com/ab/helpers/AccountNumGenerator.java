package com.ab.helpers;

import java.util.Random;

public class AccountNumGenerator {
	
	
	public static int generateAccountNumber(){
        int accountNumber;
        Random random = new Random();
        int bound = 1000;
        accountNumber = bound * random.nextInt(bound);
        return accountNumber;
    }

}

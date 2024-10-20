package ru.mirea.lab19.task1;

public class OrderMaker {
    private static final int[] COEFF1 = new int[]{7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
    private static final int[] COEFF2 = new int[]{3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};

    public static void placeOrder (String name, String ITN) {
        if(ITN.length() != 12)
            throw new IncorrectITNException("ITN must be 12 numbers long");
        int checkDigit1 = 0;
        for(int i = 0; i < 10; i++)
            checkDigit1 += (ITN.charAt(i) - '0') * COEFF1[i];
        checkDigit1 = (checkDigit1 % 11) % 10;
        int checkDigit2 = 0;
        for(int i = 0; i < 11; i++)
            checkDigit2 += (ITN.charAt(i) - '0') * COEFF2[i];
        checkDigit2 = (checkDigit2 % 11) % 10;
        if(checkDigit1 != ITN.charAt(10) - '0' || checkDigit2 != ITN.charAt(11) - '0')
            throw new IncorrectITNException("The check digits did not match");
        System.out.println("The order has been placed");
    }
}

package ru.mirea.lab13;

public class PhoneNumber {
    static String formatNumber(String number) {
        if(number.charAt(0) == '+') {
            StringBuilder country_code = new StringBuilder();
            StringBuilder phone_number = new StringBuilder();
            int i = number.length() - 1;
            for(int j = 1; i > number.length() - 11; i--, j++) {
                if(!(number.charAt(i) >= '0' && number.charAt(i) <= '9'))
                    return "";
                phone_number.append(number.charAt(i));
                if(j == 4 || j == 7)
                    phone_number.append('-');
            }
            while(number.charAt(i) != '+') {
                if(!(number.charAt(i) >= '0' && number.charAt(i) <= '9'))
                    return "";
                country_code.append(number.charAt(i));
                i--;
            }
            phone_number.append(' ');
            country_code.append('+');
            phone_number.reverse();
            country_code.reverse();
            country_code.append(phone_number);
            return country_code.toString();
        }
        else if(number.charAt(0) == '8' && number.length() == 11) {
            StringBuilder res = new StringBuilder("+7 ");
            for(int i = 1; i < 11; i++) {
                if(!(number.charAt(i) >= '0' && number.charAt(i) <= '9'))
                    return "";
                res.append(number.charAt(i));
                if(i == 3 || i == 6)
                    res.append('-');
            }
            return res.toString();
        }
        else
            return "";
    }
}

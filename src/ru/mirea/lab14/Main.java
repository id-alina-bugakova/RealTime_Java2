package ru.mirea.lab14;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void task14_3() {
        String regex = "(\\d+\\.)(\\d{2}\\s)(USD|RUB|EU)";
        String text = "20.91 RUB, 2000.00 USD, 123.456 RUB, 12.24 ERR, 12.20USD, 1.90 EU, 123.34 rub";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        ArrayList<String> res = new ArrayList<>();
        while(matcher.find())
            res.add(text.substring(matcher.start(), matcher.end()));
        System.out.println(res);
    }
    public static void task14_5() {
        String all_yrs = "((19|[2-9][0-9])([0-9]{2})";
        String all_mhs = "(0[1-9]|1[0-2])";
        String days_28 = "(0[1-9]|1[0-9]|2[0-8])";
        String day_30 = "(30/(0[1-9^2]|1[0-2]))";
        String day_31 = "(31/(0[13578]|1[02]))";
        //String mult4 = "([02468][048]|[13579][26])";
        String nult4_ex_before_19 = "([2468][048]|[3579][26])";
        String mult4_ex_00 = "([02468][48]|[13579][26])";
        String leap = "(29/02/("+nult4_ex_before_19+"}00|(19|2[0-9])"+mult4_ex_00+"))";
        String regex = "((("+days_28+"/"+all_mhs+")|"+day_30+"|"+day_31+")/"+all_yrs+")|"+leap+")";
        Pattern pattern = Pattern.compile(regex);
        String text = """
                29/02/2000
                29/02/2001
                29/02/2100
                29/02/2004
                30/02/2004
                31/04/2020
                35/12/2024
                30/04/2000
                91/02/1990
                28/15/2004
                28/36/2004
                12/12/1899
                12/12/9999
                1/1/1900
                1 jan 1900
                """;
        Matcher matcher = pattern.matcher(text);
        while(matcher.find())
            System.out.println(text.substring(matcher.start(), matcher.end()));
    }
    public static void task14_6() {
        String s1 = "[a-zA-Z0-9!#%&'*+/=?^_{|}~-]";
        String s2 = "[a-zA-Z0-9!#%&'*+/=?^_{|}~]";
        String regex = "^((("+s1+"+\\.)*)"+s1+"+)@(("+s2+"+(-"+s2+"+)*)(\\."+s2+"+(-"+s2+"+)*)*)$";
        String[] emails = {
                "user@example.com",                    // correct
                "u-ser@example.com",                   // correct
                "first.last@subdomain.example.com",    // correct
                "user+tag@example-domain.com",         // correct
                "12345@example.com",                   // correct
                "user@example",                        // correct
                "User@example.com",                    // correct
                "user:address@example.com",            // incorrect (unauthorised symbol :)
                ".user@example.com",                   // incorrect (local-part starts with .)
                "user.@example.com",                   // incorrect (local-part ends with .)
                "first..last@example.com",             // incorrect (local-part contains double .)
                "user@.com",                           // incorrect (domain starts with .)
                "user@domain..com",                    // incorrect (domain contains double .)
                "user@-example.com",                   // incorrect (domain starts with -)
                "user@example.com-",                   // incorrect (domain ends with -)
                "myhost@@@com.ru",                     // incorrect (triple @)
                "@my.ru",                              // incorrect (no local-part)
                "my@",                                 // incorrect (no domain)
                "hi, user@example.com"                 // incorrect (not an email)
        };
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        for (String str : emails) {
            if(Pattern.matches(regex, str))
                System.out.println("correct:   " + str);
            else
                System.out.println("incorrect: " + str);
        }
    }

    public static void main(String[] args) {
        task14_5();
    }
}

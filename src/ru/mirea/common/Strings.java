package ru.mirea.common;

public class Strings {
    public static boolean emptyLine(String s) {
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i) != '\n' && s.charAt(i) != '\t' && s.charAt(i) != ' ') {
                return false;
            }
        return true;
    }
}

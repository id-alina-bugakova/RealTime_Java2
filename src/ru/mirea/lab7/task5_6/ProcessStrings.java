package ru.mirea.lab7.task5_6;

public class ProcessStrings implements StringProcessable {
    private String str;

    public ProcessStrings() {
        this.str = "";
    }
    public ProcessStrings(String str) {
        this.str = str;
    }

    public void setString (String str) {
        this.str = str;
    }

    @Override
    public int size() {
        return this.str.length();
    }

    @Override
    public String getOdd() {
        String res = "";
        for(int i = 1; i < this.size(); i += 2)
            res += this.str.charAt(i);
        return res;
    }

    @Override
    public String reverse() {
        String res = "";
        for(int i = this.size() - 1; i >= 0; i--)
            res += this.str.charAt(i);
        return res;
    }
}

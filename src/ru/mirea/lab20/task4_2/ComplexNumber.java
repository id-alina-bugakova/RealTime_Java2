package ru.mirea.lab20.task4_2;

public class ComplexNumber implements Calculable<ComplexNumber> {
    private double re;
    private double im;

    public ComplexNumber() {
        this.re = 0;
        this.im = 0;
    }
    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public void setRe(double re) {
        this.re = re;
    }
    public void setIm(double im) {
        this.im = im;
    }
    public void setNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }
    public double getRe() {
        return this.re;
    }
    public double getIm() {
        return this.im;
    }

    public double abs() {
        return Math.sqrt(re * re + im * im);
    }

    public boolean equals(ComplexNumber other) {
        return this.re == other.re && this.im == other.im;
    }
    public boolean equals(double other) {
        return this.re == other && this.im == 0;
    }

    @Override
    public ComplexNumber add(ComplexNumber summand2) {
        return new ComplexNumber(this.re + summand2.re, this.im + summand2.im);
    }
    @Override
    public ComplexNumber subtract(ComplexNumber subtrahend) {
        return new ComplexNumber(this.re - subtrahend.re, this.im - subtrahend.im);
    }
    @Override
    public ComplexNumber multiply(ComplexNumber multiplier2) {
        return new ComplexNumber(this.re * multiplier2.re - this.im * multiplier2.im, this.re * multiplier2.im + this.im * multiplier2.re);
    }
    @Override
    public ComplexNumber divide(ComplexNumber divisor) {
        if(this.equals(0))
            throw new ArithmeticException("Division by zero in ComplexNumber.divide");
        double div = divisor.re * divisor.re + divisor.im * divisor.im;
        return new ComplexNumber((this.re * divisor.re + this.im * divisor.im) / div, (this.im * divisor.re - this.re * divisor.im) / div);
    }

    @Override
    public String toString() {
        if(this.im == 0)
            return "" + this.re;
        else
            return this.re + " + " + this.im + "i";
    }
}

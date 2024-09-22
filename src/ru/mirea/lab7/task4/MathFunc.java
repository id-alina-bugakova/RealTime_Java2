package ru.mirea.lab7.task4;

import java.util.function.Function;

public class MathFunc implements MathCalculable{
    public long binpow(int a, int p) {
        if(p == 0) return 1;
        if(p == 1) return a;
        if(p % 2 == 0) {
            long res = binpow(a, p / 2);
            return res * res;
        }
        else
            return a * binpow(a, p - 1);
    }

    public double simpson (Function<Double, Double> f,double a, double b) {
        return (b - a) / 6 * (f.apply(a) + 4*f.apply((a + b) / 2) + f.apply(b));
    }
    public double ln (double x) {
        if(x == 1) return 0;
        if(x <= 0) return Double.NaN;
        double res = 0;
        double step = (x - 1) / 100;
        Function<Double, Double> f = (n) -> 1/n;
        for(double a = 1; a < x; a += step)
            res += simpson(f, a, a + step);
        return res;
    }
    public double abs (double x) {
        if(x < 0)
            return -x;
        return x;
    }

    @Override
    public double pow(double a, double p) {
        double res = 1, tmp = 1;
        double m = p * ln(a);
        for(int i = 1; abs(tmp) >= 1e-10; i++) {
            tmp *= m / i;
            res += tmp;
        }
        return res;
    }
    @Override
    public double complex_abs(int r, int i) {
        return pow(r * r + i * i, 1.0/2);
    }
}

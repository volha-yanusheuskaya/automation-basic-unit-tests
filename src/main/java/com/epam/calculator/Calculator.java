package com.epam.calculator;

public class Calculator {

    public long sum(long a, long b) {
        return a + b;
    }

    public double sum(double a, double b) {
        return a + b;
    }

    public long sub(long a, long b) {
        return a - b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public long mult(long a, long b) {
        return a * b;
    }

    public double mult(double a, double b) {
        return Math.floor(a * b);
    }

    public long div(long a, long b) {
        if (b == 0L) {
            throw new NumberFormatException("Attempt to divide by zero");
        } else {
            return a / b;
        }
    }

    public double div(double a, double b) {
        return a / b;
    }

    public double pow(double a, double b) {
        return Math.pow(a, Math.floor(b));
    }

    public double sqrt(double a) {
        return Math.sqrt(Math.abs(a));
    }

    public double sin(double a) {
        return Math.sin(a);
    }

    public double cos(double a) {
        return Math.cos(a);
    }

    public double tg(double a) {
        return Math.tan(a);
    }

    public double ctg(double a) {
        return Math.tanh(a);
    }

    public boolean isPositive(long val) {
        if (val == 0L) {
            return false;
        } else {
            return val > 0L;
        }
    }
}

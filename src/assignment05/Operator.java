package assignment05;

public abstract class Operator {
    private double arg;
    public Operator(double arg) {
        this.arg = arg;
    }
    public double getArg() {
        return arg;
    }    
    public abstract double modify(double value);
}
public class Polynomial {
    private double[] coefficients = {0.0};

    public Polynomial(double[] coefficients) {
        this.coefficients = coefficients.clone();
    }

    public Polynomial() {}

    public Polynomial add(Polynomial toAdd) {
        int thisLength = this.coefficients.length;
        int thatLength = toAdd.coefficients.length;
        double[] result = new double[thisLength > thatLength ? thisLength : thatLength];
        for (int i = 0; i < result.length; i++) {
            result[i] = (thisLength > i ? this.coefficients[i] : 0) + (thatLength > i ? toAdd.coefficients[i] : 0);
        }
        return new Polynomial(result);
    }

    public double evaluate(double x) {
        double sum = this.coefficients[0];
        double powerOfX = x;
        for (int i = 1; i < this.coefficients.length; i++) {
            sum += powerOfX * this.coefficients[i];
            powerOfX *= x;
        }
        return sum;
    }

    public boolean hasRoot(double x) {
        double result = evaluate(x);
        return Math.abs(result) < 1e-9;
    }
}



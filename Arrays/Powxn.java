package Arrays;

public class Powxn {
    public double myPow(double x, long n) {
        // If 'n' is negative, take reciprocal of positive exponent result
        if (n < 0) {
            return 1.0 / power(x, -n);
        }
        // If 'n' is non-negative
        return power(x, n);
    }
     // Helper method to calculate power using recursion
    private double power(double x, long n) {
        // Base case: anything raised to 0 is 1
        if (n == 0) return 1.0;
        
        // Base case: anything raised to 1 is itself
        if (n == 1) return x;
        
        // If 'n' is even
        if (n % 2 == 0) {
            // Recursive call: square the base and halve the exponent
            return power(x * x, n / 2);
        }
        
        // If 'n' is odd
        // Recursive call: multiply base once and reduce exponent by 1
        return x * power(x, n - 1);
    }
}

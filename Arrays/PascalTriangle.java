package Arrays;

public class PascalTriangle {
     public long findPascalElement(int r, int c) {
        // Element is C(r-1, c-1)
        int n = r - 1;
        int k = c - 1;

        long result = 1;

        // Compute C(n, k) using iterative formula
        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }

        return result;
    }

// Main class to test the solution
    public static void main(String[] args) {
        PascalTriangle sol = new PascalTriangle();
        int r = 5, c = 3;
        System.out.println(sol.findPascalElement(r, c));
    }


}
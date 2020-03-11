public class Assert_No {
    public static int factorial(int n) {
      
        if (n == 0) {
            return 1;
        }
        
        if (n == 1) {
            return 1;
        }
        
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    
    public static void main(String[] args) {
        StdOut.println(Assert_No.factorial(-2));
    }
}

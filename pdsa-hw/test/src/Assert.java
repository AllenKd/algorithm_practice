public class Assert {
    public static int factorial(int n) {
        assert checkInput(n); //assert n >= 0;
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
    
    private static boolean checkInput(int n) {
        if (n >= 0) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        StdOut.println(Assert.factorial(3));
    }
}

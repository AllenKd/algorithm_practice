public class CallByReference {
    private static void testArray1(int[] a) {
        a[0] *= 10;
    } 
    
    private static void testArray2(int[] a) {
        a = new int[] {3, 2, 1};
    }
    
    private static void testString(String s) {
        s += "def";
        System.out.println(s);
    }
    
    private static void testSrringBuilder(StringBuilder sb) {
        sb.append("def");
    }
    
    private static void testSwap1(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
    
    private static void testSwap2(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
    }
    
    private static void testSwap3(int[] a, int[] b) {
        int temp = a[0];
        a[0] = b[0];
        b[0] = temp;
    }
    
    private static void testSwap4(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
    
    public static void main(String[] args) {
        int[] ia = {1, 2, 3};
        System.out.println(ia.length);
        System.out.println(ia[0]);
        testArray1(ia);
        System.out.println(ia[0]);
        
        testArray2(ia);
        System.out.println(ia[0]);
        
        String s = "abc";
        System.out.println(s);
        testString(s);
        System.out.println(s);
        
        StringBuilder sb = new StringBuilder("abc");
        System.out.println(sb.toString());
        testSrringBuilder(sb);
        System.out.println(sb);
        
        int a = 1;
        int b = 2;
        System.out.println("a=" + a + ", b=" + b);
        testSwap1(a, b);
        System.out.println("a=" + a + ", b=" + b);
        
        Integer a2 = 1;
        Integer b2 = 2;
        System.out.println("a2=" + a2 + ", b2=" + b2);
        testSwap2(a2, b2);
        System.out.println("a2=" + a2 + ", b2=" + b2);
        
        a = 1;
        b = 2;
        System.out.println("a=" + a + ", b=" + b);
        int[] ia2 = {a};
        int[] ib2 = {b};
        testSwap3(ia2, ib2);
        a = ia2[0];
        b = ib2[0];
        System.out.println("a=" + a + ", b=" + b);

        int[] ia3 = {1, 2, 3};
        System.out.println("ia3[0]=" + ia3[0] + ", ia3[1]=" + ia3[1]);
        testSwap4(ia3, 0, 1);
        System.out.println("ia3[0]=" + ia3[0] + ", ia3[1]=" + ia3[1]);
        
    }
}

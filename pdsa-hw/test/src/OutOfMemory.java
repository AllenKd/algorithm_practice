public class OutOfMemory {
    public static void main(String[] args) {
        int[] ia = new int[4 * (int) Math.pow(10, 8)];
    }
}

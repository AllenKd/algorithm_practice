
public class Ice {
    public static final double MIN_WIDTH = 2;
    public static final double MIN_HEIGHT = 2;
    public static final double MIN_DEPTH = 2;
    public static final double MIN_VOLUME;
    private static int COUNT = 0;
    
    private double width;
    private double height;
    private double depth;
    private double volume;
    
    static {
        MIN_VOLUME = MIN_WIDTH * MIN_HEIGHT * MIN_DEPTH;
    }
    
    Ice(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        volume = width * height * depth;
        COUNT++;
    }
    
    public static double getMIN_VOLUME() {
        //double v = volume; //cannot reference object member
        return MIN_VOLUME;
    }
    
    public static int getCOUNT() {
        return COUNT;
    }
    
    public double getVolume() {
        return volume;
    }

    public static void main(String[] args) {
        System.out.println("MIN_VOLUME=" + Ice.MIN_VOLUME);
        Ice ice1 = new Ice(3, 3, 3);
        System.out.println(ice1.getVolume());
        System.out.println("COUNT=" + Ice.getCOUNT());
        
        Ice ice2 = new Ice(4, 4, 4);
        System.out.println(ice2.getVolume());
        System.out.println("COUNT=" + Ice.getCOUNT());
    }
}

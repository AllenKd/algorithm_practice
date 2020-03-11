public class OutterClass {
    private int oi;
    private Inner inner;
    
    public OutterClass(int oi) {
        this.oi = oi;
    }
    
    private class Inner {
        int ii;
        
        public Inner() {
            ii = oi * 10;
        }
        
        public void display() {
            System.out.println("inner object: " + ii + " : outer object: " + oi);
        }
    }
    
    public void setInner() {
        inner = new Inner();
    }
    
    public static void main(String[] args) {
        OutterClass o1 = new OutterClass(1);
        o1.setInner();
        o1.inner.display();
        
        OutterClass o2 = new OutterClass(2);
        o2.setInner();
        o2.inner.display();
        
        o2.oi = 3;
        o2.inner.display();
    }
}

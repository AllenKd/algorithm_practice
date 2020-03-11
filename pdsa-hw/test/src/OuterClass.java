public class OuterClass {
    private int oi;
    private Inner inner;
    
    public OuterClass(int oi) {
        this.oi = oi;
    }
    
    public class Inner {
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
    
    public static class Inner2 {
    }

    
    public static void main(String[] args) {
        OuterClass o1 = new OuterClass(1);
        o1.setInner();
        o1.inner.display();
        
        OuterClass o2 = new OuterClass(2);
        o2.setInner();
        o2.inner.display();
        
        o2.oi = 3;
        o2.inner.display();
    }
}

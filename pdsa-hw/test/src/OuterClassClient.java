
public class OuterClassClient {
    public static void main(String[] args) {
        OuterClass oc = new OuterClass(1);
        OuterClass.Inner2 inner = new OuterClass.Inner2();
       
        Integer oi = 1;
        oi = 2;
    }
}

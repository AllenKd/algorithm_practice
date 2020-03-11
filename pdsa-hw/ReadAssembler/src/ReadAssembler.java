
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author don
 */
public class ReadAssembler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stopwatch timer = new Stopwatch();
        In in = new In(args[0]);
        int k = in.readInt();
        int n = in.readInt();
        int count = 1;
        Hashtable hashtable = new Hashtable();
        ArrayList store = new ArrayList();
        store.add(0);
        String firstread = in.readString();
        hashtable.put(firstread, 0);
        for (int i = 1; i <= k - n; i++) {
            hashtable.put(firstread.substring(i), 0);
            hashtable.put(firstread.substring(0, k - i), 0);
        }
        while (true) {
            if (in.isEmpty()) {
                break;
            }
            String test = in.readString();
            if (test.length() != k) {
                StdOut.println("Input error!");
                System.exit(0);
            }
            hashtable.put(test, count);
            store.add(count);
            for (int i = 1; i <= k - n; i++) {
                if (hashtable.containsKey(test.substring(i))) {
//                    if (!store.contains(test)) {
//                        store.add(test);
//                    }
//                    hashtable.put(test.substring(i), (int)hashtable.get(test.substring(i)));
//                    store.set(count, (int) store.get((int) hashtable.get(test.substring(i))));
//                    obj1.x =  (int)store.get((int) hashtable.get(test.substring(i)));
//                    store.set((int) store.get((int) hashtable.get(test.substring(i))), obj2.get());
                } else {
                    hashtable.put(test.substring(i), count);
                }
                if (hashtable.containsKey(test.substring(0, k - i))) {
//                    if (!store.contains(test)) {
//                        store.add(test);
//                    }
//                    store.set(count, (int) store.get((int) hashtable.get(test.substring(0, k - i))));
//                    obj1.x =  (int)store.get((int) hashtable.get(test.substring(i)));
//                    store.set((int) store.get((int) hashtable.get(test.substring(0, k - i))), obj2.get());
                } else {
                    hashtable.put(test.substring(0, k - i), count);
                }
            }
            count++;
        }
        UF uf = new UF(count);
        for (int i = 0; i < hashtable.size(); i++) {

        }
        int out = 0;
        for (int i = 0; i < count; i++) {
            if ((int) store.get(i) == i) {
                out++;
            }
        }
        StdOut.println(out);
//        StdOut.println(count-store.size());
//        StdOut.println("elapsed time = " + timer.elapsedTime());
    }
}

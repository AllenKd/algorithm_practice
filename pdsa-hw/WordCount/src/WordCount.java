/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author don
 */
public class WordCount {

    /**
     * @param args the command line arguments
     */
//    In in = new In(args[0]);
    public static void main(String[] args) {
        In in = new In(args[0]);
        ST<String, Integer> st = new ST<String, Integer>();
        // compute frequency counts
        while (!in.isEmpty()) {
            String key = in.readString().toLowerCase();
            if (key.length() <= 3) {
                continue;
            }
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            } else {
                st.put(key, 1);
            }
        }
        
        // find a key with the highest frequency count
        String max = "";
        String second = "";
        String third = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max)) {
                max = word;
            }
        }
        StdOut.println(max.toLowerCase() + " " + st.get(max));
        st.delete(max);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(second)) {
                second = word;
            }
        }
        StdOut.println(second.toLowerCase() + " " + st.get(second));
        st.delete(second);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(third)) {
                third = word;
            }
        }
        StdOut.println(third.toLowerCase() + " " + st.get(third));

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author don
 */
public class Test {

    /**
     * @param args the command line arguments
     */
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
    }

}

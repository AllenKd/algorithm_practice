/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author don
 */
public class HW8_1 {

    private static Node root = null;

    public static Node BTrebuild(String inString, String postString) {
        // Build a binary tree based on in-order and post-order traversal and return the root of binary tree constructed.
        // The judging system will traverse your binary tree from this root, therefore DO NOT return only the key or value of the root.
        if (inString.length() == 0 && postString.length() == 0) {
            return null;
        }
        String[] inorder = inString.split(" ");
        String[] postorder = postString.split(" ");
        Node[] k = new Node[inorder.length];
        Node[] l = new Node[inorder.length];
        ArrayList<Node> lio = new ArrayList();
        ArrayList<Node> lpo = new ArrayList();
        ArrayList<Node> rio = new ArrayList();
        ArrayList<Node> rpo = new ArrayList();
        for (int i = 0; i < k.length; i++) {
            k[i] = new Node(Integer.valueOf(inorder[i]), Integer.valueOf(inorder[i]));
            l[i] = new Node(Integer.valueOf(postorder[i]), Integer.valueOf(postorder[i]));
            lio.add(k[i]);
            lpo.add(l[i]);
            rio.add(k[i]);
            rpo.add(l[i]);
        }
        Node temp = l[l.length - 1];
        if (root == null) {
            root = l[l.length - 1];
        }
        for (int i = 0; i < k.length; i++) {//divide to left and roght
            if (lio.get(i).getKey() == lpo.get(lpo.size() - 1).getKey()) {
                for (int j = 0; j < rio.size(); j++) {
                    lio.remove(i);
                    lpo.remove(i);
                }
                break;
            }
            rio.remove(0);
            rpo.remove(0);
        }
        rio.remove(0);
        rpo.remove(rpo.size() - 1);
        if (lio.size() == 1 && rio.size() == 1) {
            temp.setLeft(lio.get(0));
            temp.setRight(rio.get(0));
            lio.remove(0);
            lpo.remove(0);
            rio.remove(0);
            rpo.remove(0);
            return temp;
        } else if (rio.size() == 1) {
            temp.setRight(rio.get(0));
            rio.remove(0);
            rpo.remove(0);
            if (lio.size() == 0) {
                return temp;
            } else {
                String asd1 = new String();
                String zxc1 = new String();
                for (int i = 0; i < lio.size(); i++) {
                    asd1 += String.valueOf(lio.get(i).getKey()) + " ";
                    zxc1 += String.valueOf(lpo.get(i).getKey()) + " ";
                }
                Node next = BTrebuild(asd1, zxc1);
                temp.setLeft(next);
            }
            return temp;
        } else if (lio.size() == 1) {
            temp.setLeft(lio.get(0));
            lio.remove(0);
            lpo.remove(0);
            if (rio.size() == 0) {
                return temp;
            } else {
                String asd = new String();
                String zxc = new String();
                for (int i = 0; i < rio.size(); i++) {
                    asd += String.valueOf(rio.get(i).getKey()) + " ";
                    zxc += String.valueOf(rpo.get(i).getKey()) + " ";
                }
                Node next = BTrebuild(asd, zxc);
                temp.setRight(next);
            }
            return temp;
        } else if (lio.size() == 0 && rio.size() > 1) {
            String asd = new String();
            String zxc = new String();
            for (int i = 0; i < rio.size(); i++) {
                asd += String.valueOf(rio.get(i).getKey()) + " ";
                zxc += String.valueOf(rpo.get(i).getKey()) + " ";
            }
            Node next = BTrebuild(asd, zxc);
            temp.setRight(next);
            return temp;
        } else if (rio.size() == 0 && lio.size() > 1) {
            String asd1 = new String();
            String zxc1 = new String();
            for (int i = 0; i < lio.size(); i++) {
                asd1 += String.valueOf(lio.get(i).getKey()) + " ";
                zxc1 += String.valueOf(lpo.get(i).getKey()) + " ";
            }
            Node next = BTrebuild(asd1, zxc1);
            temp.setLeft(next);
            return temp;
        }
        if (lio.size() > 1) {
            String asd = new String();
            String zxc = new String();
            for (int i = 0; i < lio.size(); i++) {
                asd += String.valueOf(lio.get(i).getKey()) + " ";
                zxc += String.valueOf(lpo.get(i).getKey()) + " ";
            }
            Node next = BTrebuild(asd, zxc);
            root.setLeft(next);
        }
        if (rio.size() > 1) {
            String asd1 = new String();
            String zxc1 = new String();
            for (int i = 0; i < rio.size(); i++) {
                asd1 += String.valueOf(rio.get(i).getKey()) + " ";
                zxc1 += String.valueOf(rpo.get(i).getKey()) + " ";
            }
            Node next = BTrebuild(asd1, zxc1);
            root.setRight(next);
        }

        return root;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Node x = BTrebuild("2 13 14 12 11 10 1 3 5 9 6 7 8 4", "14 13 12 11 10 2 9 8 7 6 5 4 3 1");
    }

}

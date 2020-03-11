
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author don
 */
public class HW8_2 {

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
        Node temp = l[0];
        if (root == null) {
            root = l[0];
        }
        for (int i = 0; i < k.length; i++) {//divide to left and roght
            if (lio.get(i).getKey() == lpo.get(0).getKey()) {
                lpo.remove(0);
                for (int j = 0; j < rio.size(); j++) {
                    lio.remove(i);
                    if (j < rio.size() - 1) {
                        lpo.remove(i);
                    }
                }
                break;
            }
            rio.remove(0);
            rpo.remove(0);
        }
        rio.remove(0);
        rpo.remove(0);
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
    private static Node tri = null;
    private static ArrayList<Node> al = new ArrayList();

    public static void triversal(Node x) {
        if (tri == null) {
            tri = x;
        }
        if (al.size() > 0) {
            if (al.get(al.size() - 1).getKey() == tri.getKey()) {
                for (int i = 0; i < al.size(); i++) {
                    StdOut.print(al.get(i).getKey() + " ");
                }
                System.exit(0);
                return;
            }
        }
        if (al.contains(x.getLeft()) && al.contains(x.getRight())) {
            al.add(x);
            if(al.get(al.size()-1).getKey()==tri.getKey()){
                return;
            }
            triversal(tri);
        }
        if (al.contains(x.getLeft())) {
            if (x.getRight() == null) {
                al.add(x);
                triversal(tri);
            } else {
                triversal(x.getRight());
            }
        }
        if (x.getLeft() == null && x.getRight() == null) {
            al.add(x);
            triversal(tri);
        }
        if (x.getLeft() == null && al.contains(x.getRight())) {
            al.add(x);
            triversal(tri);
        }
        if (x.getLeft() != null) {
            triversal(x.getLeft());
        }
        if (x.getRight() != null) {
            triversal(x.getRight());
        }
//        if (x.getLeft() == null) {
//            if (x.getRight() == null) {
//                StdOut.print(x.getKey() + " ");
//                al.add(x);
//                x = tri;
//            } else {
//                x = x.getRight();
//            }
//        } else {
//            x = x.getLeft();
//        }

//        if (x.getLeft() == null && !al.contains(x)) {
//            if (x.getRight() == null && !al.contains(x)) {
//                StdOut.print(x.getKey() + " ");
//                al.add(x);
//                triversal(tri);
//            }
//            if (x.getRight() != null) {
//                triversal(x.getRight());
//            }
//        }
//        if (al.contains(x.getLeft())) {
//            triversal(x.getRight());
//        }
//        if (x.getLeft() != null) {
//            triversal(x.getLeft());
//        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        In in = new In(args[0]);

        String inorder = in.readLine();
//        String[] inorder1 = inorder.split(" ");
        String preorder = in.readLine();
//        String[] preorder1 = preorder.split(" ");
        Node x = BTrebuild(inorder, preorder);
        triversal(x);
    }

}

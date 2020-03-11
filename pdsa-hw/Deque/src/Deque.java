/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// using link list is more easy**
//creat node function
/**
 *
 * @author don
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    Node head = new Node();
    Node last = new Node();
    int size = 0;

    private class Node {

        Item item;
        Node next;
        Node pre;
    }

    public Deque() {
        head = last;
        int size = 0;
    }// construct an empty deque

    public boolean isEmpty() {
        return size == 0;
    } // is the deque empty?

    public int size() {
        return size;
    }// return the number of items on the deque

    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (size == 0) {
            head.item = item;
            size++;
        } else {
            Node hold = head;
            head = new Node();
            head.item = item;
            head.next = hold;
            hold.pre = head;
            size++;
        }
    } // add the item to the front

    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (size == 0) {
            last.item = item;
            size++;
        } else {
            Node hold = new Node();
            hold = last;
            last = new Node();
            last.item = item;
            hold.next = last;
            last.pre = hold;
            size++;
        }
    } // add the item to the end

    public Item removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Item item = head.item;
        if (head.next == null) {
            head.item = null;
            last.item = null;
            head = last;
            size--;
            return item;
        } else {
            head = head.next;
            head.pre = null;
            size--;
            return item;
        }
    } // remove and return the item from the front

    public Item removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Item item = last.item;
        if (last.pre == null) {
            head.item = null;
            last.item = null;
            head = last;
            size--;
            return item;
        } else {
            last = last.pre;
            last.next = null;
            size--;
            return item;
        }
    } // remove and return the item from the end

    private class ListIterator implements Iterator<Item> {

        private Node current = head;

        public boolean hasNext() {
            return current != null && current.item != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (current == null || current.item == null) {
                throw new NoSuchElementException();
            } else {
                Item item = current.item;
                current = current.next;
                return item;
            }
        }
    }

    public Iterator iterator() {
        return new ListIterator();
    }

    // return an iterator over items in order from front to end
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Deque<Integer> aaa = new Deque<Integer>();
//        aaa.iterator().next();
//        boolean y = aaa.iterator().hasNext();
//        aaa.addFirst("d");
//        aaa.addLast("a");
//        aaa.addFirst("d");
//        aaa.addLast("b");
//        aaa.addFirst("c");
//        aaa.addLast("c");
//        aaa.addFirst("b");
//        aaa.addLast("d");
//        aaa.removeFirst();
//        aaa.removeFirst();
//        aaa.removeFirst();
//        aaa.removeFirst();
//        aaa.removeFirst();
//        aaa.removeLast();
//        aaa.removeLast();
//        aaa.removeLast();
//        aaa.addLast(123);
//        aaa.addLast(654);
//        aaa.addFirst(789);
//        aaa.addFirst(456);
//        aaa
//        aaa.removeFirst();
//        aaa.removeFirst();
//        aaa.removeLast();
//        aaa.removeLast();
//        Iterator k = aaa.iterator();
//        while (k.hasNext()) {
//            Object kkk = k.next();
//            StdOut.println(kkk);
//        }
//        StdOut.println("queue head = " + aaa.head.item + " head.next = " + aaa.head.next.item + " head.pre = " + aaa.head.pre);
//        while (k.hasNext()) {
//            k.next();
//            aaa.head = aaa.head.next;
//            StdOut.println("queue = " + aaa.head.item + " next = " + aaa.head.next.item + " pre = " + aaa.head.pre.item);
//        }
    }
}

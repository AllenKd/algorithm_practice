/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Comparator;

/**
 *
 * @author 1032-pdsa
 */
public class Card implements Comparable<Card> {

    private String face;
    private String suit;

    public static final Comparator<Card> SUIT_ORDER = new SuitOrder();

    public Card(String face, String suit) {
        this.face = face;
        this.suit = suit;
    }

    public String getFace() {
        return this.face;
    }

    public String getSuit() {
        return this.suit;
    }

    public int compareTo(Card that) {
        /* implement this function such that Cards can be sorted according to the face
         if () return -1;
         if () return +1;
         */
        ST<String, Integer> facetonumber = new ST<String, Integer>();
        facetonumber.put("A", 14);
        for (int i = 2; i < 11; i++) {
            facetonumber.put(String.valueOf(i), i);
        }
        facetonumber.put("J", 11);
        facetonumber.put("Q", 12);
        facetonumber.put("K", 13);
        if (facetonumber.get(this.face) > facetonumber.get(that.face)) {
            return 1;
        } else if (facetonumber.get(this.face) < facetonumber.get(that.face)) {
            return -1;
        } else {
            ST<String, Integer> suittonumber = new ST<String, Integer>();
            suittonumber.put("Spades", 4);
            suittonumber.put("Hearts", 3);
            suittonumber.put("Diamonds", 2);
            suittonumber.put("Clubs", 1);
            if (suittonumber.get(this.suit) > suittonumber.get(that.suit)) {
                return 1;
            } else if (suittonumber.get(this.suit) < suittonumber.get(that.suit)) {
                return -1;
            }
        }
        return 0;
    }

    private static class SuitOrder implements Comparator<Card> {

        public int compare(Card c1, Card c2) {
            /* implement this function such that Cards can be sorted according to the suit
             if () return -1;
             if () return +1;
             */
            ST<String, Integer> suittonumber = new ST<String, Integer>();
            suittonumber.put("Spades", 4);
            suittonumber.put("Hearts", 3);
            suittonumber.put("Diamonds", 2);
            suittonumber.put("Clubs", 1);
            if (suittonumber.get(c1.getSuit()) > suittonumber.get(c2.getSuit())) {
                return 1;
            } else if (suittonumber.get(c1.getSuit()) < suittonumber.get(c2.getSuit())) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}

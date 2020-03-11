
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 1032-pdsa
 */
public class Player implements Comparable<Player> {

    private Card[] cards = new Card[5];
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public int compareTo(Player that) {

        /* implement this function such that Players can be sorted according to the poker hand they have
         
         if () return -1;
         if () return +1;
         */
        int playervalue = 0, playervalue1 = 0;
        ST<String, Integer> st = new ST<String, Integer>();
        ST<String, Integer> st1 = new ST<String, Integer>();
        ST<String, Integer> facetonumber = new ST<String, Integer>();
        facetonumber.put("A", 14);
        for (int i = 2; i < 11; i++) {
            facetonumber.put(String.valueOf(i), i);
        }
        facetonumber.put("J", 11);
        facetonumber.put("Q", 12);
        facetonumber.put("K", 13);
        ST<String, Integer> suittonumber = new ST<String, Integer>();
        suittonumber.put("Spades", 4);
        suittonumber.put("Hearts", 3);
        suittonumber.put("Diamonds", 2);
        suittonumber.put("Clubs", 1);
        int[] numbers = new int[5];
        int[] suitvalue = new int[5];
        int[] numbers1 = new int[5];
        int[] suitvalue1 = new int[5];
        int k = 0;
        int k1 = 0;
        String hold = "";
        String hold1 = "";
        int opk = 0;
        int opk1 = 0;
        String opksuit;
        String opksuit1;
        int fhkey = 0;
        int fhkey1 = 0;
        int fkey = 0;
        int fkey1 = 0;
        for (int i = 0; i < 5; i++) {
            switch (cards[i].getFace()) {//prepare for straight
                case "J":
                    numbers[i] = 11;
                    suitvalue[i] = numbers[i];
                    break;
                case "Q":
                    numbers[i] = 12;
                    suitvalue[i] = numbers[i];
                    break;
                case "K":
                    numbers[i] = 13;
                    suitvalue[i] = numbers[i];
                    break;
                case "A":
                    numbers[i] = 1;
                    suitvalue[i] = numbers[i];
                    break;
                default:
                    numbers[i] = Integer.valueOf(cards[i].getFace());
                    suitvalue[i] = numbers[i];
            }
            switch (that.cards[i].getFace()) {//prepare for straight *
                case "J":
                    numbers1[i] = 11;
                    suitvalue1[i] = numbers[i];
                    break;
                case "Q":
                    numbers1[i] = 12;
                    suitvalue1[i] = numbers[i];
                    break;
                case "K":
                    numbers1[i] = 13;
                    suitvalue1[i] = numbers[i];
                    break;
                case "A":
                    numbers1[i] = 1;
                    suitvalue1[i] = numbers[i];
                    break;
                default:
                    numbers1[i] = Integer.valueOf(that.cards[i].getFace());
                    suitvalue1[i] = numbers[i];
            }
            String face = cards[i].getFace();//stroe same number to st
            String face1 = that.cards[i].getFace();
            if (st.contains(face)) {
                st.put(face, st.get(face) + 1);
            } else {
                st.put(face, 1);
            }
            if (st.get(face) == 3) {
                fhkey = Integer.valueOf(facetonumber.get(face));    //got fhkey;
            }
            if (st1.contains(face1)) {
                st1.put(face1, st1.get(face1) + 1);
            } else {
                st1.put(face1, 1);
            }
            if (st1.get(face1) == 3) {
                fhkey1 = Integer.valueOf(facetonumber.get(face1));  //got fhkey1 *
            }
            String divideface = cards[i].getSuit();//determine flush
            if (hold.equals(divideface)) {
                k++;
            }
            hold = divideface;
            String divideface1 = that.cards[i].getSuit();//determine flush *
            if (hold1.equals(divideface1)) {
                k1++;
            }
            hold1 = divideface1;

        }
        fkey = facetonumber.get(cards[0].getFace());
        int suitf = suittonumber.get(cards[0].getSuit());
        for (int j = 1; j < 5; j++) {       //find max number of cards
            if (fkey == 1) {
                fkey = 14;
                break;
            }
            if (facetonumber.get(cards[j].getFace()) == 1 || fkey == 1) {
                fkey = 14;
                suitf = suittonumber.get(cards[j].getSuit());
                break;
            }
            if (fkey < facetonumber.get(cards[j].getFace())) {
                fkey = facetonumber.get(cards[j].getFace());
                suitf = suittonumber.get(cards[j].getSuit());
            }
        }
        fkey1 = facetonumber.get(that.cards[0].getFace());
        int suitf1 = suittonumber.get(that.cards[0].getSuit());
        for (int j = 1; j < 5; j++) {       //find max number of cards *
            if (fkey1 == 1) {
                fkey1 = 14;
                break;
            }
            if (facetonumber.get(that.cards[j].getFace()) == 1) {
                fkey1 = 14;
                suitf1 = suittonumber.get(that.cards[j].getSuit());
                break;
            }
            if (fkey1 < facetonumber.get(that.cards[j].getFace())) {
                fkey1 = facetonumber.get(that.cards[j].getFace());
                suitf1 = suittonumber.get(that.cards[j].getSuit());
            }
        }

        while (true) {//player value
            if (st.size() == 2) {//full house
                playervalue = 750 + fhkey * 10;
                break;
            }
            if (k == 4) {//flush
                playervalue = 600 + fkey * 10 + suitf;
                break;
            }
            Arrays.sort(numbers);
            if (st.size() == 5 && ((numbers[4] - numbers[0]) == 4 || (numbers[4] - numbers[0]) == 12)) {//straight
                int sum = 0;
                for (int i = 0; i < 5; i++) {//find suit of max number of straight
                    sum += numbers[i];
                }
                int max = Integer.valueOf(facetonumber.get(cards[0].getFace()));
                int j = 0;
                for (int i = 1; i < 5; i++) {       //find value of suit of max number
                    if (max < Integer.valueOf(facetonumber.get(cards[i].getFace()))) {
                        max = facetonumber.get(cards[i].getFace());
                        j = i;
                    }
                }
                if (sum % 5 == 0) {
                    playervalue = 450 + sum / 5 + suittonumber.get(cards[j].getSuit());
                    break;
                } else {
                    playervalue = 450 + suittonumber.get(cards[j].getSuit());
                    break;
                }

            } else if (st.size() == 5) {
                playervalue = fkey * 5 + suitf;//high card
                break;
            }
            if (st.size() == 3) {//two pair

//                for (String opkey : st.keys()) {
//                    if (st.get(opkey) != 2) {
//                        st.delete(opkey);
//                    }
//                }
                int max = 0;
                int suitvalueofmaxpair = 0;
                for (String findmax : st.keys()) {    //find max pair
                    if (max < facetonumber.get(findmax) && st.get(findmax) == 2) {
                        max = facetonumber.get(findmax);
                        for (int i = 0; i < 5; i++) {   //find suit value of max pair
                            if (cards[i].getFace() == findmax) {
                                if (suitvalueofmaxpair < suittonumber.get(cards[i].getSuit())) {
                                    suitvalueofmaxpair = suittonumber.get(cards[i].getSuit());
                                }
                            }
                        }
                    }
                }
                playervalue = 300 + max * 10 + suitvalueofmaxpair;
                break;
            }
            String pair = "";
            if (st.size() == 4) {//one pair
                for (String opkey : st.keys()) {
                    if (st.get(opkey) == 2) {
                        pair = opkey;
                    }
                }
                int suitvalueofmaxpair = 0;
                int fix = 0;
                for (int i = 0; i < 5; i++) {   //find suit value of pair
                    if (that.cards[i].getFace() == pair) {
                        if (suitvalueofmaxpair < suittonumber.get(cards[i].getSuit())) {
                            suitvalueofmaxpair = suittonumber.get(cards[i].getSuit());
                        }
                    }
                    if (suitvalueofmaxpair == 0) {
                        suitvalueofmaxpair = fix;
                    }
                }
                playervalue = 150 + facetonumber.get(pair) * 10 + suitvalueofmaxpair;
                break;
            }
        }
        while (true) {//player value

            if (st1.size() == 2) {//full house *
                playervalue1 = 750 + fhkey1 * 10;
                break;
            }

            if (k1 == 4) {//flush *
                playervalue1 = 600 + fkey * 10;
                break;
            }
            Arrays.sort(numbers1);
            if (st1.size() == 5 && ((numbers1[4] - numbers1[0]) == 4 || (numbers1[4] - numbers1[0]) == 12)) {//straight *
                int sum = 0;
                for (int i = 0; i < 5; i++) {//find suit of max number of straight *
                    sum += numbers1[i];
                }
                int max = Integer.valueOf(facetonumber.get(that.cards[0].getFace()));
                int j = 0;
                for (int i = 0; i < 5; i++) {       //find value of suit of max number
                    if (max < Integer.valueOf(facetonumber.get(that.cards[i].getFace()))) {
                        max = Integer.valueOf(facetonumber.get(that.cards[i].getFace()));
                        j = i;
                    }
                }
                if (sum % 5 == 0) {
                    playervalue1 = 450 + sum / 5 + suittonumber.get(that.cards[j].getSuit());
                    break;
                } else {
                    playervalue1 = 450 + suittonumber.get(that.cards[j].getSuit());
                    break;
                }
            } else if (st1.size() == 5) {
                playervalue1 = fkey1 * 5 + suitf1;//high card *
                break;
            }

            if (st1.size() == 3) {//two pair *
//                for (String opkey : st1.keys()) {
//                    if (st1.get(opkey) != 2) {
//                        st1.delete(opkey);
//                    }
//                }
                int max = 0;
                int suitvalueofmaxpair = 0;
                for (String findmax : st1.keys()) {    //find max pair *
                    if (max < facetonumber.get(findmax) && st1.get(findmax) == 2) {
                        max = facetonumber.get(findmax);
                        for (int i = 0; i < 5; i++) {   //find suit value of max pair *
                            if (that.cards[i].getFace() == findmax) {
                                if (suitvalueofmaxpair < suittonumber.get(that.cards[i].getSuit())) {
                                    suitvalueofmaxpair = suittonumber.get(that.cards[i].getSuit());
                                }
                            }
                        }
                    }
                }
                playervalue1 = 300 + max * 10 + suitvalueofmaxpair;
                break;
            }

            if (st1.size() == 4) {//one pair *
                String pair = "";
                for (String opkey : st1.keys()) {
                    if (st1.get(opkey) == 2) {
                        pair = opkey;
                    }
                }
                int suitvalueofmaxpair = 0;
                int fix = 0;
                for (int i = 0; i < 5; i++) {   //find suit value of pair
                    if (that.cards[i].getFace() == pair) {
                        fix = suittonumber.get(that.cards[i].getSuit());
                        if (suitvalueofmaxpair < suittonumber.get(that.cards[i].getSuit())) {
                            suitvalueofmaxpair = suittonumber.get(that.cards[i].getSuit());
                        }
                    }
                    if (suitvalueofmaxpair == 0) {
                        suitvalueofmaxpair = fix;
                    }
                }

                playervalue1 = 150 + facetonumber.get(pair) * 10 + suitvalueofmaxpair;
                break;
            }

        }
        StdOut.println(this.name + " value = " + playervalue);
        StdOut.println(that.name + " value = " + playervalue1);
        if (playervalue > playervalue1) {//determine win or lose
            return 1;
        } else if (playervalue < playervalue1) {
            return -1;
        }
        return 0;
    }
}

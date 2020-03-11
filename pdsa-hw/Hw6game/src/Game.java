
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 1032-pdsa
 */
public class Game {

    public static void main(String[] args) {
        In in = new In(args[0]); // open the input file

        // read in the number of players (same as HW1)
        int players = in.readInt();
        // issue the cards to the players (same as HW1)
        ArrayList playerlist = new ArrayList();
        ArrayList cards = new ArrayList();
        for (int i = 0; i < 2 * players; i++) {
            String store = in.readString();
            if (i % 2 == 0) {
                playerlist.add(store);
                continue;
            }
            cards.add(store);
        }
        //testing bug for random
        int n = 4;
        ArrayList randomtest = new ArrayList();
        Card[] randomcard = new Card[52];
        ST<Integer, String> suittonumber = new ST<Integer, String>();
        suittonumber.put(4, "Spades");
        suittonumber.put(3, "Hearts");
        suittonumber.put(2, "Diamonds");
        suittonumber.put(1, "Clubs");
        ST<Integer, String> facetonumber = new ST<Integer, String>();
        facetonumber.put(1, "A");
        for (int i = 2; i < 11; i++) {
            facetonumber.put(i, String.valueOf(i));
        }
        facetonumber.put(11, "J");
        facetonumber.put(12, "Q");
        facetonumber.put(13, "K");
        double[] x = new double[n];
        double[] y = new double[n];
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                randomcard[4 * i + j] = new Card(facetonumber.get(i + 1), suittonumber.get(j + 1));
            }
//            x[i] = StdRandom.uniform();
//            y[i] = StdRandom.uniform();
//            a[i] = new Point2D(x[i], y[i]);
        }
        
        Card[] issuecards2 = new Card[5];
        Player[] eachplayer = new Player[players];

        for (int i = 0; i < players; i++) {
            String transplayer = String.valueOf(playerlist.get(i));
            eachplayer[i] = new Player(transplayer);
            StdOut.println("player "+transplayer);
            Card[] issuecards1 = new Card[5];
            for (int j = 0; j < 5; j++) {
                
                issuecards1[j] = new Card(facetonumber.get(StdRandom.uniform(12)+1),suittonumber.get(StdRandom.uniform(3)+1));
                StdOut.println("card "+issuecards1[j].getFace()+" "+issuecards1[j].getSuit());
            }
            eachplayer[i].setCards(issuecards1);
            StdOut.println();
        }
        //end testing
//        Player[] eachplayer = new Player[players];
//        for (int i = 0; i < players; i++) {
//            String hold = "";
//            int k = 0;
//            ArrayList storecard = new ArrayList();
//            Card[] issuecards = new Card[5];
//            String transfer = String.valueOf(cards.get(i));
//            String transplayer = String.valueOf(playerlist.get(i));
//            String[] dividecards = transfer.split(",");
//            eachplayer[i] = new Player(transplayer);
//            for (int j = 0; j < 5; j++) {
//                String[] divideface = dividecards[j].split("_");
//                issuecards[j] = new Card(divideface[1], divideface[0]);
//            }
//            eachplayer[i].setCards(issuecards);
        // determine the best hand a player has

        // print out the name of the player with the best poker hand
//    }
        int k = 0;
        for (int i = 1; i < players; i++) {
            if (eachplayer[k].compareTo(eachplayer[i]) == 1) {
                continue;
            } else {
                k = i;
            }
        }
        StdOut.print(eachplayer[k].getName());
    }
}

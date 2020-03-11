/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author 1032-pdsa
 */
public class Game {

    public static void main(String[] args) {
        In in = new In(args[0]); // open the input file

        int players = in.readInt();

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

        for (int i = 0; i < players; i++) {
            String hold = "";
            int k = 0;
            ArrayList storecard = new ArrayList();
            ArrayList issuecards = new ArrayList();
            String transfer = String.valueOf(cards.get(i));
            String transplayer = String.valueOf(playerlist.get(i));
            String[] dividecards = transfer.split(",");
            Player eachplayer = new Player(transplayer);
            for (int j = 0; j < 5; j++) {
                String[] divideface = dividecards[j].split("_");
                Card eachcard = new Card(divideface[0], divideface[1]);
                issuecards.add(eachcard);
                if (hold.equals(eachcard.getFace())) {
                    k++;
                    continue;
                }
                hold = eachcard.getFace();
            }
            eachplayer.setCards(issuecards);
//            if (k == 4) {
            StdOut.println(eachplayer.Flush());
//            }
        }
    }
}

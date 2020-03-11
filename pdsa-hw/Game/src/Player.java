/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author 1032-pdsa
 */
class Player {

    private ArrayList<Card> cards = new ArrayList<Card>();
    private String name;

    public Player(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public boolean Flush() {
        boolean flag = false;
        int k = 0;
        String hold = "";
        for (int i = 0; i < 5; i++) {
            String divideface1 = cards.get(i).getSuit();
            if (hold.equals(divideface1)) {
                k++;
                continue;
            }
            hold = divideface1;
        }
        if (k == 4) {
            flag = true;
        }
        return flag;
    }
}

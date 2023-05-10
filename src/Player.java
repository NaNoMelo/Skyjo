package src;
import java.io.*;
import java.util.LinkedList;
public class Player {
    // create array of players
        private String name;
        private int turn;
        private LinkedList<Card> hand = new LinkedList<Card>();
        private int score;

        public void setHand(LinkedList<Card> deck) {
            //create a hand of 12 random card from the deck and delete the card from the deck, representing all the UV the player will choose during the two year of commun course
            for (int i = 0; i < 12; i++) {
                int random = (int) (Math.random() * deck.size());
                hand.add(deck.get(random));
                deck.remove(random);
                }
            }

        public LinkedList<Card> getHand() {
            return hand;
        }
        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public int getTurn() {
            return turn;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public void setTurn(int turn) {
            this.turn = turn;
        }

        public void printHand() {
            for (int i = 0; i < hand.size(); i++) {
                System.out.println(hand.get(i).getUV() + " " + hand.get(i).getMark() + " " + hand.get(i).getType());
            }
        }

}

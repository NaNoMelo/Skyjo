package src;
import java.io.*;
import java.util.LinkedList;
public class Player {
    // create array of players
        private String name;
        private int turn;
        private LinkedList<SkyjjoDeck.card> hand = new LinkedList<SkyjjoDeck.card>();
        private int score;

        public void setHand(LinkedList<SkyjjoDeck.card> deck) {
            //create a hand of 5 random card from the deck and delete the card from the deck
            for (int i = 0; i < 5; i++) {
                int random = (int) (Math.random() * deck.size());
                hand.add(deck.get(random));
                deck.remove(random);
            }
        }
        public LinkedList<SkyjjoDeck.card> getHand() {
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

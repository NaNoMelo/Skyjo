package src;
import java.io.*;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class main {
    public static void main(String[] args) throws IOException {
        //create a deck
        SkyjjoDeck deck = new SkyjjoDeck();
        deck.createDeck(1);
        //create an array of players
        Player[] players = new Player[4];
        for (int i = 0; i < 4; i++) {
            players[i] = new Player();
            players[i].setHand(deck.deck);
            players[i].setName("Player " + (i + 1));
            players[i].setTurn(i + 1);
            players[i].setScore(0);
        }
        //print the hand of each player
        for (int i = 0; i < 4; i++) {
            System.out.println(players[i].getName());
            players[i].printHand();
            System.out.println();
        }
        //show the start menu
        GameLauncher.start_up_menu(args);

    }
}

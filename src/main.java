package src;

import java.io.IOException;

public class main {
    public static void main(String[] args) {
        //start the game
        Launcher_UI launcher = new Launcher_UI();
        launcher.start_up();
        //dont do anything until a button is pressed
        while (!launcher.isclicked) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (launcher.gameStatus) {
            System.out.println("Game is running");
            //start the menu
            launcher.menu();
            launcher.isclicked= false;

            //dont do anything until a button is pressed
            while (!launcher.isclicked) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //create the players
            Player[] players = new Player[launcher.nbPlayers];
            for (int i = 0; i < launcher.nbPlayers; i++) {
                players[i] = new Player();
            }

            //create the deck
            SkyjjoDeck deck = new SkyjjoDeck();
            try {
                deck.createDeck();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //print the number of players
            System.out.println("Number of players: " + launcher.nbPlayers);

            //print the players
            for (int i = 0; i < launcher.nbPlayers; i++) {
                System.out.println("Player " + (i + 1) + ": " + players[i].getName());
            }
            // set the hand of each player
            for (int i = 0; i < launcher.nbPlayers; i++) {
                players[i].setHand(deck.getDeck());
            }
            //print hand of each player
            for (int i = 0; i < launcher.nbPlayers; i++) {
                System.out.println("Player " + (i + 1) + " hand: ");
                players[i].printHand();
            }
        } else {
            System.out.println("Game is over");
        }
    }
}
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

            //create game
            Game game = new Game();

            //create the deck
            SkyjjoDeck deck = new SkyjjoDeck();
            try {
                deck.createDeck();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //print the deck
            deck.printDeck();

            //create the players
            Player[] players = new Player[launcher.nbPlayers];
            for (int i = 0; i < launcher.nbPlayers; i++) {
                players[i] = new Player();
            }

            //set the players name
            for (int i = 0; i < launcher.nbPlayers; i++) {
                players[i].setName("Player " + (i + 1));
            }

            //set the players hand
            for (int i = 0; i < launcher.nbPlayers; i++) {
                players[i].setHand(deck.getDeck());
            }

            //print the players hand
            for (int i = 0; i < launcher.nbPlayers; i++) {
                System.out.println(players[i].getName() + " hand: " );
                players[i].printHand();
            }

            //initialize the board
            launcher.board(players);

            //dont do anything until a button is pressed
            while (!launcher.isclicked) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Game is over");
        }
    }
}
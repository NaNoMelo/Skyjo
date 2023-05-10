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
            launcher.isclicked = false;
            //dont do anything until a button is pressed
            while (!launcher.isclicked) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            launcher.isclicked = false;

            //create game
            Game game = new Game();

            //create the deck
            SkyjjoDeck deck = new SkyjjoDeck();
            try {
                //create the deck
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
                System.out.println(players[i].getName() + " hand: ");
                players[i].printHand();
                //jump a line

            }

            //initialize the board
            launcher.board_initialisation(players);

            //dont do anything until a button is pressed
            while (!launcher.isclicked) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //print the card on the board
            Rule rule = new Rule();
            launcher.isclicked = false;
            while (!rule.isRespectRule()) {
                rule.firstround(launcher.card, players[0], 1);
                if (rule.isRespectRule()) {
                    System.out.println("You can play this card");
                } else {
                    System.out.println("You can't play this card");
                    launcher.board_initialisation(players);
                }
            }
        }

        else{
                System.out.println("Game is over");
            }

    }
}

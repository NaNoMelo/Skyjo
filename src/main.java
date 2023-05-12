package src;

import java.io.IOException;


public class main {
    public static void main(String[] args) {
        //start the game
        Game game = new Game();
        Launcher launcher = new Launcher();
        launcher.start_up();
        Rule rule = new Rule();


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
            launcher.menu(game);
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
            game.setNbPlayers(launcher.nbPlayers);

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
            game.setPlayers(players);


            //create the board
            Board board = new Board();

            //print the players hand from game
            for (int i = 0; i < game.getNbPlayers(); i++) {
                System.out.println(game.getPlayers()[i].getName());
                game.getPlayers()[i].printHand();
            }
            game.setTurn(0);
            launcher.isclicked= false;

                pop_up pop_up = new pop_up();
                pop_up.indication("Chaque joueur doit choisir deux cartes.");
            board.show_board(game);

                //ask the players to choose two cards
                for (int i = 0; i < game.getNbPlayers(); i++) {
                    for (int j = 0; j < 2; j++) {
                        board.isclicked = false;
                        game.setTurn(i);
                        while (!board.isclicked) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }


                        //set the score of the card
                        board.getCard().setScore();


                        //add the score to the player
                        game.getPlayers()[i].setScore(game.getPlayers()[i].getScore() + board.getCard().getScore());
                        board.isclicked= false;
                        board.updateBoard(game);
                    }
                }
                //pop up to show the score of each player
                pop_up.indication("Voici les scores des joueurs :");
                for (int i = 0; i < game.getNbPlayers(); i++) {
                    System.out.println(game.getPlayers()[i].getName() + " " + game.getPlayers()[i].getScore());
                }

                //player with the lowest score start the game
                int min = game.getPlayers()[0].getScore();
                int firstPlayer = 0;
                for (int i = 0; i < game.getNbPlayers(); i++) {
                    if (game.getPlayers()[i].getScore() < min) {
                        min = game.getPlayers()[i].getScore();
                        firstPlayer = i;
                    }
                }
                game.setTurn(firstPlayer);
                //if index = nbPlayers then return to the first player
                if (firstPlayer == game.getNbPlayers()) {
                    game.setTurn(0);
                }

                SkyjjoDeck draftDeck = deck;
                

                //The game starts now


        } else {
            System.out.println("Game is over");
        }
    }
}
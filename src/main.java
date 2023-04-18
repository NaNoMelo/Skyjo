package src;

public class main {
    public static void main(String[] args) {
    //start the game
    Launcher_UI launcher = new Launcher_UI();
    launcher.launcher();
    //if gameStatus is true start the game
        if (launcher.gameStatus=true) {
            Game game = new Game();
            game.setGameStatus(true);
            //create a deck
            SkyjjoDeck deck = new SkyjjoDeck();
            //open the menu
            launcher.menu();
        }
        else {
            System.out.println("Game is over");
            System.exit(0);
        }
    }
}

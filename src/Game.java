package src;
import javax.swing.*;
import java.awt.event.*;

public class Game extends Player {
    private int round;
    private int turn;
    private boolean gameStatus;
    private Player[] players;
    private SkyjjoDeck deck;
    private int nmbrOfPlayers;
    private boolean isclicked = false;
    private JFrame frame;

    public void setRound(int round){
        this.round = round;
    }
    public void setTurn(int turn){
        this.turn = turn;
    }
    public void setGameStatus(boolean gameStatus){
        this.gameStatus = gameStatus;
    }
    public void setPlayers(Player[] players){
        this.players = players;
    }
    public int getRound(){
        return round;
    }
    public int getTurn(){
        return turn;
    }
    public boolean getGameStatus(){
        return gameStatus;
    }
    public Player[] getPlayers(){
        return players;
    }
    public void setNbPlayers(int nbPlayers){
        this.nmbrOfPlayers = nbPlayers;
    }
    public int getNbPlayers(){
        return nmbrOfPlayers;
    }
    public boolean getIsclicked(){
        return isclicked;
    }
    public void setIsclicked(boolean isclicked){
        this.isclicked = isclicked;
    }
    public JFrame getFrame(){
        return frame;
    }
    public void setFrame(JFrame frame){
        this.frame = frame;
    }




}


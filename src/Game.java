package src;
import javax.swing.*;
import java.awt.event.*;

public class Game{
    private int round;
    private int turn;
    private boolean gameStatus;
    private Player[] players;
    private SkyjjoDeck deck;
    private int nmbrOfPlayers;

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
    public void setDeck(SkyjjoDeck deck){
        this.deck = deck;
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
    public SkyjjoDeck getDeck(){
        return deck;
    }
    public void setNbPlayers(int nbPlayers){
        this.nmbrOfPlayers = nbPlayers;
    }
    public int getNbPlayers(){
        return nmbrOfPlayers;
    }



}


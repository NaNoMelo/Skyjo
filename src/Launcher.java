package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.LinkedList;

public class Launcher extends JFrame {
    public boolean gameStatus = false;
    public boolean isclicked = false;
    int nbPlayers;
    private JFrame frame;
    // create a startup frame, a button start and a button exit, changing gameStatus to true or false
    public void start_up() {
        frame = new JFrame("Skyjjo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JButton start = new JButton("Start");
        JButton exit = new JButton("Exit");

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameStatus = true;
                isclicked = true;
                frame.dispose();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameStatus = false;
                isclicked = true;
                frame.dispose();
            }
        });

        frame.add(start);
        frame.add(exit);
        frame.setVisible(true);
    }

    // create a menu frame, a entering integer field, a validation button and a button exit
    public void menu(Game game) {
        frame = new JFrame("Skyjjo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JLabel label = new JLabel("Enter the number of players: ");
        JTextField field = new JTextField(10);
        JButton validate = new JButton("Validate");
        JButton exit = new JButton("Exit");

        validate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nbPlayers = Integer.parseInt(field.getText());
                if (nbPlayers > 0 && nbPlayers < 9) {
                    System.out.println("Number of players is valid");
                    game.setGameStatus(true);
                    game.setNbPlayers(nbPlayers);
                    isclicked = true;
                    frame.dispose();
                } else {
                    System.out.println("Number of players is invalid");
                }
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameStatus = false;
                isclicked = true;
                frame.dispose();
            }
        });

        frame.add(label);
        frame.add(field);
        frame.add(validate);
        frame.add(exit);
        frame.setVisible(true);
    }

    //create a board frame, a button exit

    //getter for the card


}


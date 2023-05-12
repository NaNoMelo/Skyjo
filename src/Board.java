package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JFrame{
    private JFrame frame;
    public boolean isclicked = false;
    private Card card = new Card();


    public void show_board(Game game) {
        frame = new JFrame("Skyjjo Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //frame is in full screen
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());

        // background is png adjusted to the size of the frame
        ImageIcon background = new ImageIcon("C:\\Users\\axela\\IdeaProjects\\Skyjo\\fond.png");

        //adjust the size of the background
        Image img = background.getImage();
        Image newimg = img.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        background = new ImageIcon(newimg);
        //add the background to the frame
        frame.setContentPane(new JLabel(background));
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        //create a panel for each player
        JPanel[] panels = new JPanel[game.getNbPlayers()];
        for (int i = 0; i < game.getNbPlayers(); i++) {
            panels[i] = new JPanel();
            //add the name of the player
            panels[i].add(new JLabel(game.getPlayers()[i].getName()));
            //return to the line
            panels[i].add(new JLabel("  "));
            panels[i].add(new JLabel("  "));
            panels[i].add(new JLabel("  "));

            panels[i].setPreferredSize(new Dimension(300, 300)); //adjust the size as needed
            panels[i].setLayout(new FlowLayout());
            //dispose a grid
            panels[i].setLayout(new GridLayout(4, 3));
            //transparent background
            panels[i].setOpaque(false);
            frame.add(panels[i]);
        }


        //add in each panel as many buttons as there are cards in the hand of the player
        JButton[][] buttons = new JButton[game.getNbPlayers()][game.getPlayers()[0].getHand().size()];
        for (int i = 0; i < game.getNbPlayers(); i++) {
            for (int j = 0; j < game.getPlayers()[0].getHand().size(); j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setPreferredSize(new Dimension(100, 150)); //adjust the size as needed
                //write the value of the card on the button
                buttons[i][j].setText(String.valueOf(game.getPlayers()[i].getHand().get(j).getUV()));
                //set foreground color to transparent
                if (game.getPlayers()[i].getHand().get(j).isIsrevealed()){
                    buttons[i][j].setForeground(Color.green);
                } else {
                    //transparent foreground
                    buttons[i][j].setForeground(new Color(0, 0, 0, 0));
                }
                panels[i].add(buttons[i][j]);
            }
        }


        //create a button exit
        JButton exit = new JButton("Exit");
        exit.setPreferredSize(new Dimension(100, 50));

        JPanel exitPanel = new JPanel();
        exitPanel.setLayout(new BorderLayout());
        exitPanel.setPreferredSize(new Dimension(100, 50)); //adjust the size as needed
        frame.add(exit, BorderLayout.CENTER);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isclicked = true;
                frame.dispose();
            }
        });
        //add a button in which the rest of the deck will be displayed
        JButton deck = new JButton("Pioche");
        deck.setPreferredSize(new Dimension(100, 50));
        frame.add(deck, BorderLayout.CENTER);

        //add a button in which the discard pile will be displayed
        JButton discard = new JButton("Défausse");
        discard.setPreferredSize(new Dimension(100, 50));
        frame.add(discard, BorderLayout.CENTER);

        //add event listener for each button
        for (int i = 0; i < game.getNbPlayers(); i++) {
            for (int j = 0; j < game.getPlayers()[0].getHand().size(); j++) {
                int finalI = i;
                int finalJ = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        //select which card has been clicked
                        card = game.getPlayers()[finalI].getHand().get(finalJ);

                        //check if the card belongs to the player whose turn it is
                        if (game.getPlayers()[game.getTurn()].getHand().contains(card)) {
                            System.out.println("Card selected: " + card.getUV());
                            isclicked = true;
                            card.setIsrevealed(true);
                        } else {
                            System.out.println("Card not selected");
                        }
                    }
                });
            }
        }
        frame.setVisible(true);
    }
    public void updateBoard(Game game) {
        JButton[][] buttons = new JButton[game.getNbPlayers()][game.getPlayers()[0].getHand().size()];
        for (int i = 0; i < game.getNbPlayers(); i++) {
            for (int j = 0; j < game.getPlayers()[0].getHand().size(); j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setPreferredSize(new Dimension(100, 150)); //adjust the size as needed
                //write the value of the card on the button
                buttons[i][j].setText(String.valueOf(game.getPlayers()[i].getHand().get(j).getUV()));
                //set foreground color to transparent
                if (game.getPlayers()[i].getHand().get(j).isIsrevealed()){
                    buttons[i][j].setForeground(Color.green);
                } else {
                    //transparent foreground
                    buttons[i][j].setForeground(new Color(0, 0, 0, 0));
                }
            }
        }
        frame.revalidate();
        frame.repaint();
    }

    public Card getCard() {
        return card;
    }
}

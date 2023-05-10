    package src;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.io.*;
    import java.util.LinkedList;

    public class Launcher_UI extends JFrame {
        public boolean gameStatus = false;
        public boolean isclicked = false;
        int nbPlayers;
        private JFrame frame;
        Card card = new Card();
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
        public void menu() {
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
                        gameStatus = true;
                        nbPlayers = Integer.parseInt(field.getText());
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
        public void board_initialisation(Player[] players) {
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
            JPanel[] panels = new JPanel[players.length];
            for (int i = 0; i < players.length; i++) {
                panels[i] = new JPanel();
                //add the name of the player
                panels[i].add(new JLabel(players[i].getName()));
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
            JButton[][] buttons = new JButton[players.length][players[0].getHand().size()];
            for (int i = 0; i < players.length; i++) {
                for (int j = 0; j < players[i].getHand().size(); j++) {
                    buttons[i][j] = new JButton(players[i].getHand().get(j).getUV());
                    // set the size of the button
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
                    gameStatus = false;
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
            for (int i = 0; i < players.length; i++) {
                for (int j = 0; j < players[i].getHand().size(); j++) {
                    int finalI = i;
                    int finalJ = j;
                    buttons[i][j].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            isclicked = true;
                            //look for the card in the hand of the player
                            for (int k = 0; k < players[finalI].getHand().size(); k++) {
                                if (players[finalI].getHand().get(k).getUV().equals(buttons[finalI][finalJ].getText())) {
                                    //if the card is found set the card to the variable card
                                    card = players[finalI].getHand().get(k);
                                    //print the card
                                    System.out.println(card.getUV());
                                    break;
                                }
                            }
                            frame.dispose();
                        }
                    });
                }
                frame.setVisible(true);
            }

        }
    }


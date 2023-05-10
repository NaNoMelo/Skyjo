package src;
import java.io.*;
import java.util.LinkedList;

public class SkyjjoDeck extends Card {
    //create a deck by creating a linked list of card
    LinkedList<Card> deck = new LinkedList<Card>();
        public void createDeck() throws IOException {
            //open the file UV_TC.txt, read line per line and define each card
            File file = new File("C:\\Users\\axela\\IdeaProjects\\Skyjo\\uv.txt");
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //define the card and add it to the deck until the txt file is empty
            String line = br.readLine();
            while (line != null) {
                //split the line into 3 parts
                String[] parts = line.split("\\|");
                //create a card
                Card card = new Card();
                //define the card
                card.setUV(parts[1]);
                card.setMark(parts[3]);
                card.setUV_description(parts[2]);
                card.setType(parts[0]);
                //add the card to the deck
                deck.add(card);
                //read the next line
                line = br.readLine();
            }
            //close the file
            br.close();
        }

        //print the deck
        public void printDeck() {
            for (int i = 0; i < deck.size(); i++) {
                System.out.println(deck.get(i).getUV() + " " + deck.get(i).getMark() + " " + deck.get(i).getType());
            }
        }

        public LinkedList<Card> getDeck() {
            return deck;
        }


    }


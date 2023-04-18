package src;
import java.io.*;
import java.util.LinkedList;

public class SkyjjoDeck {
   //create a deck by creating a linked list of card
   public class card {
       private String type;
       private String UV;
       private String mark;
       private String UV_description;

       public String getUV() {
           return UV;
       }

       public String getMark() {
           return mark;
       }

       public String getType() {
           return type;
       }

       public String getUV_description() {
           return UV_description;
       }

       public void setUV(String UV) {
           this.UV = UV;
       }

       public void setMark(String mark) {
           this.mark = mark;
       }

       public void setUV_description(String UV_description) {
           this.UV_description = UV_description;
       }
       public void setType(String type) {
           this.type = type;
       }

   }
    LinkedList<card> deck = new LinkedList<card>();
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
        String line= br.readLine();
        while (line != null) {
            //split the line into 3 parts
            String[] parts = line.split("\\|");
            //create a card
            card card = new card();
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

    public LinkedList<card> getDeck() {
        return deck;
    }


}

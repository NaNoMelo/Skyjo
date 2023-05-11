package src;

public class Rule {
boolean rule_respected = false;
    public boolean isfrom(Card card, Game game, int turn) {

        //check if the card selected is from his hand
        for (int i = 0; i < game.getPlayers()[turn].getHand().size(); i++) {
            if (card.getUV().equals(game.getPlayers()[turn].getHand().get(i).getUV())) {
                System.out.println("You can play this card");
                rule_respected = true;
            }
        }
        return rule_respected;
    }

}
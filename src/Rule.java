package src;

public class Rule {
    private boolean respectRule = false;

    public void isfrom(Card card, Player player, int turn) {

        //check if the card selected is from his hand
        for (int i = 0; i < player.getHand().size(); i++) {
            if (card.getUV().equals(player.getHand().get(i).getUV())) {
                System.out.println("You can play this card");
                respectRule = true;
            } else {
                System.out.println("You can't play this card");
                respectRule = false;
            }
        }
    }
    //getter for the respectRule
    public boolean getRespectRule() {
        return respectRule;
    }
}
package src;

public class Rule {
    private boolean respectRule;

    public void firstround(Card card, Player player, int turn) {
        if (turn == 1) {
            //check if the card selected is from his hand
            for (int i = 0; i < player.getHand().size(); i++) {
                if (card.getUV().equals(player.getHand().get(i).getUV())) {
                    respectRule = true;
                } else {
                    System.out.println("You can't play this card");
                    respectRule = false;
                }
            }
        }


    }
    //getters and setters
    public boolean isRespectRule() {
        return respectRule;
    }
    public void setRespectRule(boolean respectRule) {
        this.respectRule = respectRule;
    }
}
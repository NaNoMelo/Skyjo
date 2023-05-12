package src;

public class Card {
    private String type;
    private String UV;
    private int mark;
    private String UV_description;
    private boolean isrevealed = false;


    public String getUV() {
        return UV;
    }

    public int getMark() {
        return mark;
    }

    public String getType() {
        return type;
    }

    private String letter;
    private int score;

    public String getUV_description() {
        return UV_description;
    }

    public void setUV(String UV) {
        this.UV = UV;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
    //getter
    public String getLetter() {
        return letter;
    }
    public void setScore() {
        String l[]={ "A", "B", "C", "D", "E", "F", "FX", "ABS"};
        //this.letter = random letter from l
        this.letter = l[(int) (Math.random() * l.length)];
        //set the score according to the letter
        if (this.letter == "A") {
            this.score = mark;
        } else if (this.letter == "B") {
            this.score = mark*80/100;
        } else if (this.letter == "C") {
            this.score =  mark*60/100;
        } else if (this.letter == "D") {
            this.score =  mark*40/100;
        } else if (this.letter == "E") {
            this.score =  mark*20/100;
        } else if (this.letter == "F") {
            this.score =  mark*0/0;
        } else if (this.letter == "FX") {
            this.score =  mark*-20/100;
        } else if (this.letter == "ABS") {
            this.score =  mark*-40/100;
        }
    }
    public int getScore() {
        return score;
    }

    public void setUV_description(String UV_description) {
        this.UV_description = UV_description;
    }
    public void setType(String type) {
        this.type = type;
    }
//Card constructor
    public Card(String UV, int mark, String UV_description, String type) {
        this.UV = UV;
        this.mark = mark;
        this.UV_description = UV_description;
        this.type = type;
    }
    public Card() {
    }
    public boolean isIsrevealed() {
        return isrevealed;
    }
    public void setIsrevealed(boolean isrevealed) {
        this.isrevealed = isrevealed;
    }
}


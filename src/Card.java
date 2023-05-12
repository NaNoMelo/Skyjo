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

    public String getUV_description() {
        return UV_description;
    }

    public void setUV(String UV) {
        this.UV = UV;
    }

    public void setMark(int mark) {
        this.mark = mark;
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


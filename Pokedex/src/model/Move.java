package model;

public class Move {
    private int id;
    private String name;
    private String type;
    private String text;
    private int pp;
    private int base;
    private int accuracy;

    public Move(int id, String name, String type, String text, int pp, int base, int accuracy) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.text = text;
        this.pp = pp;
        this.base = base;
        this.accuracy = accuracy;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public String getText() { return text; }
    public int getPp() { return pp; }
    public int getBase() { return base; }
    public int getAccuracy() { return accuracy; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
    public void setText(String text) { this.text = text; }
    public void setPp(int pp) { this.pp = pp; }
    public void setBase(int base) { this.base = base; }
    public void setAccuracy(int accuracy) { this.accuracy = accuracy; }
}

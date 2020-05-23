package model;

public class Trainer {
    private int id;
    private String name;
    private String sex;
    private String hometown;

    public Trainer(int id, String name, String sex, String hometown) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.hometown = hometown;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getSex() { return sex; }
    public String getHometown() { return hometown; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSex(String sex) { this.sex = sex; }
    public void setHometown(String hometown) { this.hometown = hometown; }
}

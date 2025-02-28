package Inheritance.hero;

public class Hero {
    private String name;
    private int level;

    public Hero(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return String.format("Type: %s Username: %s Level: %d",
                this.getClass().getName(),
                this.name,
                this.level);
    }
}

package io.github.toandv.dsaj.array;

/**
 * Created by dovan on 1/11/2017.
 */
public class GameEntry {

    private String name;

    private int score;

    public GameEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public boolean isHigher(GameEntry other) {
        return this.score > other.score;
    }

    @Override
    public String toString() {
        return "GameEntry{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

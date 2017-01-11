package io.github.toandv.dsaj.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by dovan on 1/11/2017.
 */
public class ScoreboardTest {

    Scoreboard scoreboard;

    @Before
    public void setup() {
        scoreboard = new Scoreboard(5);
    }

    @Test
    public void testAdd() {
        scoreboard.add(
                new GameEntry("1", 1),
                new GameEntry("2", 2),
                new GameEntry("0", 0),
                new GameEntry("3", 3),
                new GameEntry("4", 4)
        );
        System.out.println(scoreboard);
        Assert.assertTrue(scoreboard.toString(), scoreboard.isDescending());
    }

    @Test
    public void testRemove() {
        testAdd();
        scoreboard.remove(2);
        System.out.println(scoreboard);
        Assert.assertTrue(scoreboard.toString(), scoreboard.isDescending());
    }
}

package io.github.toandv.dsaj.array;

import java.util.StringJoiner;

/**
 * Created by dovan on 1/11/2017.
 */
public class Scoreboard {

    private int numEntries = 0;

    private GameEntry[] board;

    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }

    public void add(GameEntry... entries) {
        for (GameEntry entry : entries) {
            add(entry);
        }
    }

    public void add(GameEntry newEntry) {
        // the board is sorted in the descending order
        if (numEntries < board.length || newEntry.isHigher(board[numEntries - 1])) {
            if (numEntries < board.length) {
                numEntries++;
            }
            int i = numEntries - 1;
            while (i > 0 && newEntry.isHigher(board[i - 1])) {
                board[i] = board[i - 1];
                i--;
            }
            board[i] = newEntry;
        }
    }

    public GameEntry remove(int i) {
        if (i >= numEntries || i < 0) {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
        GameEntry removed = board[i];
        for (int j = i; j < numEntries - 1; j++) {
            board[j] = board[j + 1];
        }
        board[numEntries - 1] = null;
        numEntries--;
        return removed;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("|");
        for (int i = 0; i < numEntries; i++) {
            joiner.add(board[i].toString());
        }
        return joiner.toString();
    }

    public boolean isDescending() {
        for (int i = 0; i < numEntries - 1; i++) {
            if (!board[i].isHigher(board[i + 1])) {
                return false;
            }
        }
        return true;
    }
}

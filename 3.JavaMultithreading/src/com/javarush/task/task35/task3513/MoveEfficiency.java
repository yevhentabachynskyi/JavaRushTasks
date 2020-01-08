package com.javarush.task.task35.task3513;

/**
 * Created by XPMUser on 2/18/19.
 */
public class MoveEfficiency implements Move, Comparable<MoveEfficiency>{
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public Move getMove() {
        return move;
    }

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    @Override
    public void move() {

    }

    @Override
    public int compareTo(MoveEfficiency m) {
       return Integer.compare(this.numberOfEmptyTiles, m.numberOfEmptyTiles) == 0? Integer.compare(this.score, m.score) : Integer.compare(this.numberOfEmptyTiles, m.numberOfEmptyTiles);
        }
    }


package com.javarush.task.task35.task3513;

import java.util.*;

/**
 * Created by XPMUser on 2/11/19.
 */
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    private Stack <Tile[][]> previousStates = new Stack<>();
    private Stack <Integer> previousScores = new Stack<>();
    boolean isSaveNeeded = true;
    public int score;
    public int maxTile;
    public Model() {

        resetGameTiles();
    }
    private List getEmptyTiles(){
        List<Tile> emptyTiles = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                if (gameTiles[i][j].isEmpty()) {
                    emptyTiles.add(gameTiles[i][j]);
                }
            }
        }
        return emptyTiles;
    }
    private void addTile(){
        List<Tile> emptyList = getEmptyTiles();
        if (emptyList != null && emptyList.size() != 0) {
            Tile tile = emptyList.get((int) (Math.random() * emptyList.size()));
            int tileWeight = Math.random() < 0.9 ? 2 : 4;
            tile.value = tileWeight;
        }
    }
    protected void resetGameTiles(){
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++){
            for (int j = 0; j < FIELD_WIDTH; j++){
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
        maxTile = 2;
        score = 0;
    }

    private boolean compressTiles(Tile[] tiles){
        int counter = 0;
        boolean isChanged = false;
        int values[] = new int[tiles.length];
        for (int i = 0; i < values.length; i++){
            values[i] = 0;
        }

        for (int i = 0; i < tiles.length; i++){
            if (tiles[i].value != 0) {
                values[counter] = tiles[i].value;
                counter++;
            }
        }

        for (int i = 0; i < tiles.length; i++){
            if (values[i] != tiles[i].value) { isChanged = true; }
            tiles[i].value = values[i];
        }

        return isChanged;

    }

    private boolean mergeTiles(Tile[] tiles){
        boolean isChanged = false;
        for (int i = 0; i < tiles.length - 1; i++){
            if (tiles[i].value == tiles[i+1].value && tiles[i].value != 0) {
                tiles[i].value = tiles[i].value * 2;
                score = score + tiles[i].value;
                if (tiles[i].value > maxTile) { maxTile = tiles[i].value; }
                for (int j = 2; j <= tiles.length - i; j++){
                    try {
                        tiles[i + j - 1 ].value = tiles[i + j].value;
                    } catch (Exception e){
                        tiles[i + j - 1].value = 0;
                        isChanged = true;
                    }
                }
            }
        }
        return isChanged;
    }

    public void left(){

        if (isSaveNeeded == true) {
            saveState(gameTiles);
        }
            boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++){
            if (compressTiles(gameTiles[i])) {
                isChanged = true;
            }
            if (mergeTiles(gameTiles[i])) {
                isChanged = true;
            }
        }
        if (isChanged) {
            addTile();
            isSaveNeeded = true;
        }

    }
    private void rotateToRight() {
        Tile tmp;
            for (int i = 0; i < FIELD_WIDTH / 2; i++) {
                for (int j = i; j < FIELD_WIDTH - 1 - i; j++) {
                    tmp = gameTiles[i][j];
                    gameTiles[i][j] = gameTiles[FIELD_WIDTH - j - 1][i];
                    gameTiles[FIELD_WIDTH - j - 1][i] = gameTiles[FIELD_WIDTH - i - 1][FIELD_WIDTH - j - 1];
                    gameTiles[FIELD_WIDTH - i - 1][FIELD_WIDTH - j - 1] = gameTiles[j][FIELD_WIDTH - i - 1];
                    gameTiles[j][FIELD_WIDTH - i - 1] = tmp;
                }
            }
    }

    void right() {
        saveState(gameTiles);
        rotateToRight();
        rotateToRight();
        left();
        rotateToRight();
        rotateToRight();
    }
    void up() {
        saveState(gameTiles);
        rotateToRight();
        rotateToRight();
        rotateToRight();
        left();
        rotateToRight();
    }
    void down() {
        saveState(gameTiles);
        rotateToRight();
        left();
        rotateToRight();
        rotateToRight();
        rotateToRight();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }
    public boolean canMove() {
        if (!getEmptyTiles().isEmpty())
            return true;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j-1].value) {
                    return true;
                }
            }
        }
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[j][i].value == gameTiles[j-1][i].value) {
                    return true;
                }
            }
        }
        return false;
    }
    private void saveState(Tile[][] tile){
        Tile[][] temp = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < tile.length; j++) {
                temp[i][j] = new Tile(tile[i][j].value);
            }
        }
        previousStates.push(temp);
        previousScores.push(score);
        isSaveNeeded = false;
    }
    public void rollback(){
        if (!previousStates.empty() && !previousScores.empty()){
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }
    public void randomMove(){
    int n = ((int) (Math.random() * 100)) % 4;
    switch (n){
        case 0:
            left();
            break;
        case 1:
            right();
            break;
        case 2:
            up();
            break;
        case 3:
            down();
            break;

    }
    }
   public boolean hasBoardChanged(){
       Tile[][] tiles =  previousStates.peek();
       for (int i = 0; i < gameTiles.length; i++) {
           for (int j = 0; j < gameTiles.length; j++) {
            if(gameTiles[j][i].value != tiles[j][i].value)
                return true;
           }
       }
       return false;
   }
    public MoveEfficiency getMoveEfficiency(Move move){
        move.move();
        if (hasBoardChanged() == true) {
            rollback();
            return new MoveEfficiency(getEmptyTiles().size(), score, move);
        } else {
            rollback();
            return new MoveEfficiency(-1, 0, move);
        }
    }
    public void autoMove(){
        PriorityQueue priorityQueue = new PriorityQueue(4, Collections.reverseOrder());
        priorityQueue.offer(getMoveEfficiency(this::left));
        priorityQueue.offer(getMoveEfficiency(this::right));
        priorityQueue.offer(getMoveEfficiency(this::up));
        priorityQueue.offer(getMoveEfficiency(this::down));
        MoveEfficiency moveEfficiency = (MoveEfficiency) priorityQueue.peek();
        moveEfficiency.getMove().move();
    }

}

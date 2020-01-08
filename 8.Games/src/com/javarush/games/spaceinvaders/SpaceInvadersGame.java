package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;

public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;

    @Override
    public void initialize() {
        setScreenSize(WIDTH,HEIGHT);
        createGame();
    }
    // створення елементів поля
    private void createGame(){ drawScene();}
    // малювання елементів поля
    private void drawScene(){ drawField();}
    // малюємо поле(космос)
    private void drawField(){
        for (int y = 0; y < WIDTH; y++) {
            for (int x = 0; x < HEIGHT; x++) {
                this.setCellValueEx(0, 2, Color.BLACK, "");
            }
        }
    }
}

package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Model {
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("C:\\Users\\TAYE\\Sync\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task34\\task3410\\res\\levels.txt"));
    private EventListener eventListener;
    //Розміри клітинки на полі
    public static final int FIELD_CELL_SIZE = 20;

    public void setEventListener(EventListener eventListener){
        this.eventListener = eventListener;
    }
    //он должен возвращать все игровые объекты.
    public GameObjects getGameObjects() {

        return gameObjects;
    }
    //он должен получать новые игровые объекты для указанного уровня у загрузчика уровня levelLoader и сохранять их в поле gameObjects.
    public void restartLevel(int level){
        try {
            gameObjects = levelLoader.getLevel(level);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // он должен перезапускать текущий уровень, вызывая restartLevel с нужным параметром.
    public void restart(){
        restartLevel(currentLevel);
    }
    //он должен увеличивать значение переменной currentLevel, хранящей номер текущего уровня и выполнять перезапуск нового уровня.
    public void startNextLevel(){
        currentLevel++;
        restart();
    }
    //метод проверяет столкновение со стеной.
    public boolean checkWallCollision(CollisionObject gameObject, Direction direction){
        for (Wall wall: gameObjects.getWalls()) {
            if (gameObject.isCollision(wall, direction))
                return true;
        }
        return false;
    }
    // метод проверяет столкновение с ящиками
    public boolean checkBoxCollisionAndMoveIfAvaliable(Direction direction){

        Player player = gameObjects.getPlayer();

        // найдем во что уперся игрок
        GameObject  stoped = null;
        for (GameObject gameObject: gameObjects.getAll()){
            if (!(gameObject instanceof Player)&&!(gameObject instanceof Home) && player.isCollision(gameObject, direction)){
                stoped = gameObject;
            }
        }
        //свободное место или дом
        if ((stoped == null)){
            return false;
        }
        if (stoped instanceof Box){
            Box stopedBox = (Box)stoped;
            if (checkWallCollision(stopedBox, direction)){
                return true;
            }
            for (Box box : gameObjects.getBoxes()){
                if(stopedBox.isCollision(box, direction)){
                    return true;
                }
            }
            switch (direction)
            {
                case LEFT:
                    stopedBox.move(-FIELD_CELL_SIZE, 0);
                    break;
                case RIGHT:
                    stopedBox.move(FIELD_CELL_SIZE, 0);
                    break;
                case UP:
                    stopedBox.move(0, -FIELD_CELL_SIZE);
                    break;
                case DOWN:
                    stopedBox.move(0, FIELD_CELL_SIZE);
            }
        }
        return false;
    }
    //метод должен проверить пройден ли уровень (на всех ли домах стоят ящики, их координаты должны совпадать).
    public void checkCompletion(){
        int check = 0;
        for (Box box: gameObjects.getBoxes()){
            for (Home home: gameObjects.getHomes())
                if (box.getX()==home.getX() && box.getY()==home.getY())
                    check++;
        }
        if (check==gameObjects.getBoxes().size())
            eventListener.levelCompleted(currentLevel);

    }
    public void move(Direction direction) {
        Player player = gameObjects.getPlayer();
        if (checkWallCollision(gameObjects.getPlayer(),direction) || checkBoxCollisionAndMoveIfAvaliable(direction)){
           return;
        } else  { int sellSize = FIELD_CELL_SIZE;
        switch (direction) {
            case LEFT:
                player.move(-sellSize, 0);
                break;
            case RIGHT:
                player.move(sellSize, 0);
                break;
            case UP:
                player.move(0, -sellSize);
                break;
            case DOWN:
                player.move(0, sellSize);
        }
        checkCompletion();
    }
    }
}

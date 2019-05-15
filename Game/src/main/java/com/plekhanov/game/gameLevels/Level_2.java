package com.plekhanov.game.gameLevels;

import com.plekhanov.game.ImageLoader;
import com.plekhanov.game.Model;
import com.plekhanov.game.gameObjects.GameObject;
import com.plekhanov.game.gameObjects.Player;
import com.plekhanov.game.gameObjects.background.BackGround;
import com.plekhanov.game.gameObjects.enemies.EnemyCarrion;
import com.plekhanov.game.gameObjects.enemies.EnemyHusk;
import com.plekhanov.game.gameObjects.enemies.EnemyPestilence;


import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Level_2 {

    private List<GameObject> gameObjects;
    private Player player;

    public Level_2(int width, int height, Model model) {


        this.gameObjects = new CopyOnWriteArrayList<>();
        model.setGameObjects(gameObjects);

        int y = -130; // смещение фона вверх
        int imageHeight = 260;  // растягивание фона
        //статический фон
        gameObjects.add(new BackGround(width / 2, height / 2 - y, 0, 0, ImageLoader.getBackgroundLevel2Image1(), width + imageHeight * 16 / 9, height + imageHeight, 1));  //background1
        gameObjects.add(new BackGround(width / 2, height / 2 - y, 0, 0, ImageLoader.getBackgroundLevel2Image2(), width, height + imageHeight, 2));  //background2
        gameObjects.add(new BackGround(width / 2, height / 2 - y, 0, 0, ImageLoader.getBackgroundLevel2Image3(), width, height + imageHeight, 3));  //background3

        //динамический фон
        gameObjects.add(new BackGround(width / 2, height / 2 - y, -0.2, 0, ImageLoader.getBackgroundLevel2Image4(), width, height + imageHeight, 4));  //background4
        gameObjects.add(new BackGround(width / 2 + width, height / 2 - y, -0.2, 0, ImageLoader.getBackgroundLevel2Image4(), width, height + imageHeight, 4));  //background4
        gameObjects.add(new BackGround(width / 2, height / 2 - y, -0.3, 0, ImageLoader.getBackgroundLevel2Image5(), width, height + imageHeight, 5));  //background5
        gameObjects.add(new BackGround(width / 2 + width, height / 2 - y, -0.3, 0, ImageLoader.getBackgroundLevel2Image5(), width, height + imageHeight, 5));  //background5
        gameObjects.add(new BackGround(width / 2, height / 2 - y, -0.3, 0, ImageLoader.getBackgroundLevel2Image6(), width, height + imageHeight, 6));  //background6
        gameObjects.add(new BackGround(width / 2 + width, height / 2 - y, -0.3, 0, ImageLoader.getBackgroundLevel2Image6(), width, height + imageHeight, 6));  //background6
        gameObjects.add(new BackGround(width / 2, height / 2 - y - 260, -0.5, 0, ImageLoader.getBackgroundLevel2Image7(), width, height + imageHeight, 7));  //background7
        gameObjects.add(new BackGround(width / 2 + width, height / 2 - y - 260, -0.5, 0, ImageLoader.getBackgroundLevel2Image7(), width, height + imageHeight, 7));  //background7
//

        // Враги
        gameObjects.add(new EnemyCarrion(2000, 965, -0.5, 0, ImageLoader.getEnemyCarrionImage(), 180, 120, 13, model)); //enemyCarrion
        gameObjects.add(new EnemyHusk(2200, 580, -0.3, 0, ImageLoader.getEnemyHuskImage(), 180, 160, 12, model)); //enemyHusk
        gameObjects.add(new EnemyPestilence(2200, 370, -0.7, 0, ImageLoader.getEnemyPestilenceImage(), 120, 140, 14, model)); //enemyPestilence


        // Игрок
        Player player = new Player(500, 900, 0, 0, ImageLoader.getPlayerImage(), 150, 130, 100, model);
        gameObjects.add(player);
        this.player = player;

        // Предметы


        Collections.sort(gameObjects);


    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public Player getPlayer() {
        return player;
    }
}
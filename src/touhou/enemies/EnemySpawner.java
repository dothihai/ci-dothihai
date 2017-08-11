package touhou.enemies;

import bases.FrameCounter;
import bases.GameObject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class EnemySpawner {
    private FrameCounter spawnCounter;
    private Random random;

    public EnemySpawner() {
        spawnCounter = new FrameCounter(70);
        random = new Random();
    }

    public void spawn() {
        if (spawnCounter.run()) {
            spawnCounter.reset();
            Enemy enemy = new Enemy();
            enemy.getPosition().set(random.nextInt(384), 40);
            GameObject.add(enemy);
        }
    }
}

package touhou.enemies;

import bases.FrameCounter;
import bases.GameObject;
import bases.renderers.ImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class EnemySpawner  extends GameObject{
    private FrameCounter spawnCounter;
    private Random random;
    private BufferedImage image;

    public EnemySpawner() {
        spawnCounter = new FrameCounter(70);
        random = new Random();
        renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png"));

    }

    public void run(){
        super.run();
        spawn();
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

package touhou.enemies;

import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;
import bases.renderers.ImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class EnemySpawner extends GameObject {
    private FrameCounter spawnCounter;
    private Random random;
    private BufferedImage image;

    public EnemySpawner() {
        spawnCounter = new FrameCounter(70);
        random = new Random();
        image = SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png");
        renderer = new ImageRenderer(image);
    }
    @Override
    public void run(Vector2D parentPosition){
        super.run(parentPosition);
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

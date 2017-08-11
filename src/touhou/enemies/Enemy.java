package touhou.enemies;

import bases.FrameCounter;
import bases.GameObject;
import tklibs.SpriteUtils;
import bases.Vector2D;
import bases.renderers.ImageRenderer;

import java.awt.*;

public class Enemy extends GameObject {
    private static final float SPEED = 3;
    private FrameCounter frameCounter;

    public Enemy() {
        super();
        renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png"));
        frameCounter = new FrameCounter(50);
    }

    // Controller
    public void run() {
        super.run();
        fly();
        shoot();
    }

    private void shoot() {
        // TODO: create enemy bullet and shoot
        if (frameCounter.run()) {
            EnemySpell enemySpell = new EnemySpell();
            enemySpell.getPosition().set(this.position);
            GameObject.add(enemySpell);
            frameCounter.reset();
        }
    }

    private void fly() {
        position.addUp(0, SPEED);
    }
}

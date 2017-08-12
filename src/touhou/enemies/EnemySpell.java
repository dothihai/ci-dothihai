package touhou.enemies;

import bases.GameObject;
import tklibs.SpriteUtils;
import bases.Vector2D;
import bases.renderers.ImageRenderer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemySpell extends GameObject{
    private final int SPEED = 5;

    public EnemySpell() {
        super();
        renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png"));
    }
    @Override
    public void run(Vector2D parentPosition){
        super.run(parentPosition);
        position.addUp(0, SPEED);
    }
}

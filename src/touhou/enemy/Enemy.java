package touhou.enemy;

import tklibs.SpriteUtils;
import touhou.bases.Vecter2D;
import touhou.bases.renderers.ImageRenderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Enemy {
    private static final int SPEED = 5;
    private Vecter2D position;
    private ImageRenderer renderer;
    //private int x;
    public ArrayList<EnemySpell> enemySpells;


    public Enemy() {
        this.position = new Vecter2D(384 / 2, 50);
        BufferedImage image = SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png");
        renderer = new ImageRenderer(image);

    }
    //public void castSpell(){
     //   EnemySpell newSpell = new EnemySpell();
      //  enemySpells.add(newSpell);
    //}

    public void run(){
        position.addUp(0, SPEED);
    //    x++;
    //    if(x >= 20){
    //        castSpell();
    //        x = 0;
    //    }
    }

    public void render(Graphics2D g2d){
        renderer.render(g2d, position);
    }

}

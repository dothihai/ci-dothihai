package touhou.enemy;

import tklibs.SpriteUtils;
import touhou.bases.Vecter2D;
import touhou.bases.renderers.ImageRenderer;

import java.awt.*;

public class EnemySpell {

    public Vecter2D position;
    public ImageRenderer renderer;

    public EnemySpell(){
        this.renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png"));
        position = new Vecter2D();
    }

    public void run(){
        position.addUp(0,5);
    }

    public void render(Graphics2D g2d){
        renderer.render(g2d, position);
    }
}

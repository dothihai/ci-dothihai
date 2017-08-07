package touhou.player;

import tklibs.SpriteUtils;
import touhou.bases.Vecter2D;
import touhou.bases.renderers.ImageRenderer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerSpell {
    public Vecter2D position;
    public ImageRenderer renderer;

    public PlayerSpell() {
        this.renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/player-spells/a/0.png"));
        //image = SpriteUtils.loadImage("assets/images/player-spells/a/0.png");
        position = new Vecter2D();
        //renderer = new ImageRenderer(image);
    }

    public void render(Graphics2D g2d) {
        // g2d.drawImage(image, (int)position.x, (int)position.y, null);
        renderer.render(g2d, position);
    }

    public void run() {
        position.addUp(0, -10);
    }
}

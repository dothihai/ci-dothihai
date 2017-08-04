package touhou.player;


import tklibs.SpriteUtils;
import touhou.bases.Vecter2D;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerSpell {
    // position, image
    // run()
    // render()

    private Vecter2D position;
    private Vecter2D position1;
    private Vecter2D position2;
    private BufferedImage image;
    private BufferedImage image1;
    public PlayerSpell(Vecter2D position){
        this.position = position;
        image = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        position1 = position.add(0,-10);
        image1 = SpriteUtils.loadImage("assets/images/player-bullets/a/0.png");
        position2 = position.add(0,-10);
    }

    public void run(){

        this.position1.subtractBy(0,5);
        this.position2.subtractBy(5,5);
    }
    public void render(Graphics2D g2d){
        g2d.drawImage(image, (int)position1.x, (int)position1.y, null);
        g2d.drawImage(image, (int)position2.x, (int)position2.y, null);
    }
}


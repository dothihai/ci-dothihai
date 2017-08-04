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
    private BufferedImage image;
    public PlayerSpell(Vecter2D position){
        this.position = position;
        image = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png ");

    }

    public void run(){
        this.position.subtractBy(0,5);
    }
    public void render(Graphics2D g2d){
        g2d.drawImage(image, (int)position.x, (int)position.y, null);
    }
}


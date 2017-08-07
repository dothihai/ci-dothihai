package touhou.bases.renderers;

import touhou.bases.Vecter2D;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageRenderer {
    public BufferedImage image;

    public ImageRenderer(BufferedImage image) { // hamtao moi khi khoi tao ra 1 imagerenderer thi phai cap ngay cho n 1 anh
        this.image = image;
    }

    public void render(Graphics2D g2d, Vecter2D position){
        g2d.drawImage(image, (int)(position.x - image.getWidth()/2), (int)(position.y - image.getHeight()/2 ), null);
    }

}

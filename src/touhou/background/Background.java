package touhou.background;

import bases.GameObject;
import bases.Vector2D;
import bases.renderers.ImageRenderer;
import tklibs.SpriteUtils;

public class Background extends GameObject {
    public Background(){
        super();
        renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/background/0.png"));
    }
    @Override
    public void run(Vector2D parentPosition){
        super.run(parentPosition);
        position.y += 4;
    }

}

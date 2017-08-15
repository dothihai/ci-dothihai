package touhou.players;

import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.renderers.ImageRenderer;
import tklibs.SpriteUtils;


public class Sphere extends GameObject implements PhysicsBody{

    private BoxCollider boxCollider;
    private FrameCounter frameCounter;

    public Sphere(float x, float y){
        super();
        this.frameCounter = new FrameCounter(30);
        this.boxCollider = new BoxCollider(20, 20);
        this.renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/sphere/0.png"));
        this.position.set(x, y);
        children.add(boxCollider);

    }

    @Override
    public void run(Vector2D parentPosition){
        super.run(parentPosition);
        shoot();
    }

    private void shoot() {
        if(frameCounter.run()){
            CreatSpell(1,10,0);
            frameCounter.reset();
        }

    }

    private void CreatSpell(float x, float y, float typeSpell){
        SphereSpell newSpell = new SphereSpell(typeSpell);
        newSpell.getPosition().set(this.screenPosition.add(x,y));
        GameObject.add(newSpell);
    }


    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }

    @Override
    public boolean isActive(){
        return this.isActive;
    }
}

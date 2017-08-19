package touhou.players.spheres;

import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.pools.GameObjectPool;
import bases.renderers.Animation;
import tklibs.SpriteUtils;

public class PlayerSphere extends GameObject implements PhysicsBody {
    private FrameCounter frameCounter;
    public PlayerSphere(){
        super();
        frameCounter = new FrameCounter(10);
        this.renderer = new Animation(
                7,
                false,
                SpriteUtils.loadImage("assets/images/sphere/0.png"),
                SpriteUtils.loadImage("assets/images/sphere/1.png"),
                SpriteUtils.loadImage("assets/images/sphere/2.png"),
                SpriteUtils.loadImage("assets/images/sphere/3.png")
        );
    }

    @Override
    public void run(Vector2D parentPosition){
        super.run(parentPosition);
        shoot();
    }
    private void shoot(){
        if(frameCounter.run()){
            SphereSpell newSpell = GameObjectPool.recycle(SphereSpell.class);
            newSpell.getPosition().set(this.screenPosition.add(0,10));
            frameCounter.reset();
            GameObject.add(newSpell);
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }
}

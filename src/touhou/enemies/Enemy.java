package touhou.enemies;

import bases.FrameCounter;
import bases.GameObject;
import bases.physics.BoxCollider;
import bases.physics.Physics;
import bases.physics.PhysicsBody;
import tklibs.SpriteUtils;
import bases.Vector2D;
import bases.renderers.ImageRenderer;
import touhou.players.Player;

import java.awt.*;

public class Enemy extends GameObject implements PhysicsBody {
    private static final float SPEED = 3;
    private FrameCounter frameCounter;
    private BoxCollider boxCollider;

    public Enemy() {
        super();
        this.renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png"));
        this.frameCounter = new FrameCounter(20);
        boxCollider = new BoxCollider(20,20);
        this.children.add(boxCollider);
    }

    // Controller
    @Override
    public void run(Vector2D parentPosition ) {
        super.run(parentPosition); // co cai nay moi dieu khien duoc children
        fly();
        shoot();
        hitPlayer();
    }

    private void shoot() {
        // TODO: create enemy bullet and shoot
        if (frameCounter.run()) {
            EnemySpell enemySpell = new EnemySpell();
            enemySpell.getPosition().set(this.position);
            GameObject.add(enemySpell);
            frameCounter.reset();
        }
    }

    private void fly() {
        position.addUp(0, SPEED);
        //System.out.println(boxCollider);
    }

    private void hitPlayer(){
        Player player = Physics.collideWithPlayer(this.boxCollider);
        if(player != null){
            player.setActive(false);
            this.isActive = false;
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}

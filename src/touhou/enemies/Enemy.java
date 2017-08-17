package touhou.enemies;

import bases.FrameCounter;
import bases.GameObject;
import bases.physics.BoxCollider;
import bases.physics.Physics;
import bases.physics.PhysicsBody;
import bases.pools.GameObjectPool;
import bases.renderers.Animation;
import tklibs.SpriteUtils;
import bases.Vector2D;
import bases.renderers.ImageRenderer;
import touhou.players.Player;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;

public class Enemy extends GameObject implements PhysicsBody {
    private static final float SPEED = 3;
    private FrameCounter frameCounter;
    private BoxCollider boxCollider;
    private float damage;
    private float enemyBlood;


    public Enemy() {
        super();

        renderer = new Animation(
                SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/blue/1.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/blue/2.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/blue/3.png")
        );
        this.frameCounter = new FrameCounter(20);
        this.boxCollider = new BoxCollider(20,20);
        this.children.add(boxCollider);
        this.damage = 50;
    }

    // Controller
    @Override
    public void run(Vector2D parentPosition ) {
        super.run(parentPosition); // co cai nay moi dieu khien duoc children
        fly();
        shoot();
        hitPlayer();
        if(this.getEnemyBlood() < 0){
            this.isActive = false;
        }
    }

    private void shoot() {
        // TODO: create enemy bullet and shoot
        if (frameCounter.run()) {
            CastSpell(1,10, 3);
            CastSpell(1,10, 0);
            CastSpell(1,10, -3);
            frameCounter.reset();
        }
    }
    private void CastSpell(float x, float y, int typeEnemy){
        EnemySpell newSpell = new EnemySpell(typeEnemy);
        newSpell.getPosition().set(this.position.add(x, y));
        GameObject.add(newSpell);
    }

    private void fly() {
        position.addUp(0, SPEED);
        //System.out.println(boxCollider);
    }

    private void hitPlayer(){
        Player player = Physics.collideWith(this.boxCollider, Player.class);
        if(player != null){
            player.setBlood(player.getBlood() - this.damage);
            this.isActive = false;
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public float getEnemyBlood() {
        return enemyBlood;
    }

    public void setEnemyBlood(float enemyBlood) {
        this.enemyBlood = enemyBlood;
    }
}
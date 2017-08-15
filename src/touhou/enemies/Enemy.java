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
import java.util.Random;
import java.util.concurrent.Callable;

public class Enemy extends GameObject implements PhysicsBody {
    private static final float SPEED = 3;
    private FrameCounter frameCounter;
    private BoxCollider boxCollider;
    private float damage;
    private float enemyBlood;
    private Random random = new Random();
    private int typeEnemy;

    public Enemy() {
        super();

        this.frameCounter = new FrameCounter(20);
        boxCollider = new BoxCollider(20,20);
        this.children.add(boxCollider);
        this.damage = 50;
        typeEnemy = random.nextInt(2);
        if(typeEnemy == 0){
            renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png"));
            setEnemyBlood(10);
        }
        if(typeEnemy == 1){
            renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png"));
            setEnemyBlood(20);
        }

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
            CreatSpell(1,10,3);
            CreatSpell(1,10,0);
            CreatSpell(1,10,-3);
            frameCounter.reset();
        }
    }
    private void CreatSpell(float x, float y, int typeSpell){
        EnemySpell enemySpell = new EnemySpell(typeSpell);
        enemySpell.getPosition().set(this.position.add(x, y));
        GameObject.add(enemySpell);
    }

    private void fly() {
        position.addUp(0, SPEED);
        //System.out.println(boxCollider);
    }

    private void hitPlayer(){
        Player player = Physics.collideWithPlayer(this.boxCollider);
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

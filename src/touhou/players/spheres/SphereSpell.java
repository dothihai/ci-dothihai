package touhou.players.spheres;

import bases.GameObject;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.Physics;
import bases.physics.PhysicsBody;
import bases.renderers.Animation;
import tklibs.SpriteUtils;
import touhou.enemies.Enemy;
import touhou.enemies.EnemySpell;

public class SphereSpell extends GameObject implements PhysicsBody {
    private BoxCollider boxCollider;
    private float damage;
    public SphereSpell(){
        super();
        this.renderer = new Animation(
                SpriteUtils.loadImage("assets/images/sphere-bullets/0.png"),
                SpriteUtils.loadImage("assets/images/sphere-bullets/1.png"),
                SpriteUtils.loadImage("assets/images/sphere-bullets/2.png"),
                SpriteUtils.loadImage("assets/images/sphere-bullets/3.png")
        );
        boxCollider = new BoxCollider(20, 20);
        children.add(boxCollider);
        damage = 3;

    }

    @Override
    public void run(Vector2D parentPosition){
        super.run(parentPosition);
        position.addUp(0,-5);
        hitEnemy();
        deactiveIfNeeded();
    }

    public void hitEnemy(){
        Enemy enemy = Physics.collideWith(this.boxCollider, Enemy.class);
        if(enemy != null){
            enemy.setEnemyBlood(enemy.getEnemyBlood()- this.damage);
            this.isActive = false;
        }
    }

    private void deactiveIfNeeded() {
        if (this.screenPosition.y < 0) {
            this.isActive = false;
        }
    }


    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }
}

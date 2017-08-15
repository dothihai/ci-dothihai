package touhou.players;

import bases.GameObject;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.Physics;
import bases.physics.PhysicsBody;
import bases.renderers.ImageRenderer;
import tklibs.SpriteUtils;
import touhou.enemies.Enemy;
import touhou.enemies.EnemySpell;

public class SphereSpell extends GameObject implements PhysicsBody {
    private final int SPEED = 5;
    private BoxCollider boxCollider;
    private float damage;
    private float typeSpell;

    public SphereSpell(float typeSpell){
        super();
        this.renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/sphere-bullets/1.png"));
        damage = 5;
        this.typeSpell = typeSpell;
        boxCollider = new BoxCollider(20, 20);
        children.add(boxCollider);

    }

    @Override
    public void run(Vector2D parentPosition){
        super.run(parentPosition);
        position.addUp(typeSpell, SPEED);
        hitEnemy();
    }

    private void hitEnemy(){
        Enemy enemy = Physics.collideWithEnemy((this.boxCollider));
        if(enemy != null){
            enemy.setEnemyBlood(enemy.getEnemyBlood()- this.damage);
            this.isActive = false;
        }

    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}

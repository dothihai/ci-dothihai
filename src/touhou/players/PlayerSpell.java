package touhou.players;
import bases.renderers.Animation;
import touhou.enemies.Enemy;

import bases.GameObject;
import bases.physics.BoxCollider;
import bases.physics.Physics;
import bases.physics.PhysicsBody;
import tklibs.SpriteUtils;
import bases.Vector2D;
import bases.renderers.ImageRenderer;
import touhou.enemies.EnemySpell;

import java.awt.*;

public class PlayerSpell extends GameObject implements PhysicsBody {
    private BoxCollider boxCollider;
    private float damage;

    public PlayerSpell() {
        super();

        renderer = new Animation(
                SpriteUtils.loadImage("assets/images/player-spells/a/0.png"),
                SpriteUtils.loadImage("assets/images/player-spells/a/1.png"),
                SpriteUtils.loadImage("assets/images/player-spells/a/2.png"),
                SpriteUtils.loadImage("assets/images/player-spells/a/3.png")
        );
        boxCollider = new BoxCollider(20, 20);
        this.children.add(boxCollider);
        damage = 10;
    }

    @Override
    public void run(Vector2D parenPosition) {
        super.run(parenPosition);
        position.addUp(0, -10);
        hitEnemy();
        hitEnemySpell();
        deactiveIfNeeded();
    }

    private void hitEnemy() {
       Enemy enemy = Physics.collideWith(this.boxCollider, Enemy.class);
       if(enemy != null){
           enemy.setEnemyBlood(enemy.getEnemyBlood()- this.damage);
           this.isActive = false;
       }
    }
    private void hitEnemySpell(){
        EnemySpell enemySpell = Physics.collideWith(this.boxCollider, EnemySpell.class);
        if(enemySpell != null){
            enemySpell.setActive(false);
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
        return boxCollider;
    }
}

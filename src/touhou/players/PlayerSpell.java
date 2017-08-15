package touhou.players;
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

    public PlayerSpell() {
        super();

        this.renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/player-spells/a/0.png"));
        boxCollider = new BoxCollider(20, 20);
        this.children.add(boxCollider);
    }

    @Override
    public void run(Vector2D parenPosition) {
        super.run(parenPosition);
        position.addUp(0, -10);
        hitEnemy();
        hitEnemySpell();
    }

    private void hitEnemy() {
       Enemy enemy = Physics.collideWithEnemy((this.boxCollider));
       if(enemy != null){
           enemy.setActive(false);
           this.isActive = false;
       }
    }
    private void hitEnemySpell(){
        EnemySpell enemySpell = Physics.collideWithEnemySpell(this.boxCollider);
        if(enemySpell != null){
            enemySpell.setActive(false);
            this.isActive = false;
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}

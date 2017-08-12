package touhou.players;
import touhou.enemies.Enemy;

import bases.GameObject;
import bases.physics.BoxCollider;
import bases.physics.Physics;
import bases.physics.PhysicsBody;
import tklibs.SpriteUtils;
import bases.Vector2D;
import bases.renderers.ImageRenderer;

import java.awt.*;

public class PlayerSpell extends GameObject implements PhysicsBody {
    private BoxCollider boxCollider;

    public PlayerSpell() {
        super();

        this.renderer = new ImageRenderer(SpriteUtils.loadImage(
                "assets/images/player-spells/a/0.png"
        ));
        boxCollider = new BoxCollider(20, 20);
        this.children.add(boxCollider);
    }

    @Override
    public void run(Vector2D parenPosition) {
        super.run(parenPosition);
        position.addUp(0, -10);
        hitEnemy();
    }

    private void hitEnemy() {
       Enemy ememy = Physics.collideWithEnemy((this.boxCollider));
       if(ememy != null){
           ememy.setActive(false);
           this.isActive = false;
       }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}

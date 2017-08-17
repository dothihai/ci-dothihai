package touhou.enemies;
import bases.physics.BoxCollider;
import bases.physics.Physics;
import bases.physics.PhysicsBody;

import bases.GameObject;
import bases.physics.BoxCollider;
import bases.physics.Physics;
import bases.physics.PhysicsBody;
import tklibs.SpriteUtils;
import bases.Vector2D;
import bases.renderers.ImageRenderer;
import touhou.players.Player;


public class EnemySpell extends GameObject implements PhysicsBody{
    private final int SPEED = 5;
    private BoxCollider boxCollider;
    private float damage;
    private float typeSpell;


    public EnemySpell(float typeSpell) {
        super();
        this.renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png"));
        boxCollider = new BoxCollider(20, 20);
        this.children.add(boxCollider);
        this.typeSpell = typeSpell;
        damage = 10;
    }
    @Override
    public void run(Vector2D parentPosition){
        super.run(parentPosition);
        position.addUp(typeSpell, SPEED);
        hitPlayer();
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
        return boxCollider;
    }
}

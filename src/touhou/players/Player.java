package touhou.players;

import bases.GameObject;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import tklibs.SpriteUtils;
import bases.Constraints;
import bases.FrameCounter;
import bases.renderers.ImageRenderer;
import touhou.inputs.InputManager;

import java.util.Vector;

public class Player extends GameObject implements PhysicsBody{
    private static final int SPEED = 5;

    private InputManager inputManager;
    private Constraints constraints;

    private FrameCounter coolDownCounter;
    private boolean spellLock;
    private BoxCollider boxCollider;
    private float blood;
    private Sphere sphere;


    public Player() {
        super();
        this.spellLock = false;
        this.renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
        this.coolDownCounter = new FrameCounter(3);
        CreatSphere(20, 0);
        CreatSphere(-20, 0);
        boxCollider = new BoxCollider(20, 20);
        children.add(boxCollider);
        blood = 200;

    }

    public void setContraints(Constraints contraints) {
        this.constraints = contraints;
    }

    @Override
    public void run(Vector2D parentPositon) {
        super.run(parentPositon);

        if (inputManager.upPressed)
            position.addUp(0, -SPEED);
        if (inputManager.downPressed)
            position.addUp(0, SPEED);
        if (inputManager.leftPressed)
            position.addUp(-SPEED, 0);
        if (inputManager.rightPressed)
            position.addUp(SPEED, 0);

        if (constraints != null) {
            constraints.make(position);
        }
        if (getBlood() <= 0){
            this.setActive(false);
        }

        castSpell();
    }

    private void castSpell() {
        if (inputManager.xPressed && !spellLock) {
            PlayerSpell newSpell = new PlayerSpell();
            newSpell.getPosition().set(this.position.add(0, -30));
            GameObject.add(newSpell);

            spellLock = true;
            coolDownCounter.reset();
        }

        unlockSpell();
    }

    private void unlockSpell() {
        if (spellLock) {
            if (coolDownCounter.run()) {
                spellLock = false;
            }
        }
    }
    private void CreatSphere(float x, float y){
        sphere = new Sphere(x, y);
        children.add(sphere);

    }

    public void setInputManager(InputManager inputManager) {
        this.inputManager = inputManager;
    }

    public BoxCollider getBoxCollider() {
        return boxCollider;
    }

    public float getBlood() {
        return blood;
    }

    public void setBlood(float blood) {
        this.blood = blood;
    }

    @Override
    public String toString() {
        return "Player{" +
                "blood=" + blood +
                '}';
    }
}

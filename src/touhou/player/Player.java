package touhou.player;

import tklibs.SpriteUtils;
import touhou.bases.Constraints;
import touhou.bases.FrameCounter;
import touhou.bases.Vecter2D;
import touhou.bases.renderers.ImageRenderer;
import touhou.inputs.InputManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player {
    private static final int SPEED = 5;
    private Vecter2D position;

    private InputManager inputManager;
    private Constraints constraints;
    public ArrayList<PlayerSpell> playerSpells;
    private ImageRenderer renderer;
    private FrameCounter coolDownCounter;
    private boolean spellLock;

    //public final int SPEED = 5;
    // ham tao / constractor
    public Player(){
        this.spellLock = false;
        position = new Vecter2D(384/2, 600);
        BufferedImage image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        renderer = new ImageRenderer(image);
        coolDownCounter = new FrameCounter(3);
    }

    public void setConstraints(Constraints constraints){
        this.constraints = constraints;
    }

    public void setRenderer(ImageRenderer renderer){
        if(renderer == null)
            throw new IllegalArgumentException();
            this.renderer = renderer;
    }



    public void run(){
        if (inputManager.upPressed)
            position.addUp(0, -SPEED);
        if (inputManager.downPressed)
            position.addUp(0, SPEED);
        if (inputManager.leftPressed)
            position.addUp(-SPEED, 0);
        if (inputManager.rightPressed)
            position.addUp(SPEED, 0);
        if (constraints != null){
            constraints.make(position);
        }

        //if(coolDownCounter.run()){
        //    coolDownCounter.reset();
            castSpell();

       // System.out.println(String.format("framecount = %s", frameCount));

        //castSpell();
    }


    private  void castSpell() {
        if (inputManager.xPressed && !spellLock) {
            PlayerSpell newSpell = new PlayerSpell(); // tao spell
            newSpell.position.set(this.position.add(0, -0)); // gan spell vao dung vtri ng choi
            playerSpells.add(newSpell); // tong vao list
            spellLock = true;
            coolDownCounter.reset();
        }

        unlockSpell();

    }

    private void unlockSpell() {
        if(spellLock){
            if(coolDownCounter.run()){
                spellLock = false;
            }
        }
    }

    public void render(Graphics2D g2d){
        renderer.render(g2d, position);
    }

    public void setInputManager(InputManager inputManager) {
        this.inputManager = inputManager;
    }
}

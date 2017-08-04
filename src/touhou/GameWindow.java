package touhou;

import tklibs.SpriteUtils;
import touhou.bases.Constraints;
import touhou.player.Player;
import touhou.player.PlayerSpell;
import touhou.inputs.InputManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.*;

/**
 * Created by huynq on 7/29/17.
 */
public class GameWindow extends Frame {

    private long lastTimeUpdate;
    private long currentTime;
    private Graphics2D windowGraphics;

    private BufferedImage backbufferImage;
    private Graphics2D backbufferGraphics;

    private BufferedImage background;
    public int backgroundY = -2000;

    //private BufferedImage explosions;


    Player player = new Player() ;
    ArrayList<PlayerSpell> playerSpells = new ArrayList<>();
    InputManager inputManager = new InputManager();


    public GameWindow() {
        background = SpriteUtils.loadImage("assets/images/background/0.png");
        player.inputManager = this.inputManager;
        player.constraints = new Constraints(30,708,0,360);
        player.playerSpells = this.playerSpells;
        //player.x = 384/2;
        //player.y = 600;
        //player.image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        //explosions = SpriteUtils.loadImage("assets/images/players/explosions/0.png");
        setupGameLoop();
        setupWindow();
    }

    private void setupGameLoop() {
        lastTimeUpdate = -1;
    }

    private void setupWindow() {
        this.setSize(384, 768);

        this.setTitle("Touhou - Remade by Hai");
        this.setVisible(true);

        this.backbufferImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        this.backbufferGraphics = (Graphics2D) this.backbufferImage.getGraphics();

        this.windowGraphics = (Graphics2D) this.getGraphics();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {


            }

            @Override
            public void keyPressed(KeyEvent e) {
                inputManager.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                inputManager.keyReleased(e);
            }


        });
    }

    public void loop() {
        while(true) {
            if (lastTimeUpdate == -1) {
                lastTimeUpdate = System.currentTimeMillis();
            }
            currentTime = System.currentTimeMillis();
            if (currentTime - lastTimeUpdate > 17) {
                run();
                render();
                lastTimeUpdate = currentTime;
            }
        }
    }

    private void run() {
        player.run();
        for (PlayerSpell playerSpell : playerSpells){

            playerSpell.run();
        }
    }

    private void render() {
        backbufferGraphics.setColor(Color.black);
        backbufferGraphics.fillRect(0, 0, 384, 768);
        backbufferGraphics.drawImage(background, 0, backgroundY, null);

        {
            if(backgroundY < 0)
                backgroundY += 2;
        }

        player.render(backbufferGraphics);
        //backbufferGraphics.drawImage(explosions,0,0,null);
        for (PlayerSpell playerSpell : playerSpells){
            playerSpell.render(backbufferGraphics);
        }

        windowGraphics.drawImage(backbufferImage, 0, 0, null);
    }
}

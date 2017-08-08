package touhou;

import tklibs.SpriteUtils;
import touhou.bases.Constraints;
import touhou.bases.FrameCounter;
import touhou.enemy.Enemy;
import touhou.enemy.EnemySpell;
import touhou.inputs.InputManager;
import touhou.player.Player;
import touhou.player.PlayerSpell;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.*;

//https://github.com/qhuydtvt/ci1-huynq

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

    private FrameCounter coolDownCounter;

    Player player = new Player();
    ArrayList<PlayerSpell> playerSpells = new ArrayList<>();
    InputManager inputManager = new InputManager();

    ArrayList<Enemy> enemies = new ArrayList<>();
    ArrayList<EnemySpell> enemySpells = new ArrayList<>();

    public GameWindow() {
        pack();
        background = SpriteUtils.loadImage("assets/images/background/0.png");
        player.setInputManager(this.inputManager);
        player.setConstraints (new Constraints(getInsets().top, 768, getInsets().left, 384));
        player.playerSpells = this.playerSpells;
        coolDownCounter = new FrameCounter(50);
        setupGameLoop();
        setupWindow();
    }

    private void setupGameLoop() {
        lastTimeUpdate = -1;
    }

    private void setupWindow() {
        this.setSize(1024, 768);

        this.setTitle("Touhou - Remade by QHuyDTVT");
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

        for (PlayerSpell playerSpell : playerSpells) {
            playerSpell.run();
        }
        for (Enemy enemy : enemies){
            enemy.run();
        }
        if(coolDownCounter.run()){
            coolDownCounter.reset();
            addEnemy();
        }
        for (EnemySpell enemySpell : enemySpells){
            enemySpell.run();
        }
    }

    private void addEnemy(){
        Enemy newEnemy = new Enemy();
        enemies.add(newEnemy);
    }



    private void render() {
        backbufferGraphics.setColor(Color.black);
        backbufferGraphics.fillRect(0, 0, 1024, 768);
        backbufferGraphics.drawImage(background, 0, 0, null);
        player.render(backbufferGraphics);

        for (PlayerSpell playerSpell: playerSpells) {
            playerSpell.render(backbufferGraphics);
        }
        for (Enemy enemy: enemies){
            enemy.render(backbufferGraphics);
        }
        for (EnemySpell enemySpell : enemySpells){
            enemySpell.render(backbufferGraphics);
        }

        windowGraphics.drawImage(backbufferImage, 0, 0, null);
    }
}

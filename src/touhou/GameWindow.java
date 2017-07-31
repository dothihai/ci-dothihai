package touhou;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

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
    private BufferedImage straight_player;
    private int playerX = 190;
    private int playerY = 600;
    private int backgroundY=-2000;
    private int x;
    private int y;


    public GameWindow() {
        background = SpriteUtils.loadImage("assets/images/background/0.png");
        straight_player = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        setupGameLoop();
        setupWindow();
    }

    private void setupGameLoop() {
        lastTimeUpdate = -1;
    }

    private void setupWindow() {
        this.setSize(1024, 768);

        this.setTitle(" Touhou - Remade by Haidt");
        this.setVisible(true);
        this.backbufferImage = new BufferedImage(getWidth(), getHeight(),BufferedImage.TYPE_INT_ARGB);
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
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    x=2;
                    System.out.println("RIGHT");
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    x=-2;
                    System.out.println("LEFT");
                }
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    y=-2;
                    System.out.println("UP");
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    y=2;
                    System.out.println("DOWN");
                }
                System.out.println("key pressed");

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    x=0;
                    System.out.println("RIGHT");
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    x=-0;
                    System.out.println("LEFT");
                }
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    y=-0;
                    System.out.println("UP");
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    y=0;
                    System.out.println("DOWN");
                }
                System.out.println("key released");
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
            }
        }
    }

    private void run() {
        playerX += x;
        playerY += y;

    }

    private void render() {
        backbufferGraphics.setColor(Color.black);
        backbufferGraphics.fillRect(0,0,1024,768);
        backbufferGraphics.drawImage(background,0,backgroundY,null);
        backgroundY +=2;
        backbufferGraphics.drawImage(straight_player,playerX,playerY,null);
        windowGraphics.drawImage(backbufferImage,0,0,null);

    }
}
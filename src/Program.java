import bases.physics.BoxCollider;
import touhou.GameWindow;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        gameWindow.loop();

        //BoxCollider a = new BoxCollider(0,0,30,30);
        //BoxCollider b = new BoxCollider(0,0,60,60);
        //System.out.println(a.intersects(b));
    }
}

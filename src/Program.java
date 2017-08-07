import touhou.GameWindow;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        gameWindow.loop();

        Character thelinh = new Character("Ling than", 2,6);
        System.out.println(thelinh);
    }
}

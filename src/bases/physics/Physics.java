package bases.physics;

import java.util.Vector;
import touhou.enemies.Enemy;
import touhou.enemies.EnemySpell;
import touhou.players.Player;

public class Physics {
    public static Vector<PhysicsBody> bodies = new Vector<>();

    public static <T extends PhysicsBody> T collideWith(BoxCollider boxCollider, Class<T> classz){
        for(PhysicsBody body : bodies) {
            if (body.isActive()) {
                if (body.getClass().equals(classz) && body.getBoxCollider().intersects(boxCollider)) {
                    return (T) body;
                }
            }
        }

        return null;

    }

    public static void add(PhysicsBody body) {
        bodies.add(body);
    }
}

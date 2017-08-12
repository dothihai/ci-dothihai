package bases.physics;

import java.util.Vector;
import touhou.enemies.Enemy;

public class Physics {
    public static Vector<PhysicsBody> bodies = new Vector<>();

    public static Enemy collideWithEnemy(BoxCollider boxCollider){
        for(PhysicsBody body : bodies) {
            if (body.isActive()) {
                if (body instanceof Enemy && body.getBoxCollider().intersects(boxCollider)) {
                    return (Enemy) body;
                }
            }
        }

        return null;

    }

    public static void add(PhysicsBody body) {
        bodies.add(body);
    }
}

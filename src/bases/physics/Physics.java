package bases.physics;

import java.util.Vector;
import touhou.enemies.Enemy;
import touhou.enemies.EnemySpell;
import touhou.players.Player;

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

    public static Player collideWithPlayer(BoxCollider boxCollider){
        for(PhysicsBody body : bodies){
            if(body.isActive()){
                if(body instanceof Player && body.getBoxCollider().intersects(boxCollider)){
                    return (Player) body;
                }
            }
        }
        return null;
    }

    public static EnemySpell collideWithEnemySpell(BoxCollider boxCollider){
        for(PhysicsBody body : bodies){
            if(body.isActive()){
                if(body instanceof EnemySpell && body.getBoxCollider().intersects(boxCollider)){
                    return (EnemySpell) body;
                }
            }
        }
        return null;
    }

    public static void add(PhysicsBody body) {
        bodies.add(body);
    }
}

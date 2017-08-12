package bases.physics;

import bases.GameObject;
import bases.Vector2D;

import java.util.Vector;

public class BoxCollider extends GameObject {

    private Vector2D position;
    private float width;
    private float height;

    public  BoxCollider (float x, float y, float width, float height){
        this.position = new Vector2D();
        this.width = width;
        this.height = height;
    }


    public BoxCollider(float width, float height){
        this(0,0,width,height);
    }

    public float left(){
        return this.screenPosition.x - this.width/2;
    }

    public float right(){
        return this.screenPosition.x + this.width/2;
    }
    public float bottom(){
        return this.screenPosition.y + this.height/2;
    }

    public float top(){
        return this.screenPosition.y - this.height/2;
    }

    public boolean intersects(BoxCollider other){
        return this.bottom() >=  other.top() && this.top() <= other.bottom() &&
                this.right() >= other.left() && this.left() <= other.right();

    }

    @Override
    public String toString() {
        return "BoxCollider{" +
                "position=" + position +
                ", width=" + width +
                ", height=" + height +
                ", screenPosition=" + screenPosition +
                '}';
    }
}

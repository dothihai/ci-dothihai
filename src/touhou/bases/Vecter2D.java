package touhou.bases;

import java.util.Vector;

public class Vecter2D {
    public float x;
    public float y;

    public Vecter2D() {
        this(0,0);

    }
    public Vecter2D(float x, float y){
        this.x = x;
        this.y = y;
    }
    public void addUp(float dx, float dy){
        this.x += dx;
        this.y += dy;
    }
    public void addUp(Vecter2D other){
        addUp(other.x, other.y);

    }
    public void subtractBy(float dx, float dy){
        this.x -= dx;
        this.y -= dy;

    }
    public void subtractBy(Vecter2D other){
        subtractBy(other.x, other.y);
    }
    public Vecter2D add(float dx, float dy){
        //Vecter2D newVector = new Vecter2D();
        //newVector.x = this.x + dx;
        return new Vecter2D(this.x + dx, this.y + dy);
    }
    public void add(Vecter2D other) {
        add(other.x + this.x, other.y + this.y);
    }

    public Vecter2D subtract(float dx, float dy){

        return new Vecter2D(this.x - dx, this.y - dy);
    }
    public void subtract( Vecter2D other){
        subtract(this.x - other.x, this.y - other.y);
    }

    public Vecter2D multiply(float f){
        return new Vecter2D(this.x * f, this.y * f);

    }

    public float magnitude(){
        return(float)Math.sqrt(this.x * this.x + this.y * this.y);
    }
    public Vecter2D normalize(){
        float mag = magnitude();
        return new Vecter2D(this.x / mag, this.y / mag);
    }
}


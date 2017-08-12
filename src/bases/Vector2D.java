package bases;

public class Vector2D {
    public float x;
    public float y;

    public Vector2D() {
        this(0,0);

    }
    public Vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }
    public Vector2D addUp(float dx, float dy){
        this.x += dx;
        this.y += dy;
        return this;
    }

    public Vector2D set(float x, float y){
        this.x = x;
        this.y = y;
        return this;
    }

    public Vector2D set(Vector2D other){
        set(other.x, other.y);
        return this;
    }
    public Vector2D addUp(Vector2D other){
         return addUp(other.x, other.y);

    }
    public Vector2D subtractBy(float dx, float dy){
        this.x -= dx;
        this.y -= dy;
        return this;
    }
    public Vector2D subtractBy(Vector2D other){
         return subtractBy(other.x, other.y);
    }
    public Vector2D add(float dx, float dy){
        //Vector2D newVector = new Vector2D();
        //newVector.x = this.x + dx;
        return new Vector2D(this.x + dx, this.y + dy);
    }
    public Vector2D add(Vector2D other) {
        return add(other.x + this.x, other.y + this.y);
    }

    public Vector2D subtract(float dx, float dy){

        return new Vector2D(this.x - dx, this.y - dy);
    }
    public void subtract( Vector2D other){
        subtract(this.x - other.x, this.y - other.y);
    }

    public Vector2D multiply(float f){
        return new Vector2D(this.x * f, this.y * f);

    }

    public float magnitude(){
        return(float)Math.sqrt(this.x * this.x + this.y * this.y);
    }
    public Vector2D normalize(){
        float mag = magnitude();
        return new Vector2D(this.x / mag, this.y / mag);
    }
}


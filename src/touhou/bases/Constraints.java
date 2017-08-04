package touhou.bases;

public class Constraints {
    public float top;
    public float bottom;
    public float left;
    public float right;

    public Constraints(float top, float bottom, float left, float right) {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
    }

    public void make(Vecter2D posittion){
        if(posittion.y < top) posittion.y = top;
        if(posittion.x < left) posittion.x = left;
        if(posittion.y > bottom) posittion.y = bottom;
        if(posittion.x > right) posittion.x = right;
    }
}


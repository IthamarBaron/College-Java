

public class Circle extends Shape {
    private float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    public float calculateArea() {
        return this.radius * this.radius * (float)(Math.PI);
    }

    public float calculatePerameter() {
        return this.radius * 2 * (float)(Math.PI); 
    }
}

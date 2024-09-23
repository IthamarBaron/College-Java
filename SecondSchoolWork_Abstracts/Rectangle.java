public class Rectangle extends Shape {
    private float sides[];

    public Rectangle(float sides[]) {
        this.sides = sides;
    }

    public float calculateArea() {
        return this.sides[0] * this.sides[1];
    }

    public float calculatePerameter() {
        return this.sides[0] * 2 + this.sides[1] * 2;
    }
}

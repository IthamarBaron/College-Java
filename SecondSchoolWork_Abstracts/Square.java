public class Square extends Shape {
    private float sides[];

    public Square(float sides[]) {
        this.sides = sides;
    }

    public float calculateArea() {
        return this.sides[0] * this.sides[1];
    }
    public float calculatePerameter() {
        return this.sides[0] * 4;
    }
}

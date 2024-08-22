package entities;

public class Rectangle {
    public double width, height;

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (height + width);
    }

    public double diagonal() {
        return Math.sqrt(Math.pow(height,2)+Math.pow(width,2));
    }
}

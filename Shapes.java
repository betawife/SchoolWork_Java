package SchoolWork;

// 抽象类Shapes
public abstract class Shapes {
    protected double perimeter;
    protected double area;

    public abstract void calculatePerimeter();
    public abstract void calculateArea();

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }
}

// 矩形类Rectangle
 class Rectangle extends Shapes {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        calculatePerimeter();
        calculateArea();
    }

    @Override
    public void calculatePerimeter() {
        perimeter = 2 * (width + height);
    }

    @Override
    public void calculateArea() {
        area = width * height;
    }
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }
    public double getRectangleArea(){
        return width * height;
    }

}

// 圆形类Circle
 class Circle extends Shapes {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        calculatePerimeter();
        calculateArea();
    }

    @Override
    public void calculatePerimeter() {
        perimeter = 2 * Math.PI * radius;
    }

    @Override
    public void calculateArea() {
        area = Math.PI * Math.pow(radius, 2);
    }
}

// 三角形类Triangle
class Triangle extends Shapes {
    private double sidea;
    private double sideb;
    private double sidec;

    public Triangle(double sidea, double sideb, double sidec) {
        this.sidea = sidea;
        this.sideb = sideb;
        this.sidec = sidec;
        calculatePerimeter();
        calculateArea();
    }

    @Override
    public void calculatePerimeter() {
        perimeter = sidea + sideb + sidec;
    }

    @Override
    public void calculateArea() {
        double p = (sidea + sideb + sidec) / 2;
        area = Math.sqrt(p * (p - sidea) * (p - sideb) * (p - sidec));
    }
}

// 框形类Box
class Box extends Rectangle {
    private double innerWidth;

    public Box(double outerWidth, double outerHeight, double innerWidth) {
        super(outerWidth, outerHeight);
        this.innerWidth = innerWidth;
        calculatePerimeter();
        calculateArea();
    }

    @Override
    public void calculatePerimeter() {
        perimeter = 2 * (super.getWidth()+ super.getHeight()) + 4 * innerWidth;
    }

    @Override
    public void calculateArea() {
        area = super.getRectangleArea() - innerWidth * innerWidth;
    }
}

// 测试类Test
class Test {
    public static void main(String[] args) {
        Shapes shapes[] = new Shapes[4];
        shapes[0] = new Rectangle(10, 5);
        shapes[1] = new Circle(7);
        shapes[2] = new Triangle(3, 4, 5);
        shapes[3] = new Box(10, 5, 2);

        for (Shapes shape : shapes) {
            System.out.println("周长：" + shape.getPerimeter());
            System.out.println("面积：" + shape.getArea());
        }
    }
}
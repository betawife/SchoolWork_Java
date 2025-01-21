package SchoolWork;

// 定义抽象的商品类
abstract class Product {
    private String productId;
    private String productName;
    private double price;

    public Product(String productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    abstract void showInfo();
}

// 定义食品子类
class Food extends Product {
    private String productionDate;
    private int shelfLife;
    private String mainIngredients;

    public Food(String productId, String productName, double price, String productionDate, int shelfLife, String mainIngredients) {
        super(productId, productName, price);
        this.productionDate = productionDate;
        this.shelfLife = shelfLife;
        this.mainIngredients = mainIngredients;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    @Override
    void showInfo() {
        System.out.println("Product ID: " + getProductName());
        System.out.println("Product Name: " + getProductName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Production Date: " + productionDate);
        System.out.println("Shelf Life: " + shelfLife + " days");
        System.out.println("Main Ingredients: " + mainIngredients);
    }
}

// 定义玩具子类
class Toy extends Product {
    private String model;
    private String material;
    private String safetyLevel;

    public Toy(String productId, String productName, double price, String model, String material, String safetyLevel) {
        super(productId, productName, price);
        this.model = model;
        this.material = material;
        this.safetyLevel = safetyLevel;
    }

    public void setSafetyLevel(String safetyLevel) {
        this.safetyLevel = safetyLevel;
    }

    @Override
    void showInfo() {
        System.out.println("Product ID: " + getProductName());
        System.out.println("Product Name: " + getProductName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Model: " + model);
        System.out.println("Material: " + material);
        System.out.println("Safety Level: " + safetyLevel);
    }
}

// 测试程序
public class TestProducts {
    public static void main(String[] args) {
        Food apple = new Food("001", "Apple", 0.99, "2021-09-01", 30, "Fuji Apple");
        Toy car = new Toy("002", "Car", 19.99, "Model X", "Plastic", "High");

        apple.showInfo();
        System.out.println();
        car.showInfo();
    }
}
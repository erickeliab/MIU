// Enum representing different types of fruits
enum FruitType {
    APPLE,
    BANANA,
    ORANGE
}

// Immutable class representing a fruit
final class Fruit {
    private final FruitType type;
    private final String color;

    public Fruit(FruitType type, String color) {
        this.type = type;
        this.color = color;
    }

    public FruitType getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color + " " + type;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create instances of immutable Fruit objects
        Fruit apple = new Fruit(FruitType.APPLE, "Red");
        Fruit banana = new Fruit(FruitType.BANANA, "Yellow");
        Fruit orange = new Fruit(FruitType.ORANGE, "Orange");

        // Display information about the fruits
        System.out.println("Apple: " + apple);
        System.out.println("Banana: " + banana);
        System.out.println("Orange: " + orange);

        // Attempt to modify the fruit type after creation (immutable)
        // This will result in a compilation error
        // apple.setType(FruitType.BANANA);
    }
}

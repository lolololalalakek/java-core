package Lesson12.FirstPart.Products;

import java.util.List;
import java.util.Comparator;

public class Stream {
    public static void main(String[] args) {
        record Product(String name, String category, double price) {}

        List<Product> products = List.of(
            new Product("Phone", "Electronics", 1200),
            new Product("TV", "Electronics", 1800),
            new Product("Apple", "Fruits", 2.5),
            new Product("Mango", "Fruits", 4.0)
        );

        // Самый дорогой товар в категории Electronics
        Product mostExpensiveElectronics = products.stream()
            .filter(p -> p.category().equals("Electronics"))
            .max(Comparator.comparingDouble(Product::price))
            .orElse(null);

        // Самый дорогой товар в категории Fruits
        Product mostExpensiveFruits = products.stream()
            .filter(p -> p.category().equals("Fruits"))
            .max(Comparator.comparingDouble(Product::price))
            .orElse(null);

        System.out.println("Most expensive in Electronics: "
            + mostExpensiveElectronics.name() + " ($" + mostExpensiveElectronics.price() + ")");
        System.out.println("Most expensive in Fruits: "
            + mostExpensiveFruits.name() + " ($" + mostExpensiveFruits.price() + ")");
    }
}

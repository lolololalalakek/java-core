package Lesson12.FirstPart.Products;

import java.util.List;

public class For {
    public static void main(String[] args) {
        record Product(String name, String category, double price) {}
        List<Product> products = List.of(
            new Product("Phone", "Electronics", 1200),
            new Product("TV", "Electronics", 1800),
            new Product("Apple", "Fruits", 2.5),
            new Product("Mango", "Fruits", 4.0));

        double maxElectronics = 0;
        String bestElectronics = "";

        double maxFruits = 0;
        String bestFruits = "";

        for (Product product : products) {
            if (product.category().equals("Electronics")) {
                if (product.price() > maxElectronics) {
                    maxElectronics = product.price();
                    bestElectronics = product.name();
                }
            }

            if (product.category().equals("Fruits")) {
                if (product.price() > maxFruits) {
                    maxFruits = product.price();
                    bestFruits = product.name();
                }
            }
        }

        System.out.println("Most expensive in Electronics: " + bestElectronics + " ($" + maxElectronics + ")");
        System.out.println("Most expensive in Fruits: " + bestFruits + " ($" + maxFruits + ")");
    }
}

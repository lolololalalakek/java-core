package lessons.lessons3.onlineStore;

import java.util.HashMap;
import java.util.Map;

public class OnlineStore {
    private final Map<Integer, Product> products = new HashMap<>();
//не дает присваивать ссылке новую коллекцию

    // Добавить товар
    public void addProduct(Product product) {
        if (products.containsKey(product.getCode())) {
            // если товар уже есть, просто увеличим количество
            Product existing = products.get(product.getCode());
            existing.setCount(existing.getCount() + product.getCount());
            System.out.println("Количество товара обновлено: " + existing.getName() +
                ", теперь на складе: " + existing.getCount());
        } else {
            products.put(product.getCode(), product);
            System.out.println("Товар добавлен: " + product.getName());
        }
    }

    // Купить товар
    public void buyProduct(int code, int quantity) {
        Product product = products.get(code);

        if (product == null) {
            System.out.println("Товар с кодом " + code + " не найден.");
            return;
        }

        if (product.getCount() >= quantity) {
            product.setCount(product.getCount() - quantity);
            System.out.println("Куплено " + quantity + " шт. товара: " + product.getName() +
                ". Остаток: " + product.getCount());
        } else {
            System.out.println("Недостаточно товара на складе. Доступно: " + product.getCount());
        }
    }

    // Информация о товаре
    public void getProductInfo(int code) {
        Product product = products.get(code);
        if (product != null) {
            System.out.println("Код: " + product.getCode() +
                ", Название: " + product.getName() +
                ", Цена: " + product.getPrice() +
                ", Количество: " + product.getCount());
        } else {
            System.out.println("Товар не найден.");
        }
    }

    // Все товары
    public void getProducts() {
        if (products.isEmpty()) {
            System.out.println("Магазин пуст.");
        } else {
            for (Product product : products.values()) {
                System.out.println("Код: " + product.getCode() +
                    ", Название: " + product.getName() +
                    ", Цена: " + product.getPrice() +
                    ", Количество: " + product.getCount());
            }
        }
    }
}

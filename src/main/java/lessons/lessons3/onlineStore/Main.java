package lessons.lessons3.onlineStore;

public class Main {

    public static void main(String[] args) {
        OnlineStore store = new OnlineStore();

        Product firstProduct = new Product(1, "Ноутбук", 50000, 5);
        Product secondProduct = new Product(2, "Смартфон", 30000, 10);
        Product thirdProduct = new Product(1, "Ноутбук", 50000, 3); // тот же код, увеличим количество

        store.addProduct(firstProduct);
        store.addProduct(secondProduct);
        store.addProduct(thirdProduct);

        System.out.println("\nВсе товары:");
        store.getProducts();

        System.out.println("\nПокупка:");
        store.buyProduct(1, 4);  // купить 4 ноутбука
        store.buyProduct(2, 12); // попытка купить слишком много

        System.out.println("\nИнфо по товару с кодом 1:");
        store.getProductInfo(1);
    }
}


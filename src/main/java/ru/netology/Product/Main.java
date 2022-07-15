package ru.netology.Product;

import ru.netology.Product.manager.ProductManager;
import ru.netology.Product.repository.ProductRepo;

public class Main {
    public static void main(String[] args) {
        ProductRepo repo = new ProductRepo();
        ProductManager manager = new ProductManager(repo);

        Product book1 = new Book(101, 250, "Harry potter", "Rowling");
        Product book2 = new Book(102, 300, "Airport", "Arthur Hailey");
        Product smartphone1 = new Smartphone(201, "Galaxy", "Samsung", 90_000);
        Product smartphone2 = new Smartphone(202, "iPhone", "Apple", 100_000);

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);

        manager.getAll();
        Product[] result1 = manager.searchBy("Gal");
        System.out.println(result1);


    }
}

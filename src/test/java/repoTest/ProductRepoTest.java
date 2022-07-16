package repoTest;

import ru.netology.Product.Book;
import ru.netology.Product.Product;
import ru.netology.Product.Smartphone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Product.Book;
import ru.netology.Product.Product;
import ru.netology.Product.Smartphone;
import ru.netology.Product.manager.ProductManager;
import ru.netology.Product.repository.ProductRepo;

public class ProductRepoTest {

    Product book1 = new Book(101, 250, "Harry potter", "Rowling");
    Product book2 = new Book(102, 300, "Airport", "Arthur Hailey");
    Product smartphone1 = new Smartphone(201, "Galaxy", "Samsung", 90_000);
    Product smartphone2 = new Smartphone(202, "iPhone", "Apple", 100_000);

    @Test
    public void repoSaveProductTest() {
        ProductRepo testRepo = new ProductRepo();

        Product[] actual = testRepo.saveProduct(book1);

        Product[] expected = {book1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void repoRemoveByIdTest() {

        ProductRepo testRepo = new ProductRepo();
        testRepo.saveProduct(book1);
        testRepo.saveProduct(book2);
        testRepo.saveProduct(smartphone1);
        testRepo.saveProduct(smartphone2);

        Product[] actual = testRepo.removeById(201);

        Product[] expected = {book1, book2, smartphone2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void repoFindAllTest() {
        ProductRepo testRepo = new ProductRepo();
        testRepo.saveProduct(book1);
        testRepo.saveProduct(book2);
        testRepo.saveProduct(smartphone1);
        testRepo.saveProduct(smartphone2);

        Product[] actual = testRepo.findAll();
        Product[] expected = {book1, book2, smartphone1, smartphone2};

        Assertions.assertArrayEquals(expected, actual);
    }
}

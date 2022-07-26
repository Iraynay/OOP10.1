package managerTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Product.Book;
import ru.netology.Product.Product;
import ru.netology.Product.Smartphone;
import ru.netology.Product.manager.ProductManager;
import ru.netology.Product.repository.ProductRepo;

public class ProductManagerTest {

    Product book1 = new Book(101, 250, "Harry potter", "Rowling");
    Product book2 = new Book(102, 300, "Airport", "Arthur Hailey");
    Product smartphone1 = new Smartphone(201, "Galaxy", "Samsung", 90_000);
    Product smartphone2 = new Smartphone(202, "iPhone", "Apple", 100_000);

    @Test
    public void managerAddTest() {
        ProductRepo repository = new ProductRepo();
        ProductManager testManager = new ProductManager(repository);

        testManager.add(book1);
        testManager.add(book2);
        Product[] actual = testManager.getAll();
        Product[] expected = {book2, book1};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void managerFindAllTest() {
        ProductRepo repository = new ProductRepo();
        ProductManager testManager = new ProductManager(repository);

        testManager.add(book1);
        testManager.add(book2);
        testManager.add(smartphone1);
        testManager.add(smartphone2);

        Product[] actual = testManager.getAll();
        Product[] expected = {smartphone2, smartphone1, book2, book1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void managerMatchesTest() {
        ProductRepo repository = new ProductRepo();
        ProductManager testManager = new ProductManager(repository);

        testManager.add(book1);
        testManager.add(book2);
        testManager.add(smartphone1);
        testManager.add(smartphone2);
        boolean actual = testManager.matches(book1, "Harry");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void managerSearchByTest() {
        ProductRepo repository = new ProductRepo();
        ProductManager testManager = new ProductManager(repository);

        testManager.add(book1);
        testManager.add(book2);
        testManager.add(smartphone1);
        testManager.add(smartphone2);
        Product[] actual = testManager.searchBy("Gal");
        Product[] expected = {smartphone1};

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void managerSearchByFewItemsInResultTest() {
        ProductRepo repository = new ProductRepo();
        ProductManager testManager = new ProductManager(repository);

        testManager.add(book1);
        testManager.add(book2);
        testManager.add(smartphone1);
        testManager.add(smartphone2);
        Product[] actual = testManager.searchBy("po");
        Product[] expected = {book1, book2};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void managerSearchByNoItemsInResultTest() {
        ProductRepo repository = new ProductRepo();
        ProductManager testManager = new ProductManager(repository);

        testManager.add(book1);
        testManager.add(book2);
        testManager.add(smartphone1);
        testManager.add(smartphone2);
        Product[] actual = testManager.searchBy("Krya");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void managerSearchByOneItemsInResultTest() {
        ProductRepo repository = new ProductRepo();
        ProductManager testManager = new ProductManager(repository);

        testManager.add(book1);
        testManager.add(book2);
        testManager.add(smartphone1);
        testManager.add(smartphone2);
        Product[] actual = testManager.searchBy("iPhone");
        Product[] expected = {smartphone2};

        Assertions.assertArrayEquals(expected, actual);

    }
}


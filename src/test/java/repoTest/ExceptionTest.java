package repoTest;

import ru.netology.Product.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Product.Book;
import ru.netology.Product.Product;
import ru.netology.Product.Smartphone;
import ru.netology.Product.manager.ProductManager;
import ru.netology.Product.repository.ProductRepo;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTest {

    Product book1 = new Book(101, 250, "Harry potter", "Rowling");
    Product book2 = new Book(102, 300, "Airport", "Arthur Hailey");
    Product smartphone1 = new Smartphone(201, "Galaxy", "Samsung", 90_000);
    Product smartphone2 = new Smartphone(202, "iPhone", "Apple", 100_000);

    @Test
    public void repoNotFoundIdExceptionTest() {

        ProductRepo testRepo = new ProductRepo();
        testRepo.saveProduct(book1);
        testRepo.saveProduct(book2);
        testRepo.saveProduct(smartphone1);
        testRepo.saveProduct(smartphone2);

        assertThrows(NotFoundException.class, () -> {
            testRepo.removeById(405);
        });

    }
}

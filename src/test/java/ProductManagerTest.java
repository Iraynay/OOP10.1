import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Product.Book;
import ru.netology.Product.Product;
import ru.netology.Product.Smartphone;
import ru.netology.Product.manager.ProductManager;
@NoArgsConstructor

public class ProductManagerTest {

    Product book1 = new Book(101, 250,"Harry potter", "Rowling");
    Product book2 = new Book (102, 300,"Airport", "Arthur Hailey");
    Product smartphone1 = new Smartphone(201,"Galaxy","Samsung", 90_000);
    Product smartphone2 = new Smartphone(202,"iPhone","Apple", 100_000);

        @Test
        public void managerFindAllTest() {
            ProductManager testManager = new ProductManager();

            testManager.add(book1);
            testManager.add(book2);
            testManager.add(smartphone1);
            testManager.add(smartphone2);

            Product[] actual = testManager.getAll();
            Product[] expected = {book1, book2, smartphone1, smartphone2};

            Assertions.assertArrayEquals (expected, actual);
        }

    }


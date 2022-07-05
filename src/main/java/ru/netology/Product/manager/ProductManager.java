package ru.netology.Product.manager;
import lombok.NoArgsConstructor;
import ru.netology.Product.Product;
import ru.netology.Product.repository.ProductRepo;

@NoArgsConstructor


public class ProductManager {
    private ProductRepo repository;
    public ProductManager (ProductRepo repository) {this.repository = repository;}
    private Product[] productItem = new Product[0];

    public void add (Product productItem) {repository.saveProduct(productItem);}
    public Product[] getAll(){
        Product[] productItem = repository.findAll();
        Product[] result = new Product[productItem.length];
        for (int i = 0; i < result.length; i++) {
            int index = productItem.length - i - 1;
            result[i] = productItem[index];
        }
        return result;
        }
    public Product[] searchBy(String query) {
        Product[] result = new Product[0];
        for (Product product: productItem)
            if (product.matches(query)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
            }
        return result;
    }

    }


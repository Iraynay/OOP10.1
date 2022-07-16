package ru.netology.Product.manager;

import lombok.NoArgsConstructor;
import ru.netology.Product.Product;
import ru.netology.Product.Smartphone;
import ru.netology.Product.repository.ProductRepo;

public class ProductManager {
    private ProductRepo repository;

    public ProductManager(ProductRepo repository) {
        this.repository = repository;
    }

    private Product[] productItem = new Product[0];

    public void add(Product productItem) {
        repository.saveProduct(productItem);
    }

    public Product[] getAll() {
        Product[] productItem = repository.findAll();
        Product[] result = new Product[productItem.length];
        for (int i = 0; i < result.length; i++) {
            int index = productItem.length - i - 1;
            result[i] = productItem[index];
        }
        return result;
    }

    public Boolean matches(Product product, String query) {
        if (product.getName().contains(query)) {
            return true;
        } else {
            return false;
        }

    }

    public Product[] searchBy(String query) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll())
            if (matches(product, query)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }

                tmp[tmp.length - 1] = product;
                result = tmp;
            }

        return result;
    }

}



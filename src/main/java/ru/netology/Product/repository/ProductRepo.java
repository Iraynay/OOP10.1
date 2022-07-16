package ru.netology.Product.repository;

import ru.netology.Product.Product;

public class ProductRepo {
    protected Product[] productItems = new Product[0];

    public Product[] saveProduct(Product item) {
        int length = productItems.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(productItems, 0, tmp, 0, productItems.length);
        int lastItem = tmp.length - 1;
        tmp[lastItem] = item;
        productItems = tmp;
        return tmp;
    }

    public Product[] removeById(int id) {
        int length = productItems.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : productItems) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        return tmp;
    }

    public Product[] findAll() {
        Product[] allResult = new Product[productItems.length];
        for (int i = 0; i < allResult.length; i++) {
            int index = i;
            allResult[i] = productItems[index];
        }
        return allResult;
    }

}


//public void saveSmartphone ( Smartphone item) {
//    int length = smartphoneItems.length + 1;
//    Smartphone [] tmp = new Smartphone[length];
//    System.arraycopy (smartphoneItems,0,tmp,0,length);
//    int lastItem = tmp.length -1;
//    tmp[lastItem] = item;
//    smartphoneItems = tmp;
//}
//
//    public void saveBook ( Book item) {
//        int length = bookItems.length + 1;
//        Book [] tmp = new Book[length];
//        System.arraycopy (bookItems,0,tmp,0,length);
//        int lastItem = tmp.length -1;
//        tmp[lastItem] = item;
//        bookItems = tmp;
//    }

//    public void removeBookById (int id) {
//        int length = bookItems.length + 1;
//        Book [] tmp = new Book[length];
//        int index = 0;
//        for (Book item : bookItems) {
//            if (item.getId() != id) {
//                    tmp[index] = item;
//                    index ++;
//        }
//        }
//    }
//
//    public void removeSmartphoneById (int id) {
//        int length = smartphoneItems.length + 1;
//        Smartphone [] tmp = new Smartphone[length];
//        int index = 0;
//        for (Smartphone item : smartphoneItems) {
//            if (item.getId() != id) {
//                tmp[index] = item;
//                index ++;
//            }
//        }
//    }

//    public Book[] findAllBooks() {
//        Book[] allResult = new Book[bookItems.length];
//        for (int i = 0; i< allResult.length; i++) {
//            int index = i;
//            allResult[i] = bookItems [index];
//        }
//        return allResult;
//    }

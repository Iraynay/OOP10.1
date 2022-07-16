package ru.netology.Product;

public class Book extends Product {
    public String author;

    public Book(int id, int cost, String name, String author) {
        super(id, name, cost);
        this.author = author;
    }

    public String setAuthor(String author) {
        this.author = author;
        return author;
    }

    public String getAuthor() {
        return author;
    }

//        @Override
//    public Boolean matches(String query) {
//            if (super.matches(query)) {
//                return true;
//            }
//            if (author.contains(query)) {
//                return true;
//            }
//            return false;
//        }
}


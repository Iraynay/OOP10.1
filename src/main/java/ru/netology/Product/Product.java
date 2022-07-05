package ru.netology.Product;


public class Product {


    public Product(int id, String name, int cost) {
    }
    public int id;
    public String name;
    public int cost;

    public int getId () {
        return id;
    }

    public String getName () {
        return name;
    }

    public int getCost () {
        return cost;
    }
    public Boolean matches(String query) {
        if (name.contains (query)) {
            return true;
        }
        return false;
    }
    }

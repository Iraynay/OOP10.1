package ru.netology.Product;

public class Smartphone extends Product {
    public String manufacturer;

    public String setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return manufacturer;
    }
    public String getManufacturer () {
        return manufacturer;
    }

    public Smartphone(int id, String name, String manufacturer, int cost) {
        super(id, name, cost);
        this.manufacturer = manufacturer;
    }
    @Override
    public Boolean matches(String query) {
        if (super.matches(query)) {
            return true;
        }
        if (manufacturer.contains(query)) {
            return  true;
        }
        return  false;
    }
}
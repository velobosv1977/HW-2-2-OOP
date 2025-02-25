package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

// Базовый класс продуктов
public abstract class Product implements Searchable {
    private final String nameProduct;

    public Product(String nameProduct) {

        this.nameProduct = nameProduct;
    }

    public String getNameProduct() {

        return nameProduct;
    }

    public abstract int getPriceProduct();

    // проверка на специальный продукт
    public boolean isSpecial() {

        return false;
    }

    @Override
    public String getSearchTerm() {
        return nameProduct;
    }

    @Override
    public String getSearchContentType() {
        return "PRODUCT";
    }
    @Override
    public String toString() {
        return nameProduct;
    }
}


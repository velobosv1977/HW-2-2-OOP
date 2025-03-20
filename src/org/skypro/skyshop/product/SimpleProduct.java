package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int priceProduct;

    public SimpleProduct(String nameProduct, int priceProduct) {
        super(nameProduct);
        if (nameProduct == null || nameProduct.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя продукта не может быть пустым или null");
        }
        if (priceProduct <=0) {
            throw new IllegalArgumentException("Цена продукта должна быть строго больше 0, введено: " + priceProduct);
        }
        this.priceProduct =  priceProduct ;
    }

    @Override
    public int getPriceProduct() {
        return priceProduct;
    }
    @Override
    public String toString() {return getNameProduct() + "  Базовая цена: " +getPriceProduct(); }
}

package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int priceProduct;

    public SimpleProduct(String nameProduct, int priceProduct) {
        super(nameProduct);
        this.priceProduct =  priceProduct ;
    }

    @Override
    public int getPriceProduct() {
        return priceProduct;
    }
    @Override
    public String toString() {return getNameProduct() + " : " +getPriceProduct(); }
}

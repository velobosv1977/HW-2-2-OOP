package org.skypro.skyshop.product;

//класс продуктов с объявленной скидкой

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discount;

    public DiscountedProduct(String nameProduct, int basePrice, int discount) {
        super(nameProduct);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPriceProduct() {
        return basePrice - (int) ((double) (basePrice * discount) / 100.0);
    }

    @Override
    public String toString() {
        return getNameProduct() + " : " + getPriceProduct() + " (скидка " + discount + " %)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}

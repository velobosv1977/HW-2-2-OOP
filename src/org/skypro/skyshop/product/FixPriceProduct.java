package org.skypro.skyshop.product;
//класс продуктов с фиксированной ценой
public class FixPriceProduct extends Product {
    private final static int PRICE_PRODUCT = 555;

    public FixPriceProduct(String nameProduct) {
        super(nameProduct);
    }

    @Override
    public int getPriceProduct() {
        return PRICE_PRODUCT;
    }

    @Override
    public String toString() {
        return getNameProduct() + ": Фиксированная цена " + PRICE_PRODUCT;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}

package org.skypro.skyshop.product;

//класс продуктов с объявленной скидкой

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discount;

    public DiscountedProduct(String nameProduct, int basePrice, int discount) {
        super(nameProduct);
        if (basePrice <=1) {
            throw new IllegalArgumentException("Значение цены продукта/товара должно быть строго больше 0");
        }
        this.basePrice = basePrice;
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Значение скидки на продукт/товар должно быть в диапазоне от 0 до 100 включительно 0");
        }
        this.discount = discount;
    }

    @Override
    public int getPriceProduct() {
        return basePrice - (int) ((double) (basePrice * discount) / 100.0);
    }

    @Override
    public String toString() {
        return getNameProduct() + "Базовая цена: " + basePrice + " (скидка " + discount + " %) , Цена со скидкой: " + getPriceProduct() + ")";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}

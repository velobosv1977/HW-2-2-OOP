package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    public static final int VOLUME_BUSKET_PRODUCTS = 5;
    private final Product[] products;

    public static final int NOT_FOUND = -1;

    public ProductBasket() {
        products = new Product[VOLUME_BUSKET_PRODUCTS];
    }

    public void add(Product product) {
        int freeIndex = getFreeIndex();
        if (freeIndex == NOT_FOUND) {
            System.out.println("Невозможно добавить продукт!  \"" + product.getNameProduct() + "\"");
            return;
        }
        products[freeIndex] = product;
    }

    public int getTotalCost() {
        int sum = 0;
        for (Product product : products) {
            if (product != null) {
                sum += product.getPriceProduct();
            }
        }
        return sum;
    }

    public void print() {
        if (getProductCount() <= 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getNameProduct() + ":  " + product.getPriceProduct());
            }
        }
        System.out.println("Итого: " + getTotalCost());
        System.out.println("Добавлено специальных товаров: " + getSpecialProductCount());
    }

    public boolean findByNameProduct(String title) {
        for (Product product : products) {
            if (product != null && product.getNameProduct().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        Arrays.fill(products, null);
    }

    public int getSpecialProductCount() {
        int count = 0;
        for (Product product : products) {
            if (product != null) {
                if (product.isSpecial()) {
                    count++;
                }
            }
        }
        return count;
    }

    private int getFreeIndex() {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    private int getProductCount() {
        int count = 0;
        for (Product product : products) {
            if (product != null) {
                count++;
            }
        }
        return count;
    }
}

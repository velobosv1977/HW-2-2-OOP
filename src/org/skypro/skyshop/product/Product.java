package org.skypro.skyshop.product;

public class Product {
    private String nameProduct;
    private Integer priceProduct;

    public Product(String nameProduct, Integer priceProduct) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public Integer getPriceProduct() {
        return priceProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setPriceProduct(Integer priceProduct) {
        this.priceProduct = priceProduct;
    }
}

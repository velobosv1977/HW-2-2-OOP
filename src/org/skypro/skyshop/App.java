package org.skypro.skyshop;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// формирование корзины


import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        //наполнение корзины
        Product milk = new SimpleProduct( "Молоко", 106);
        Product meat = new SimpleProduct("Говядина", 850);
        Product potato = new DiscountedProduct("Картофель", 94, 15);
        Product rice = new SimpleProduct("Рис", 73);
        Product tea = new FixPriceProduct("Чай");
        Product candy = new DiscountedProduct("Конфеты", 621, 15);

        ProductBasket basket = new ProductBasket();

        basket.add(milk);
        basket.add(meat);
        basket.add(potato);
        basket.add(rice);
        basket.add(tea);

        //добавим товар в заполненную корзину:
        basket.add(candy);

        //вывод в консоль содержимого корзины
        basket.print();

        //вывод в консоль общей стоимости продуктов в корзине
        System.out.println("Итого ваш заказ на сумму:" + basket.getTotalCost());

        //поиск товаров в корзине
        System.out.println("Поиск товара в корзине:  " + rice.getNameProduct() + " товар найден :" + basket.findByNameProduct(rice.getNameProduct()));

        //поиск товаров, не попавших в корзину
        System.out.println("Поиск товара в корзине:  " + candy.getNameProduct() + " товар найден :" + basket.findByNameProduct(candy.getNameProduct()));

        //очистка корзины
        basket.clear();

        //содержимое очищенной корзины
        basket.print();

        //вывод в консоль стоимости товаров в очищенной корзины
        System.out.println("В корзине товаров на сумму:  " +basket.getTotalCost());

        //вывод в консоль результатов поиска товаров в очищенной корзине
        System.out.println("Поиск товара " + potato.getNameProduct() + "   в корзине  " +basket.findByNameProduct(potato.getNameProduct()));

    }
}

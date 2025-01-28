package org.skypro.skyshop;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// формирование корзины


import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        //наполнение корзины
        Product milk = new Product("Молоко", 106);
        Product meat = new Product("Говядина", 850);
        Product potato = new Product("Картофель", 94);
        Product rice = new Product("Рис", 73);
        Product tea = new Product("Чай", 267);
        Product candy = new Product("Конфеты", 621);

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

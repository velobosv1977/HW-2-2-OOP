package org.skypro.skyshop;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// формирование корзины


import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        //наполнение корзины
        Product milk = new SimpleProduct("Молоко", 106);
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
        System.out.println("Итого ваш заказ на сумму: " + basket.getTotalCost());

        //поиск товаров в корзине
        System.out.println("Поиск товара в корзине:  " + rice.getNameProduct() + " товар найден :" + basket.findByNameProduct(rice.getNameProduct()));

        //поиск товаров, не попавших в корзину
        System.out.println("Поиск товара в корзине:  " + candy.getNameProduct() + " товар найден :" + basket.findByNameProduct(candy.getNameProduct()));

        //очистка корзины
        basket.clear();

        //содержимое очищенной корзины
        basket.print();

        //вывод в консоль стоимости товаров в очищенной корзины
        System.out.println("В корзине товаров на сумму:  " + basket.getTotalCost());

        //вывод в консоль результатов поиска товаров в очищенной корзине
        System.out.println("Поиск товара " + rice.getNameProduct() + "   в корзине  " + basket.findByNameProduct(potato.getNameProduct()));

        //создание объекта SearchEngine для поиска товаров
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(milk);

        //создание объектов для класса Article
        Article aboutMilk = new Article("Молоко это пищевой продукт, ", "питательную жидкость, вырабатываемая молочными железами самок млекопитающих во время лактации.");
        Article aboutMeat = new Article("Мясо это пищевой продукт,", "полученный в результате забоя сельскохозяйственных животных специальных мясных пород на скотобойнях.");
        Article aboutPotato = new Article("Картофель это пищевой продукт,", "представляющий собой клубни травянистых растений из семейства Пасленовых. С потребительской точки зрения картофель является овощем.");
        Article aboutRice = new Article("Рис это пищевой продукт,", "крупа, полученная путём выращивания растения из рода Рис однолетних и многолетних травянистых растений семейства Злаки.");
        Article aboutTea = new Article("Чай это напиток,", "получаемый варкой, завариванием и/или настаиванием листа чайного куста, который предварительно подготавливается специальным образом.");
        Article aboutCandy = new Article("Конфеты это кондитерские изделия, ", "характеризуются высоким содержанием сахара и мягкой консистенцией.");

        //добавим созданные объекты для класса Article в класс для поиска SearchEngine
        searchEngine.addAll(aboutTea);

        //демонстрация поиска при помощи созданного интерфейса searchEngine

        String demand1 = "Молоко";
        System.out.println("Результат поиска: " + demand1 + "\": " + Arrays.toString(searchEngine.search(demand1)));

        String demand2 = "Кефир";
        System.out.println("Результат поиска: " + demand2 + "\": " + Arrays.toString(searchEngine.search(demand2)));

        String demand3 = "Конфеты";
        System.out.println("Результат поиска: " + demand3 + "\": " + Arrays.toString(searchEngine.search(demand3)));

        String demand4 = "Чай";
        System.out.println("Результат поиска: " + demand4 + "\": " + Arrays.toString(searchEngine.search(demand4)));

        // демонстрация работы исключений в классе Product и в классе SimpleProduct
        System.out.println("/");
        System.out.println("Демонстрация работы исключений в абстрактном классе Product и SimpleProduct:");
        try {
            Product fish = new SimpleProduct("Селедка", -231);
            System.out.println(fish);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        // демонстрация работы исключений в классе DiscountedProduct
        System.out.println("/");
        System.out.println("Демонстрация работы исключений в классе DiscountedProduct:");
        try {
            DiscountedProduct tomato = new DiscountedProduct("Помидор  ", 324, 11);
            System.out.println(tomato);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
        }
    }
}

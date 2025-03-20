package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        // Создаем экземпляр в классе SearchEngine с размером 5
        SearchEngine searchEngine = new SearchEngine(7);
        // Создаем несколько объектов Searchable
        //создание объектов для класса Article
        Article aboutMilk = new Article("Молоко это пищевой продукт, ", "питательную жидкость, вырабатываемая молочными железами самок млекопитающих во время лактации.");
        Article aboutMeat = new Article("Мясо это пищевой продукт,", "полученный в результате забоя сельскохозяйственных животных специальных мясных пород на скотобойнях.");
        Article aboutPotato = new Article("Картофель это пищевой продукт,", "представляющий собой клубни травянистых растений из семейства Пасленовых. С потребительской точки зрения картофель является овощем.");
        Article aboutRice = new Article("Рис это пищевой продукт,", "крупа, полученная путём выращивания растения из рода Рис однолетних и многолетних травянистых растений семейства Злаки.");
        Article aboutTea = new Article("Чай это напиток,", "получаемый варкой, завариванием и/или настаиванием листа чайного куста, который предварительно подготавливается специальным образом.");
        Article aboutCandy = new Article("Конфеты это кондитерские изделия, ", "характеризуются высоким содержанием сахара и мягкой консистенцией.");

        //добавим созданные объекты для класса Article в класс для поиска SearchEngine
        searchEngine.addAll(aboutTea, aboutCandy, aboutRice, aboutPotato, aboutMeat, aboutMilk);

        // Проверяем, когда нужный объект существует
        try {
            Searchable bestMatch = searchEngine.findBestMatch("milk");
            System.out.println("Лучший результат найден: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Теперь проверим случай, когда метод выбрасывает исключение
        try {
            Searchable bestMatch = searchEngine.findBestMatch("рыба");
            System.out.println("Лучший результат найден: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}







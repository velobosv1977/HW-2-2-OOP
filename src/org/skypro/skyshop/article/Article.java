package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;
//создание класса Article для описания продуктов/товаров
public class Article implements Searchable {
    private final String title;
    private final String content;
    private final String calorie;

    public Article (String title, String content, String calorie) {
        this.title = title;
        this.content = content;
        this.calorie = calorie;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getCalorie() {
        return calorie;
    }

    @Override
    public String toString() {
        return title + "\n" + content + "\n" +calorie;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }
    @Override
    public String getSearchContentType() {
        return "ARTICLE";
    }

}

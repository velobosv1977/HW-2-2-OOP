package org.skypro.skyshop.search;
// создание интерфейса поиска
public interface Searchable {
    String getSearchTerm();

    String getSearchContentType();

    default String getStringRepresentation() {
        return this.getClass().getSimpleName() + "-" + getSearchContentType();
    }
}

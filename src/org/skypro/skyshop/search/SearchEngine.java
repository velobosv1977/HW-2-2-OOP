package org.skypro.skyshop.search;
// класс организации поиска
public class SearchEngine {
    private final Searchable[] searchables;
    private static final int MAX_SEARCH_RESULTS = 100;
    private static final int NOT_FOUND = -1;
    private static final int DEFAULT_SIZE = 10;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public SearchEngine() {
        this.searchables = new Searchable[DEFAULT_SIZE];
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[MAX_SEARCH_RESULTS];
        int i = 0;
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().contains(query)) {
                results[i++] = searchable;
                if (i >= MAX_SEARCH_RESULTS) {
                    break;
                }
            }
        }
        // возвращение заполненных элементов
        return (i == 0) ? new Searchable[0] : java.util.Arrays.copyOf(results, i);
    }
    public Searchable findBestMatch(String query) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxOccurrences = 0;
        //вычисление количество повторов в строке:
        for (Searchable searchable : searchables) {
            if (searchable != null) {
                int currentOccurrences = countOccurrences(searchable.getSearchTerm(), query);
                if (currentOccurrences > maxOccurrences) {
                    maxOccurrences = currentOccurrences;
                    bestMatch = searchable;
                }
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound("Нет подходящих условий для запроса: " + query);
        }
        //возвращает наиболее частую встречу, при этом если условия поиска null должна быть надпись выше
        return bestMatch;
    }

    private int countOccurrences(String string, String subString) {
        int count = 0;
        int index = 0;

        while ((index = string.indexOf(subString, index)) != -1) {
            count++;
            index += subString.length();
        }
        return count;
    }

    public void add(Searchable searchable) {
        int freeIndex = getFreeIndex();
        if (freeIndex == NOT_FOUND) {
            System.out.println("Невозможно добавить элемент для поиска");
            return;
        }
        searchables[freeIndex] = searchable;
    }

    public void addAll(Searchable... searchables) {
        for (Searchable searchable : searchables) {
            add(searchable);
        }
    }

    private int getFreeIndex() {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                return i;
            }
        }
        return NOT_FOUND;
    }
}

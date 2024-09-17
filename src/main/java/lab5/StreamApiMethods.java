package main.java.lab5;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamApiMethods {
    // Task 1
    // метод, возвращающий среднее значение списка целых чисел
    public static double getAverageValue(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics()
                .getAverage();
    }

    // Task 2
    // метод, приводящий все строки в списке в верхний регистр и
    // добавляющий к ним префикс «_new_»
    public static List<String> getUppercaseStrings(List<String> list) {
        return list.stream()
                .map(str -> "_new_" + str.toUpperCase())
                .toList();
    }

    // Task 3
    // метод, возвращающий список квадратов всех встречающихся
    // только один раз элементов списка
    public static List<Integer> getSquaresList(List<Integer> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .map(n -> n * n)
                .toList();
    }

    // Task 4
    // метод, принимающий на вход коллекцию строк и возвращающий
    // все строки, начинающиеся с заданной буквы, отсортированные по
    // алфавиту
    public static List<String> getSortedStrings(Collection<String> list, String startLetter) {
        return list.stream()
                .filter(n -> n.startsWith(startLetter))
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .toList();
    }

    // Task 5
    // метод, принимающий на вход коллекцию и возвращающий её последний
    // элемент или кидающий исключение, если коллекция пуста
    public static <T> T getLastElementOfCollection(Collection<T> collection) {
        return collection.stream()
                .reduce((a, b) -> b)
                .orElseThrow(() -> new NoSuchElementException("Collection is empty."));
    }

    // Task 6
    // метод, принимающий на вход массив целых чисел, возвращающий
    // сумму чётных чисел или 0, если чётных чисел нет
    public static int getSumEvenNumber(int[] a) {
        return Arrays.stream(a)
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    // Task 7
    // метод, преобразовывающий все строки в списке в Map, где первый
    // символ – ключ, оставшиеся – значение
    public static Map<Character, String> getStringMap(List<String> list) {
        return list.stream()
                .collect(Collectors.toMap(str -> str.charAt(0), str -> str.substring(1)));
    }
}

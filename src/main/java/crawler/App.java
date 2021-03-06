/*
 * This Java source file was generated by the Gradle 'init' task.
 */

/**
 * TODO:create MyCrawler and Controller
 */

package crawler;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Integer> prices = (ArrayList<Integer>) new Parser("https://vancouver.craigslist.org/search/sss?query=playstation+4+pro&sort=rel")
                        .getElementsByClass("result-price").stream()
                        .map(price -> Integer.parseInt(price.substring(1)))
                        .sorted()
                        .collect(Collectors.toList());

        prices.stream().forEach(System.out::println);

        int min = prices.stream().min(Integer::compareTo).get();
        int max = prices.stream().max(Integer::compareTo).get();
        Double ave = prices.stream().flatMapToInt(price -> IntStream.of(price)).average().getAsDouble();

        System.out.println("min price" + min);
        System.out.println("max price" + max);
        System.out.println("ave price" + ave);
    }
}

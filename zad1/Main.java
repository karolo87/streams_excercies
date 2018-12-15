package com.sda.javagda22.zad1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Post> posty = new ArrayList<>();


        //////////Posty i komentarze: //////////////

        posty.add(new Post("Java 8 wprowadza strumienie",
                "java 8,strumienie", 519,
                new Komentarz("Super!"),
                new Komentarz("Leniwe przetwarzanie, mega :)")));
        posty.add(new Post("Nowe API dla plików NIO",
                "java 8,file api,nio api", 7220));
        posty.add(new Post("Przetwarzanie równoległe strumieni",
                "JAVA 8,STRUMIENIE", 3125,
                new Komentarz("WOW!")));
        posty.add(new Post("NullPointerException? Poznaj Optional",
                "java 8,null pointer exception,optional", 3125,
                new Komentarz("No, teraz to będę miał problem z głowy")));

        //////////Wywołanie metod: ////////////

        metoda_1(posty);
        System.out.println();
        metoda_2(posty).forEach(post -> System.out.println(post.getTemat() + " -> " + post.getLiczbaZnakow()));
        System.out.println();
        metoda_2b(posty).forEach(post -> System.out.println(post.getTemat() + " -> " + post.getLiczbaZnakow()));
        System.out.println();
        metoda_3(posty).forEach(post -> System.out.println(post.getTemat() + " -> " + post.getLiczbaZnakow()));
        System.out.println();
        metoda_4(posty).forEach(post -> System.out.println(post.getTemat() + " -> " + post.getLiczbaZnakow()));
        System.out.println();
        metoda_5(posty).forEach(post -> System.out.println(post.getTemat() + " -> " + post.getLiczbaZnakow()));
        System.out.println();
        metoda_6(posty).forEach(post -> System.out.println(post.getTemat() + " -> " + post.getLiczbaZnakow()));
        System.out.println();
        System.out.println(metoda_7(posty));
        System.out.println();
        System.out.println(metoda_8(posty));
        System.out.println(metoda_9(posty));
        final Optional<Post> opcjonalnyPost = metoda_10(posty);
        if (opcjonalnyPost.isPresent()) {
            final Post post = opcjonalnyPost.get();
            System.out.println(post.getTemat());
        }

        metoda_12(posty).forEach(System.out::println);

        System.out.println(metoda_13(posty));

        metoda_14(posty).forEach(System.out::println);

        System.out.println(metoda_15(posty));
    }



    static void metoda_1(List<Post> posty) {

        posty.stream()
                .peek(post -> System.out.println(post.getTemat()))
                .collect(Collectors.toList());

    }


    static List<Post> metoda_2(List<Post> posty) {
        return posty.stream()
                .sorted(Comparator.comparingInt(Post::getLiczbaZnakow))
                .collect(Collectors.toList());
    }


    static List<Post> metoda_2b(List<Post> posty) {
        return posty.stream()
                .sorted((post1, post2) -> Integer.compare(post2.getLiczbaZnakow(), post1.getLiczbaZnakow()))
                .collect(Collectors.toList());
    }


    static List<Post> metoda_3(List<Post> posty) {
        return posty.stream()
                .limit(2)
                .collect(Collectors.toList());
    }


    static List<Post> metoda_4(List<Post> posty) {
        return posty.stream()
                .skip(2)
                .collect(Collectors.toList());
    }


    static List<Post> metoda_5(List<Post> posty) {
        return posty.stream()
                .filter(post -> post.getLiczbaZnakow() < 5000)
                .collect(Collectors.toList());
    }


    static List<Post> metoda_6(List<Post> posty) {
        return posty.stream()
                .filter(post -> post.getTemat().contains("Java"))
                .collect(Collectors.toList());
    }


    static boolean metoda_7(List<Post> posty) {
        return posty.stream()
                .allMatch(post -> {
                    return post.getTemat().contains("x");
                });
    }


    static boolean metoda_8(List<Post> posty) {
        return posty.stream()
                .anyMatch(post -> post.getLiczbaZnakow() > 5000);
    }


    static boolean metoda_9(List<Post> posty) {
        return posty.stream()
                .noneMatch(post -> {
                    final String tagi = post.getTagi();
                    final String[] tablicaTagow = tagi.split(",");
                    return tablicaTagow.length > 1;
                });
    }


    static Optional<Post> metoda_10(List<Post> posty) {
        return posty.stream()
                .filter(post -> post.getTemat().contains("Java"))
                .findFirst();
    }


    static Optional<Post> metoda_11(List<Post> posty) {
        return posty.stream()
                .filter(post -> post.getTemat().contains("elemelek"))
                .findAny();
    }


    static List<String> metoda_12(List<Post> posty) {
        return posty.stream()
                .map(Post::getTemat)
                .collect(Collectors.toList());
    }


    static int metoda_13(List<Post> posty) {
        return posty.stream()
                .mapToInt(Post::getLiczbaZnakow)
                .sum();
    }


    static OptionalInt metoda_13b(List<Post> posty) {
        return posty.stream()
                .mapToInt(Post::getLiczbaZnakow)
                .reduce(Integer::sum);
    }


    static List<Komentarz> metoda_14(List<Post> posty) {
        final Stream<Komentarz> strumienWszystkichKomentarzy = posty.stream()
                .flatMap(post -> post.getKomentarze().stream());

        return strumienWszystkichKomentarzy.collect(Collectors.toList());
    }


    static List<String> metoda_15(List<Post> posty) {
        final Stream<String> strumienWszystkichTagow = posty.stream()
                .flatMap(post -> {
                    final String[] tablicaTagowDanegoPosta = post.getTagi().split(",");
                    final Stream<String> strumienTagowDanegoPosta = Arrays.stream(tablicaTagowDanegoPosta);
                    return strumienTagowDanegoPosta;
                });
        return strumienWszystkichTagow
                .distinct()
                .collect(Collectors.toList());

    }

}

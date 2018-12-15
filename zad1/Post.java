package com.sda.javagda22.zad1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Post {
    public static final List<Post> posty = new ArrayList<>();

//    {
//        posty.add(new Post("Java 8 wprowadza strumienie",
//                "java 8,strumienie", 519,
//                new Komentarz("Super!"),
//                new Komentarz("Leniwe przetwarzanie, mega :)")));
//        posty.add(new Post("Nowe API dla plików NIO",
//                "java 8,file api,nio api", 7220));
//        posty.add(new Post("Przetwarzanie równoległe strumieni",
//                "JAVA 8,STRUMIENIE", 3125,
//                new Komentarz("WOW!")));
//        posty.add(new Post("NullPointerException? Poznaj Optional",
//                "java 8,null pointer exception,optional", 3125,
//                new Komentarz("No, teraz to będę miał problem z głowy")));
//    }
    private String temat;
    private String tagi;
    private int liczbaZnakow;
    private List<Komentarz> komentarze;

    public Post(String temat, String tagi, int liczbaZnakow, Komentarz ... komentarz) {
        super();
        this.temat = temat;
        this.tagi = tagi;
        this.liczbaZnakow = liczbaZnakow;
        if (komentarz != null);
        komentarze = Arrays.asList(komentarz);
    }

    public String getTemat() {
        return temat;
    }

    public String getTagi() {
        return tagi;
    }

    public int getLiczbaZnakow() {
        return liczbaZnakow;
    }

    public List<Komentarz> getKomentarze() {
        return komentarze;
    }
}

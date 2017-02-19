package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	    String[] str = new String[]{"qwe 1", "qwe 2", "qwe 3"};
        changeElements(str, 1, 2);
        System.out.println(str[1] + " | " + str[2]);


        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 6, 89, 56, 34, 56, 78, 98, 234};
        System.out.println(findTheBiggest(integers, 6, 11));


        List <Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer[] arr = new Integer[]{9, 8, 7};

        Object[] resArr = convertListArray(list);
        System.out.println(resArr[0]);

        List res = convertListArray(arr);
        System.out.println(res.get(0));


        Book book = new Book("Java8", "Shildt");
        Video video = new Video("Truman", 120);
        Newspaper newspaper = new Newspaper("Times", "NewYork");

        Library library = new Library(book, video, newspaper);
        System.out.println(library.getMedia("Java8"));

        Library2 library2 = new Library2(book, video, newspaper);
        System.out.println(library2.getMedia("Java8"));
    }

    // N_1
    public static <T> void changeElements(T[] t, int i1, int i2){
        if (i1 >= t.length || i2 >= t.length || i1 < 0 || i2 < 0){
            return;
        }
        T temp = t[i1];
        t[i1] = t[i2];
        t[i2] = temp;
    }

    //N_2
    public static <T extends Number> T findTheBiggest(T[] t, int start, int end){
        if (start >= end || start >= t.length || start < 0 || end >= t.length || end < 0){
            return null;
        }
        T res = null;
        for (int i = start; i <= end; i++){
            if (res == null || res.doubleValue() < t[i].doubleValue()){
                res = t[i];
            }
        }
        return res;
    }

    //N_3
    public static <T> List convertListArray(T[] t){
        List list = new ArrayList();
        for (int i = 0; i < t.length; i++){
            list.add(t[i]);
        }
        return list;
    }

    public static <T> T[] convertListArray(List<T> t){
        T[] res;
        res = t.toArray((T[]) new Object[t.size()]);
        return res;
    }
}

class Library <T extends Media>{
    private Map<String, T> lib = new HashMap<>();

    Library(T... t){
        for (T cur: t) {
            this.lib.put(cur.getName(), cur);
        }
    }

    public T getMedia(String name){
        return lib.get(name);
    }
}

class Library2 {
    private Map<String, Media> lib = new HashMap<String, Media>();

    Library2(Media... m){
        for (Media cur: m) {
            this.lib.put(cur.getName(), cur);
        }
    }

    public Media getMedia(String name){
        return lib.get(name);
    }
}


abstract class Media{
    private String name;

    Media(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Book extends Media{
    private String author;

    Book(String name, String author){
        super(name);
        this.author = author;
    }
}

class Video extends Media{
    private int time;

    Video(String name, int time){
        super(name);
        this.time = time;
    }
}

class Newspaper extends Media{
    private String city;

    Newspaper(String name, String city){
        super(name);
        this.city = city;
    }
}

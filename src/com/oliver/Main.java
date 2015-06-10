package com.oliver;

public class Main {

    public static void main(String[] args) {

        AnagramDetector detector = new AnagramDetector();
        String testWord = "lives";
        String[] words = new String[]{"elvis", "deadly"};

        String[] anagrams = detector.detect(testWord, words);
        System.out.println("Anagrams detected: ");
        for(String anagram : anagrams) {
            System.out.println(anagram);
        }
    }
}

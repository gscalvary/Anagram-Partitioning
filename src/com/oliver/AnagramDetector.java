package com.oliver;

import java.util.ArrayList;
import java.util.HashMap;

public class AnagramDetector {

    public String[] detect(String test, String[] words) {

        HashMap<Character, Integer> testLetters = new HashMap<Character, Integer>();
        loadHash(testLetters, test);

        ArrayList<String> anagrams = new ArrayList<String>();
        for(String word : words) {
            if(test.length() == word.length()) {
                HashMap<Character, Integer> wordLetters = new HashMap<Character, Integer>();
                loadHash(wordLetters, word);
                if(hasSameLetters(testLetters, wordLetters, word)) anagrams.add(word);
            }
        }

        String[] answer = new String[anagrams.size()];
        return anagrams.toArray(answer);
    }

    private void loadHash(HashMap<Character, Integer> map, String word) {

        for(int i = 0; i < word.length(); i++) {
            if(map.containsKey(word.charAt(i))) {
                int occurrences = map.get(word.charAt(i));
                map.put(word.charAt(i), ++occurrences);
            } else {
                map.put(word.charAt(i), 1);
            }
        }
    }

    private boolean hasSameLetters(HashMap<Character, Integer> tl, HashMap<Character, Integer> wl, String word) {

        for(int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            if(!tl.containsKey(a)) {
                return false;
            } else {
                if(!tl.get(a).equals(wl.get(a))) {
                   return false;
                }
            }
        }

        return true;
    }
}
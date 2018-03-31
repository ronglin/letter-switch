package com.al;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dictionary {

    private static Set<String> words = new HashSet<String>();

    static {
        String fileName = "C://Users/Rong/Downloads/words.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            words = stream
                    .map(String::toLowerCase)
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isWord(String str) {
        return words.contains(str);
    }

    public static Set<String> getDictByWordSize(int size) {
        return words.stream()
                .filter(word -> word.length() == size)
                .collect(Collectors.toSet());
    }
}

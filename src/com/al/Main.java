package com.al;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    static Set<String> wordsBetween = Dictionary.getDictByWordSize(5);


    public static void main(String[] args) {

        System.out.println("Hello world!");
        String wordStart = "pig";
        String wordEnd = "sty";
        Node nodeStart = new Node("tears", null);
        Node nodeEnd = new Node("smile", null);
        wordsBetween.remove("fleur");


/*
        System.out.println(Dictionary.isWord("four"));
        System.out.println(Dictionary.isWord("foul"));
        System.out.println(Dictionary.isWord("foal"));
        System.out.println(Dictionary.isWord("foam"));
        System.out.println(Dictionary.isWord("firm"));
        System.out.println(Dictionary.isWord("fire"));
        System.out.println(Dictionary.isWord("five"));
*/

        Set<Node> tree = new HashSet<>();
        Set<Node> levelOne = new HashSet<>();
        levelOne.add(nodeEnd);
        tree.add(nodeEnd);
        buildTree3(levelOne, tree, nodeStart.word);

        Set<Node> aSolution = new HashSet<>();
        aSolution.add(nodeStart);

        System.out.println("\nSize of tree: " + tree.size());
        for (Node node : tree) {
            if (aSolution.contains(node)) {
                System.out.println("Found: " + node);
            }
        }

    }

    public static void buildTree3(Set<Node> nodes, Set<Node> tree, String stop) {
        Set<Node> nextLevelNodes = new HashSet<>();
        for (Node node : nodes) {
            Set<Node> children = child(node);
            for (Node child : children) {
                if (!tree.contains(child) && !nextLevelNodes.contains(child)) {
                    nextLevelNodes.add(child);
                    System.out.println(child);
                }
                if (child.word.compareTo(stop) == 0) {
                    return;
                }
            }
        }

        if (nextLevelNodes.size() > 0) {
            tree.addAll(nextLevelNodes);
            buildTree3(nextLevelNodes,tree, stop);
        }
    }





    public static void buildTree2(Set<Node> nodes, Set<Node> tree) {
        Set<Node> nextLevelNodes = new HashSet<>();
        for (Node node : nodes) {
            Set<Node> children = child(node);
            for (Node child : children) {
                if (!tree.contains(child) && !nextLevelNodes.contains(child)) {
                    nextLevelNodes.add(child);
                    System.out.println(child);
                }
            }
        }

        if (nextLevelNodes.size() > 0) {
            tree.addAll(nextLevelNodes);
            buildTree2(nextLevelNodes, tree);
        }
    }


    public static void buildTree(Node node, Set<Node> tree) {
        Set<Node> children = child(node);
        Set<Node> currentTree = new HashSet<>(tree);
        tree.addAll(children);

        for (Node child: children) {
            tree.addAll(child(child));
        }

        for (Node child : children) {
            if (child.level < 8 && !currentTree.contains(child)) {
                System.out.println(child);
                buildTree(child, tree);
            }
        }
    }

    public static Set<Node> child(Node x) {
        // x is a word, the output is a set of words
        char[] startChar = x.word.toCharArray();
        int counter = 0;
        char[] wordchar;
        Set<Node> wordschilderen = new HashSet<>();
        for (String word : wordsBetween) {
            wordchar = word.toCharArray();
            counter = 0;
            for (int j = 0; j < word.length(); j++) {
                if (wordchar[j] != startChar[j]) {
                    counter++;
                }
            }
            if (counter == 1) {
                wordschilderen.add(new Node(word, x));
            }

        }
        return (wordschilderen);

    }

}

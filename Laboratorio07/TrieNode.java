package Laboratorio07;

public class TrieNode {
    static final int ALPHABET_SIZE = 26;

    TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    boolean isEndOfWord;
}

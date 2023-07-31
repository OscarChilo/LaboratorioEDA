package Laboratorio07;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return (node != null) && node.isEndOfWord;
    }

    public void replace(String oldWord, String newWord) {
        delete(oldWord);
        insert(newWord);
    }

    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    private boolean delete(TrieNode node, String word, int index) {
        if (index == word.length()) {
            if (!node.isEndOfWord) {
                return false;
            }
            node.isEndOfWord = false;
            return nodeIsEmpty(node);
        }
        int c = word.charAt(index) - 'a';
        TrieNode child = node.children[c];
        if (child == null) {
            return false;
        }
        boolean shouldDelete = delete(child, word, index + 1);
        if (shouldDelete) {
            node.children[c] = null;
            return nodeIsEmpty(node) && !node.isEndOfWord;
        }
        return false;
    }

    private boolean nodeIsEmpty(TrieNode node) {
        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] != null) {
                return false;
            }
        }
        return true;
    }

    private TrieNode searchNode(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node.isEndOfWord ? node : null;
    }
}

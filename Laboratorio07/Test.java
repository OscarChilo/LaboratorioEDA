package Laboratorio07;

public class Test {
    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insertar palabras
        trie.insert("hola");
        trie.insert("estamos");
        trie.insert("probando");
        // buscar palabras
        System.out.println(trie.search("hello"));
        System.out.println(trie.search("hola"));
    }
}

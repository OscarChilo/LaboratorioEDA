package Laboratorio51;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

import java.util.*;

public class GraphAVL {
    private static int nodeCounter = 0;
    private static Map<Character, Integer> charCountMap;
    private static final int X_OFFSET = 50;
    private static final int Y_OFFSET = 50;
    private static final int X_GAP = 50;
    private static final int Y_GAP = 50;

    public static void main(String[] args) {
        System.setProperty("org.grapahstream.ui", "swing");

        Scanner scan = new Scanner(System.in);

        System.out.print("ingrese una palabra en mayuscula: ");
        String input = scan.nextLine();

        charCountMap = new HashMap<>();

        TreeAvl<Integer> treeAvl = new TreeAvl<>();
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            int asciiValue = (int) character;

            try {
                treeAvl.insert(asciiValue);
                incrementCharCount(character);
            } catch (ExceptionNoFound e) {
                // TODO: handle exception
                System.out.println("Error al insertar en ele arbol AVL: " + e.getMessage());
            }
        }

        Graph graph = new SingleGraph("AVL Tree");

        graph.setAttribute("ui.stylesheet", styleSheet);

        NodeAvl<Integer> rootNode = (NodeAvl<Integer>) treeAvl.getRoot();

        if (rootNode != null) {
            Node graphRootNode = graph.addNode(getNodeId(rootNode.getData(), characterCount(rootNode.getData())));
            graphRootNode.setAttribute("ui.label", rootNode.getData().toString());
            graphRootNode.setAttribute("xy", 0, 0);
            visualiceTree(rootNode, graphRootNode, 0, 0);
        }

        Viewer viewer = graph.display();
        viewer.disableAutoLayout();
    }

    private static void visualiceTree(NodeAvl<Integer> node, Node graphNode, int parentX, int parentY) {
        if (node != null) {
            if (node.getLeft() != null) {
                int leftX = parentX - X_GAP;
                int leftY = parentY - Y_GAP;
                Node leftNode = graphNode.getGraph()
                        .addNode(getNodeId(node.getLeft().getData(), characterCount(node.getLeft().getData())));
                leftNode.setAttribute("ui.label", node.getLeft().getData().toString());
                leftNode.setAttribute("xy", leftX, leftY);
                graphNode.getGraph().addEdge(graphNode.getId() + "-" + leftNode.getId(), graphNode, leftNode);
                visualiceTree(node.getLeft(), leftNode, leftX, leftY);
            }
            if (node.getRight() != null) {
                int rightX = parentX + X_GAP;
                int rightY = parentY - Y_GAP;
                Node rightNode = graphNode.getGraph()
                        .addNode(getNodeId(node.getRight().getData(), characterCount(node.getRight().getData())));
                rightNode.setAttribute("ui.label", node.getLeft().getData().toString());
                rightNode.setAttribute("xy", rightX, rightY);
                graphNode.getGraph().addEdge(graphNode.getId() + "-" + rightNode.getId(), graphNode, rightNode);
                visualiceTree(node.getLeft(), rightNode, rightX, rightY);
            }
        }
    }

    private static String getNodeId(int data, int repetition) {
        char character = (char) data;
        return character + "_" + repetition;
    }

    private static int characterCount(int data) {
        char character = (char) data;
        return charCountMap.get(character);
    }

    private static void incrementCharCount(char character) {
        int count = charCountMap.getOrDefault(character, 0);
        charCountMap.put(character, count + 1);
    }

    private static String styleSheet = "node {" +
            " shape: circle;" +
            " size: 45px;" +
            " text-size: 12;" +
            " fill-mode: plain;" +
            " fill-color: skyblue" +
            " stroke-mode: plain;" +
            " stroke-color: black;" +
            " stroke-width: 1px" +
            "}" +
            "edge {arrow-shape: arrow-size:20px, 4px;}";

}

package lectures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Huffman {

    public class Node implements Comparable<Node>{
        Node(int sum) {
            this.sum = sum;
        }

        String code;
        final int sum;

        public void buildCode(String code) {
            this.code = code;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.sum, node.sum);
        }
    }

    public class InnerNode extends Node {
        Node left;
        Node right;

        InnerNode(Node left, Node right) {
            super(left.sum + right.sum);
            this.left = left;
            this.right = right;
        }

        @Override
        public void buildCode(String code) {
            super.buildCode(code);
            this.left.buildCode(code + "1");
            this.right.buildCode(code + "0");
        }
    }

    class LeafNode extends Node {

        char symbol;
        LeafNode(char symbol, int frequency) {
            super(frequency);
            this.symbol = symbol;
        }

        @Override
        public void buildCode(String code) {
            super.buildCode(code);
            System.out.println(symbol + ": " + code);
        }
    }



    public static void main(String[] args) throws FileNotFoundException {
        Huffman h = new Huffman();
        h.run();

    }


    private void run() throws FileNotFoundException {


        Scanner in = new Scanner(new File("HuffmanText.txt"));
        String text = in.nextLine();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            LeafNode leafNode = new LeafNode(entry.getKey(), entry.getValue());
            pq.add(leafNode);
        }

        while (pq.size() > 1) {
            Node first = pq.poll();
            Node second = pq.poll();
            InnerNode innerNode = new InnerNode(first, second);
            pq.add(innerNode);
        }

        Node root = pq.poll();
        root.buildCode("");

        in.close();
    }

}



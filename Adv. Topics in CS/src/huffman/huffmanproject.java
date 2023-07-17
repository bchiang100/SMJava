package huffman;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class huffmanproject {
    
    private static class HuffmanNode {
        char character;
        int freq;
        HuffmanNode leftChild, rightChild;
        // initializing Huffman node 
        public HuffmanNode(char character, int frequency) {
            this.character = character;
            this.freq = frequency;
        }
        // initializing children nodes
        public HuffmanNode(HuffmanNode leftChild, HuffmanNode rightChild) {
            this.freq = leftChild.freq + rightChild.freq;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }
    
    private static Map<Character, String> encode(String input) {
        Map<Character, Integer> frequencyMap = buildFrequencyMap(input);
        
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(new Comparator<HuffmanNode>() {
            public int compare(HuffmanNode a, HuffmanNode b) {
                return a.freq - b.freq;
            }
        });
        
        // creating leaf nodes for each character and add them to priority queue
        for (char c : frequencyMap.keySet()) {
            pq.add(new HuffmanNode(c, frequencyMap.get(c)));
        }
        
        // combining the two lowest frequency nodes until there is only one node remaining (this is the compression process)
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode parent = new HuffmanNode(left, right);
            pq.add(parent);
        }
        
        // traversing the tree and building the code for each character
        Map<Character, String> codeMap = new HashMap<>();
        branch(codeMap, pq.peek(), "");
        return codeMap;
    }
    
    private static Map<Character, Integer> buildFrequencyMap(String filename) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        try {
            FileReader reader = new FileReader(filename);
            int character;
            while ((character = reader.read()) != -1) {
                char c = (char) character;
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return frequencyMap;
    }
    
    private static void branch(Map<Character, String> codeMap, HuffmanNode node, String code) {
        // leaf node
        if (node.character != 0) {  
            codeMap.put(node.character, code);
            return;
        }
        branch(codeMap, node.leftChild, code + "0");
        branch(codeMap, node.rightChild, code + "1");
    }
    
    public static void main(String[] args) {
        String filename = "Images/huffmantxtfile.txt"; 
        Map<Character, String> codeMap = encode(filename);

        String encoded = "";
        try {
            FileReader reader = new FileReader(filename);
            int character;
            while ((character = reader.read()) != -1) {
                char c = (char) character;
                encoded += codeMap.get(c);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // writing the encoded message to a new file
        String outputFilename = "Images/huffmanencoded.txt"; 
        try {
            FileWriter writer = new FileWriter(outputFilename);
            writer.write(encoded);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        System.out.println("Encoded message written to " + outputFilename);
    }
}
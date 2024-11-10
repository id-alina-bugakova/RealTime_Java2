package ru.mirea.lab30.huffmanCoding;

import java.util.Map;
import java.util.TreeSet;
import java.util.TreeMap;

public class HuffmanCoding {
    private TreeSet<HuffmanNode> frequencies = new TreeSet<>();
    private TreeMap<String, String> codes = new TreeMap<>();

    public HuffmanCoding(String text) {
        TreeMap<String, Integer> temp = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            String key = "" + text.charAt(i);
            if (temp.containsKey(key))
                temp.put(key, temp.get(key) + 1);
            else
                temp.put(key, 1);
        }
        for (Map.Entry<String, Integer> entry : temp.entrySet())
            frequencies.add(new HuffmanNode(entry.getKey(), entry.getValue()));
    }

    private void build_tree() {
       while(frequencies.size() > 1) {
           HuffmanNode node1 = frequencies.pollFirst();
           HuffmanNode node2 = frequencies.pollFirst();
           frequencies.add(new HuffmanNode(node1, node2));
       }
       HuffmanNode node = frequencies.pollFirst();
       node.updateCode("");
       frequencies.add(node);
    }
    private void dfs(HuffmanNode node) {
        if(node.leaf)
            codes.put(node.code, node.name);
        else {
            dfs(node.child0);
            dfs(node.child1);
        }
    }
    public TreeMap<String, String> process() {
        build_tree();
        dfs(frequencies.first());
        return this.codes;
    }
}

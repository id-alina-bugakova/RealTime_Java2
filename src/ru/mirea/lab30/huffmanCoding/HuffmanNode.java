package ru.mirea.lab30.huffmanCoding;

public class HuffmanNode implements Comparable<HuffmanNode>{
    protected String name;
    protected int frequency;
    protected String code;
    protected HuffmanNode child0;
    protected HuffmanNode child1;
    protected boolean leaf;

    public HuffmanNode(String name, int frequency) {
        this.name = name;
        this.frequency = frequency;
        this.child0 = this.child1 = null;
        this.leaf = true;
    }
    public HuffmanNode(HuffmanNode child0, HuffmanNode child1) {
        this.name = child0.name + child1.name;
        this.frequency = child0.frequency + child1.frequency;
        this.child0 = child0;
        this.child1 = child1;
        this.leaf = false;
    }

    public void updateCode(String bin) {
        this.code = bin;
        if(this.leaf)
            return;
        this.child0.updateCode(bin + "0");
        this.child1.updateCode(bin + "1");
    }

    @Override
    public int compareTo(HuffmanNode o) {
        if(this.frequency != o.frequency)
            return Integer.compare(this.frequency, o.frequency);
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        String str = "<" + this.name + ":" + this.frequency + " - \"" + this.code + "\">";
        if(!this.leaf)
            str += " : { " + this.child0 + ", " + this.child1 + " }";
        return str;
    }
}

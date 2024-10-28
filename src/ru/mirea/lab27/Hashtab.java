package ru.mirea.lab27;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class Hashtab<K, V> {
    HashMap<K, V> hm;

    public Hashtab() {
        hm = new HashMap<>();
    }

    public void add(K key, V val) {
        hm.put(key, val);
    }
    public void delete(K key) {
        hm.remove(key);
    }
    public V lookup(K key) {
        return hm.get(key);
    }
    public int hash(K key) {
        return hm.get(key).hashCode();
    }

    @Override
    public String toString() {
        String ret = "Hashtab = { ";
        for(Map.Entry<K, V> entry : hm.entrySet())
            ret += "\n    " + entry.getKey() + " : " + entry.getValue();
        ret += "\n}";
        return ret;
    }
}

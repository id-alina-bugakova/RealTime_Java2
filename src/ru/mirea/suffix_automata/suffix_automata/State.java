package ru.mirea.suffix_automata.suffix_automata;

import java.util.TreeMap;

public class State {
    protected boolean terminal = false;
    protected TreeMap<Character, Integer> transitions = new TreeMap<>();
    protected int len = 0;
    protected int link = -1;

    public void add_transition(char c, int state) {
        transitions.put(c, state);
    }
    public void copy(State source) {
        this.terminal = source.terminal;
        this.transitions = new TreeMap<>();
        this.transitions.putAll(source.transitions);
        this.len = source.len;
        this.link = source.link;
    }

    public String toString() {
        String str = "{ Transitions: " + transitions.toString() + "\n  Terminal: " + terminal + "\n  Len: " + len + "\n  Link: " + link + "\n}";
        return str;
    }
}

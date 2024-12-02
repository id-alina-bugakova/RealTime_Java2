package ru.mirea.suffix_automata.suffix_automata;

import java.util.ArrayList;
import java.util.Map;

public class SuffixAutomata {
    protected ArrayList<State> states;
    protected int end = -1;

    public SuffixAutomata(String str) {
        states = new ArrayList<>();
        State cur = new State();
        cur.len = 0;
        cur.link = -1;
        states.add(cur);
        int last = 0;
        int full_string = 0;
        for(int i = 0; i < str.length(); i++) {
            full_string = states.size();
            char c = str.charAt(i);
            cur = new State();
            cur.len = states.get(last).len + 1;
            int p = last;  // currently modified state, after cycle becomes state that has a transition with c (if found_transition == true, else -1)
            int q = -1;    // where the transition from p with c leads
            while(p != -1) {
                if(states.get(p).transitions.containsKey(c)) {
                    q = states.get(p).transitions.get(c);
                    break;
                }
                if (q == -1) {  // not found a transition
                    states.get(p).add_transition(c, states.size());
                    p = states.get(p).link;
                }
                else
                    break;
            }
            if(p == -1) {
                cur.link = 0;
                states.add(cur);
            }
            else {
                if(states.get(p).len + 1 == states.get(q).len) {
                    cur.link = q;
                    states.add(cur);
                }
                else {
                    states.add(cur);
                    State clone = new State();
                    clone.copy(states.get(q));
                    clone.len = states.get(p).len + 1;
                    states.get(states.size() - 1).link = states.size();
                    states.get(q).link = states.size();
                    while(p != -1) {
                        if(states.get(p).transitions.containsKey(c) && states.get(p).transitions.get(c) == q)
                            states.get(p).transitions.put(c, states.size());
                        else
                            break;
                        p = states.get(p).link;
                    }
                    states.add(clone);
                }
            }
            last = full_string;
        }
        this.end = full_string;
        while(full_string != -1) {
            states.get(full_string).terminal = true;
            full_string = states.get(full_string).link;
        }
    }

    public Graph graph() {
        Graph g = new Graph(states.size());
        for(int i = 0; i < states.size(); i++) {
            for(Map.Entry<Character, Integer> entry : states.get(i).transitions.entrySet())
                g.matr.get(i).set(entry.getValue(), true);
        }
        return g;
    }

    public void print() {
        for(int i = 0; i < states.size(); i++) {
            System.out.println("State " + i + ":\n" + states.get(i).toString());
        }
    }
}

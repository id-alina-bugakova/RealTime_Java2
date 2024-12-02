package ru.mirea.suffix_automata.suffix_automata;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class SuffixProcessor {
    public static boolean checkForEntry(SuffixAutomata sa, String substr) {
        for(int i = 0, state = 0; i < substr.length(); i++) {
            if(i > 0)
                state = sa.states.get(state).transitions.get(substr.charAt(i - 1));
            if (sa.states.get(state).transitions.isEmpty() || !sa.states.get(state).transitions.containsKey(substr.charAt(i)))
                return false;
        }
        return true;
    }
    public static int countDifferentSubstrings(SuffixAutomata sa) {
        Graph g = sa.graph();
        int n = g.matr.size();
        int end = g.findNull();
        ArrayList<Boolean> used = new ArrayList<>();
        ArrayList<Integer> dp = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            used.add(false);
            dp.add(0);
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> delayed = new ArrayList<>();

        queue.addLast(end);
        dp.set(end, 1);
        while(!(queue.isEmpty() && delayed.isEmpty())) {
            for(int k = 0; k < delayed.size(); k++) {
                int v = delayed.get(k);
                boolean flag = true;
                for (int i = 0; i < n; i++)
                    if (g.matr.get(v).get(i))
                        flag = flag & used.get(i);
                if (flag) {  // if all vertices that v leads to are used
                    used.set(v, true);
                    delayed.remove(k);
                    for (int i = 0; i < n; i++)
                        if (g.matr.get(i).get(v))
                            queue.addLast(i);
                    int count = 1;
                    for (int i = 0; i < n; i++)
                        if (g.matr.get(v).get(i))
                            count += dp.get(i);
                }
            }
            if(!queue.isEmpty()) {
                int v = queue.pollFirst();
                boolean flag = true;
                for (int i = 0; i < n; i++)
                    if (g.matr.get(v).get(i))
                        flag = flag & used.get(i);
                if (flag) {  // if all vertices that v leads to are used
                    used.set(v, true);
                    for (int i = 0; i < n; i++)
                        if (g.matr.get(i).get(v))
                            queue.addLast(i);
                    if(v != end) {
                        int count = 1;
                        for (int i = 0; i < n; i++)
                            if (g.matr.get(v).get(i))
                                count += dp.get(i);
                        dp.set(v, count);
                    }
                } else
                    delayed.add(v);
            }
        }
        return dp.get(0) - 1;
    }
}

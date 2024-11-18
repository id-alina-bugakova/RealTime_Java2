package ru.mirea.lab28;

import java.util.*;

public class Main {
    public static void task28_1() {
        HashSet<String> hs = new HashSet<>();
        hs.add("one");
        hs.add("two");
        hs.add("three");
        hs.add("four");
        hs.add("five");
        TreeSet<String> ts = new TreeSet<>(hs);
        System.out.println(hs);
        System.out.println(ts);
    }
    public static HashMap<String, String> createMap() {
        int n = 5;
        String[] names = {"Beverly", "Connie", "Margaret", "Nina", "Sarah"};
        String[] surnames = {"Foster", "Howell", "Morgan", "Schneider", "Williams"};
        Random random = new Random();
        HashMap<String, String> hashMap = new HashMap<>();
        for(int i = 0; i < 10; i++)
            hashMap.put(surnames[random.nextInt(n)], names[random.nextInt(n)]);
        return hashMap;
    }
    public static int getSameFirstNameCount(HashMap<String, String> hm) {
        int ans = 0;
        TreeSet<String> names = new TreeSet<>();
        for(Map.Entry<String, String> entry : hm.entrySet())
            names.add(entry.getValue());
        for(String name : names) {
            int count = 0;
            for(Map.Entry<String, String> entry : hm.entrySet())
                if(entry.getValue().equals(name))
                    count++;
            if(count > 1)
                ans += count;
        }
        return ans;
    }
    public static int getSameLastNameCount(HashMap<String, String> hm) {
        int ans = 0;
        TreeSet<String> surnames = new TreeSet<>();
        for(Map.Entry<String, String> entry : hm.entrySet())
            surnames.add(entry.getKey());
        for(String surname : surnames) {
            int count = 0;
            for(Map.Entry<String, String> entry : hm.entrySet())
                if(entry.getKey().equals(surname))
                    count++;
            if(count > 1)
                ans += count;
        }
        return ans;
    }
    public static void task28_2() {
        HashMap<String, String> hm = createMap();
        //System.out.println(hm);
        System.out.println("Same first names : " + getSameFirstNameCount(hm));
        System.out.println("Same last names  : " + getSameLastNameCount(hm));
    }

    public static void main(String[] args) {
        task28_2();
    }
}

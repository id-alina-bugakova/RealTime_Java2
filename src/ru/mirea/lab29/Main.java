package ru.mirea.lab29;

import java.util.Scanner;

public class Main {
    public static boolean dijkstra_all_true(boolean[] arr) {
        for(boolean a : arr)
            if(!a)
                return false;
        return true;
    }
    public static int[][] dijkstra(int n, int[][] lengths) {
        int[][] min_lengths = new int[n][n];
        for (int v = 0; v < n; v++) {
            int[] marks = new int[n];
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (i != v)
                    marks[i] = Integer.MAX_VALUE;
                else
                    marks[i] = 0;
            }
            while (!dijkstra_all_true(visited)) {
                int cur_val = Integer.MAX_VALUE, cur = -1;
                for (int i = 0; i < n; i++)
                    if (!visited[i] && marks[i] < cur_val) {
                        cur_val = marks[i];
                        cur = i;
                    }
                visited[cur] = true;
                for (int j = 0; j < n; j++)
                    if (!visited[j] && lengths[cur][j] != 0)
                        marks[j] = Integer.min(marks[j], marks[cur] + lengths[cur][j]);
            }
            for (int i = 0; i < n; i++)
                min_lengths[v][i] = marks[i];
        }
        return min_lengths;
    }
    public static void dijkstra_entrance() {
        Scanner sc = new Scanner(System.in);
        int n, m; // n - n of nodes, m - n of edges
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] lengths = new int[n][n];
        for (int i = 0; i < m; i++) {
            int a, b, w;
            a = sc.nextInt();
            b = sc.nextInt();
            w = sc.nextInt();
            lengths[a - 1][b - 1] = lengths[b - 1][a - 1] = w;
        }
        int[][] min_lengths = dijkstra(n, lengths);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.printf("%3d ", min_lengths[i][j]);
            System.out.println();
        }
    }

    public static void task29_1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int edges = 0, loops = 0, cur;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) {
                cur = sc.nextInt();
                if(cur == 1) {
                    if(i == j)
                        loops++;
                    else
                        edges++;
                }
            }
        System.out.println(edges  / 2 + loops);
    }

    public static void main(String[] args) {
        task29_1();
    }
}

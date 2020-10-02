import java.util.ArrayList;
import java.util.Scanner;

public class BFS {
    public static void dfs(int u, boolean[] visited, ArrayList<Integer>[] graph) {
        visited[u] = true;
        for (int i = 0; i < graph[u].size(); i++) {
            int v = graph[u].get(i);
            if (visited[v] == false) {
                dfs(v, visited, graph);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }
        int count = 0;
        boolean[] visited = new boolean[n+1];
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                dfs(i, visited, graph);
                count++;
            }
        }
        System.out.println(count);
    }
}

/*
6 4
0 1
0 2
3 2
5 4
*/

import java.util.*;

public class DFS_BFS {

    static void bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean [] visit) {

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visit[start] = true;

        while (!q.isEmpty()) {

            int node = q.remove();
            System.out.print(node + " ");

            for (int i : adj.get(node)) {
                if (!visit[i]) {
                    visit[i] = true;
                    q.add(i);
                }
            }
        }
    }

    // DFS Recursive
    static void dfs(int start, ArrayList<ArrayList<Integer>> adj, boolean [] visit) {

        visit[start] = true;
        System.out.print(start + " ");

        for (int n : adj.get(start)) {
            if (!visit[n]) {
                dfs(n, adj, visit);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int vertices = 7;
        boolean visitBfs[] = new boolean[vertices];
        boolean visitDfs[] = new boolean[vertices];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected Graph
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(1).add(4);
        adj.get(4).add(1);

        adj.get(2).add(5);
        adj.get(5).add(2);

        adj.get(2).add(6);
        adj.get(6).add(2);
        /*
                 0
               /   \
              1     2
             / \   / \
            3   4 5   6
        */
        while (true) {
            System.out.println("\n1. BFS");
            System.out.println("2. DFS");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int x = sc.nextInt();

            switch (x) {
                case 1:
                    System.out.println("BFS Traversal:");
                    bfs(0, adj, visitBfs);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("DFS Traversal:");
                    dfs(0, adj, visitDfs);
                    System.out.println();
                    break;
                default:
                    System.out.println("Program Ended");
                    return;
            }
        }
        
    }
}
import java.util.*;

class AStarEasy {

    static class Node {
        int x, y;
        int g, h, f;
        Node parent;

        Node(int x, int y, int g, int h, Node parent) {
            this.x = x;
            this.y = y;
            this.g = g;
            this.h = h;
            this.f = g + h;
            this.parent = parent;
        }
    }

    static int ROW = 5;
    static int COL = 5;

    // Heuristic Function (Manhattan Distance)
    static int heuristic(int x, int y, int goalX, int goalY) {
        return Math.abs(x - goalX) + Math.abs(y - goalY);
    }

    // Check valid cell
    static boolean isValid(int x, int y, int[][] grid) {
        return x >= 0 && y >= 0 &&
                x < ROW && y < COL &&
                grid[x][y] == 0;
    }

    static void aStar(int[][] grid, int startX, int startY,
            int goalX, int goalY) {

        // Priority Queue -> smallest f value first
        PriorityQueue<Node> open = new PriorityQueue<>((a, b) -> a.f - b.f);

        boolean[][] visited = new boolean[ROW][COL];

        Node start = new Node(
                startX,
                startY,
                0,
                heuristic(startX, startY, goalX, goalY),
                null);

        open.add(start);

        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        while (!open.isEmpty()) {

            Node current = open.poll();

            int x = current.x;
            int y = current.y;

            // Goal found
            if (x == goalX && y == goalY) {

                System.out.println("Path Found!");

                printPath(current);
                return;
            }

            visited[x][y] = true;

            // Explore 4 directions
            for (int i = 0; i < 4; i++) {

                int newX = x + dx[i];
                int newY = y + dy[i];

                if (isValid(newX, newY, grid)
                        && !visited[newX][newY]) {

                    int newG = current.g + 1;

                    int newH = heuristic(
                            newX,
                            newY,
                            goalX,
                            goalY);

                    Node neighbor = new Node(
                            newX,
                            newY,
                            newG,
                            newH,
                            current);

                    open.add(neighbor);
                }
            }
        }

        System.out.println("No Path Found");
    }

    // Print path using parent nodes
    static void printPath(Node node) {

        List<String> path = new ArrayList<>();

        while (node != null) {
            path.add("(" + node.x + "," + node.y + ")");
            node = node.parent;
        }

        Collections.reverse(path);

        for (String p : path) {
            System.out.print(p + " ");
        }
    }

    public static void main(String[] args) {

        int[][] grid = {
                { 0, 0, 0, 0, 0 },
                { 1, 1, 0, 1, 0 },
                { 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0 }
        };

        int startX = 0;
        int startY = 0;

        int goalX = 4;
        int goalY = 4;

        aStar(grid, startX, startY, goalX, goalY);
    }
    /*
     * 1. What is A* Algorithm?
     * A* (A-Star) is a path finding and search algorithm.
     * It is used to find the shortest path between:
     * Start node → Goal node
     * It works intelligently using:
     * actual distance travelled
     * estimated distance to goal
     * 2. Formula Used in A*
     * Most important formula:
     * f(n)=g(n)+h(n)
     * Where:
     * Term Meaning
     * g(n) Distance from start node
     * h(n) Estimated distance to goal
     * f(n) Total cost
     * 3. Heuristic Function
     * Usually we use Manhattan Distance in grids:
     * h(x,y)=∣x−xg​∣+∣y−yg​∣
     * 
     * This estimates how far goal is.
     * 
     * 4. Main Idea of A*
     * 
     * A* always selects:
     * 
     * Node having minimum f(n)
     * 
     * That means:
     * 
     * Best path till now + closest to goal
     * 
     * So it reaches goal faster than BFS.
     * 
     * 5. Components Used
     * Component Purpose
     * Priority Queue Gets minimum f value
     * Open List Nodes to explore
     * Closed List Already visited
     * Heuristic Guides search
     * Parent Node Used to print path
     */
}
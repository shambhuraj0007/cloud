import java.util.*;

public class JobScheduling {
    static class Job {

        char id;
        int deadline;
        int profit;

        Job(char i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {

        Job jobs[] = {
                new Job('A', 2, 100),
                new Job('B', 1, 19),
                new Job('C', 2, 27),
                new Job('D', 1, 25),
                new Job('E', 3, 15)
        };

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int n = jobs.length;

        boolean slot[] = new boolean[n];
        char result[] = new char[n];

        for (int i = 0; i < n; i++) {

            for (int j = Math.min(n, jobs[i].deadline) - 1; j >= 0; j--) {

                if (!slot[j]) {

                    slot[j] = true;
                    result[j] = jobs[i].id;
                    break;
                }
            }
        }

        System.out.println("Selected Jobs:");

        for (char c : result) {

            if (c != 0)
                System.out.print(c + " ");
        }
    }
}
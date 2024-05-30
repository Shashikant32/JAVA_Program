import java.util.*;

public class Main {
    static class Pair {
        int position;
        int rolls;

        Pair(int position, int rolls) {
            this.position = position;
            this.rolls = rolls;
        }
    }

    public static int quickestWayUp(List<Pair> ladders, List<Pair> snakes) {
        Map<Integer, Integer> board = new HashMap<>();
        // Initialize the board
        for (int i = 1; i <= 100; i++) {
            board.put(i, i);
        }
        // Place ladders and snakes on the board
        for (Pair ladder : ladders) {
            board.put(ladder.position, ladder.position + ladder.rolls);
        }
        for (Pair snake : snakes) {
            board.put(snake.position, snake.position - snake.rolls);
        }

        // Perform BFS to find the shortest path
        Queue<Pair> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(new Pair(1, 0)); // Start from position 1
        visited.add(1);
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int currentPosition = current.position;
            int currentRolls = current.rolls;
            if (currentPosition == 100) {
                return currentRolls;
            }
            for (int roll = 1; roll <= 6; roll++) {
                int nextPosition = board.getOrDefault(currentPosition + roll, currentPosition + roll);
                if (!visited.contains(nextPosition)) {
                    queue.offer(new Pair(nextPosition, currentRolls + 1));
                    visited.add(nextPosition);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Number of ladders
        List<Pair> ladders = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            ladders.add(new Pair(start, end - start));
        }
        int m = scanner.nextInt(); // Number of snakes
        List<Pair> snakes = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            snakes.add(new Pair(start, start - end));
        }
        int result = quickestWayUp(ladders, snakes);
        System.out.println(result);
    }
}

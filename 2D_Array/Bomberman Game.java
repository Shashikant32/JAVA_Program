import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    public static List<String> bomberMan(int n, List<String> grid) {
        int R = grid.size();
        int C = grid.get(0).length();

        if (n == 1) {
            return grid;  // Return the original grid at second 1.
        }

        List<String> fullGrid = new ArrayList<>(Collections.nCopies(R, "O".repeat(C)));

        if (n % 4 == 0) {
            return fullGrid;  // After every 4 seconds (2 and 4 look the same)
        }

        char[][] state = new char[R][C];

        for (int i = 0; i < R; i++) {
            state[i] = grid.get(i).toCharArray();
        }

        boolean[][] detonated = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid.get(i).charAt(j) == 'O') {
                    detonated[i][j] = true;  // Mark this bomb for detonation
                    if (i > 0) detonated[i - 1][j] = true;  // Up
                    if (i < R - 1) detonated[i + 1][j] = true;  // Down
                    if (j > 0) detonated[i][j - 1] = true;  // Left
                    if (j < C - 1) detonated[i][j + 1] = true;  // Right
                }
            }
        }

        List<String> resultState = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < C; j++) {
                if (detonated[i][j]) {
                    row.append('.');
                } else {
                    row.append('O');
                }
            }
            resultState.add(row.toString());
        }

        if (n % 4 == 3) {
            return resultState;
        } else {
            return fullGrid;
        }
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);
        int c = Integer.parseInt(firstMultipleInput[1]);
        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(Collectors.toList());

        List<String> result = Result.bomberMan(n, grid);

        bufferedWriter.write(result.stream().collect(Collectors.joining("\n")) + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}

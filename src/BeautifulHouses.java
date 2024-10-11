import java.util.ArrayList;
import java.util.Stack;


public class BeautifulHouses {

    public static int beautifulHouses(int[][] grid) {
        int size = grid.length; // Assuming square matrix
        boolean[][] visited = new boolean[size][size];
        int beautifulHouseCount = 0;

        // Iterate over each cell in the grid
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // If we find a '1' and it's not visited, check if it's a "beautiful house"
                if (grid[i][j] == 1 && !visited[i][j]) {
                    if (isBeautifulHouse(grid, visited, i, j, size)) {
                        beautifulHouseCount++;
                    }
                }
            }
        }

        for(int i = 0; i < visited.length; i++) {

//            System.out.println(Arrays.toString(visited[i]));

        }

        return beautifulHouseCount;
    }

    // DFS to check if a house is beautiful (surrounded by 0s)
    private static boolean isBeautifulHouse(int[][] grid, boolean[][] visited, int row, int col, int size) {

        // Directions for horizontal and vertical neighbors (no diagonals)
        int[] rowDir = {-1, 0, 1, 0}; // Up, Right, Down, Left
        int[] colDir = {0, 1, 0, -1};

        // Directions for diagonal neighbors
        int[] diagRowDir = {-1, -1, 1, 1};
        int[] diagColDir = {-1, 1, -1, 1};

        // Stack to do DFS
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});
        visited[row][col] = true;

        boolean isBeautiful = true;   // Assume it is a beautiful house

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int r = cell[0], c = cell[1];


            for (int i = 0; i < 4; i++) {
                int newRow = r + rowDir[i];
                int newCol = c + colDir[i];

                if (isValid(newRow, newCol, size)) {
                    if (grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        stack.push(new int[]{newRow, newCol});
                    }
                }
            }

            // Check diagonal neighbors to disqualify if connected only diagonally without a third cell
            for (int i = 0; i < 4; i++) {
                int diagRow = r + diagRowDir[i];
                int diagCol = c + diagColDir[i];

                if (isValid(diagRow, diagCol, size) && grid[diagRow][diagCol] == 1) {
                    // Check for a third cell connecting (r, c) and (diagRow, diagCol)
                    boolean hasThirdCell = false;

                        // Check if there's a "third" cell that connects diagonally connected cells
                        if (grid[r][diagCol] == 1 || grid[diagRow][c] == 1) {
                            hasThirdCell = true; // There is a connecting cell in between
                        }


                    // If there's no third cell connecting the diagonal cells, mark as not beautiful
                    if (!hasThirdCell) {
                        isBeautiful = false;
                    }
                }
            }
        }

        return isBeautiful;
    }


    // Helper to check if a cell is within bounds of the grid
    private static boolean isValid(int row, int col, int size) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }


    public static void main(String[] args) {

        ArrayList<int[][]> schemes = new ArrayList<>();
        schemes.add(new int[][] {
            {1, 0, 1, 0, 1},
            {0, 1, 0, 1, 0},
            {1, 0, 1, 0, 1},
            {0, 1, 0, 1, 0},
            {1, 0, 1, 0, 1}
        });
        schemes.add(new int[][] {
            {0, 0, 0, 0, 0, 1, 1},
            {0, 1, 1, 0, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 0, 1},
            {1, 1, 0, 0, 1, 0, 0},
            {1, 1, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0}
        });
        schemes.add(new int[][] {
            {0, 0, 0, 0, 0, 1, 1},
            {0, 1, 1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0},
            {1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 0}
        });
        schemes.add(new int[][] {
            {1, 1, 0, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 1, 1, 0, 1, 1, 0, 0, 1},
            {1, 0, 1, 0, 1, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 0, 1, 1, 1, 0},
            {1, 0, 1, 1, 0, 1, 0, 0, 1, 1},
            {0, 1, 0, 1, 1, 0, 0, 1, 0, 0},
            {1, 0, 1, 0, 0, 1, 1, 1, 1, 0},
            {0, 1, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 1, 1, 0, 1, 0, 1}
        });
        schemes.add(new int[][] {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        });
        schemes.add(new int[][] {
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1}
        });


        for(int i=0; i < schemes.size(); i++) {
            System.out.println(beautifulHouses(schemes.get(i)));
        }

    }
}

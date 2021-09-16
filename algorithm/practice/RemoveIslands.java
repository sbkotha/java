package algorithm.practice;

import java.util.Stack;

public class RemoveIslands {
    public static void main(String[] args) {
        int[][] pixels = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 1},
                {0, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0}
        };

        boolean visited[][] = new boolean[pixels.length][pixels[0].length];

        printMatrix(pixels);

        // Traverse top and bottom row
        for (int i = 0; i < pixels[0].length; i++) {
            if (pixels[0][i] == 1 && !visited[0][i]) {
                traverse(pixels, visited, 0, i);
            }
            if (pixels[pixels.length-1][i] == 1 && !visited[pixels.length-1][i]) {
                traverse(pixels, visited, pixels.length-1, i);
            }
        }

        // Traverse first and last column
        for (int i = 0; i < pixels.length; i++) {
            if (pixels[i][0] == 1 && !visited[i][0]) {
                traverse(pixels, visited, i, 0);
            }
            if (pixels[i][pixels[0].length-1] == 1 && !visited[i][pixels[0].length-1]) {
                traverse(pixels, visited, i, pixels[0].length-1);
            }
        }

        // Loop thru the matrix and those are not traversed mark them as 0
        for (int i=0; i < pixels.length; i++) {
            for (int j=0; j < pixels[0].length; j++) {
                if (!visited[i][j]) {
                    pixels[i][j] = 0;
                }
            }
        }
        System.out.println("Islands Removed");
        printMatrix(pixels);
    }

    private static void printMatrix(int[][] pixels) {
        for (int i=0; i < pixels.length; i++) {
            System.out.print("[");
            for (int j=0; j < pixels[0].length; j++) {
                System.out.print(pixels[i][j] + " ");
            }
            System.out.println("]");
        }

    }

    private static void traverse(int[][] pixels, boolean[][] visited, int row, int col) {
        Stack<Coordinate> stack = new Stack<>();
        stack.push(new Coordinate(row, col));

        while (!stack.empty()) {
            Coordinate point = stack.pop();
            visited[point.x][point.y] = true;
            // Check left
            if (point.x - 1 >= 0 && pixels[point.x - 1][point.y] == 1 && !visited[point.x - 1][point.y]) {
                stack.push(new Coordinate(point.x - 1, point.y));
            }
            // Check right
            if (point.x + 1 < pixels.length && pixels[point.x + 1][point.y] == 1 && !visited[point.x + 1][point.y]) {
                stack.push(new Coordinate(point.x + 1, point.y));
            }
            // Check UP
            if (point.y - 1 >= 0 && pixels[point.x][point.y - 1] == 1 && !visited[point.x][point.y - 1]) {
                stack.push(new Coordinate(point.x, point.y - 1));
            }
            // Check Down
            if (point.y + 1 < pixels[0].length && pixels[point.x][point.y + 1] == 1 && !visited[point.x][point.y + 1]) {
                stack.push(new Coordinate(point.x, point.y + 1));
            }
        }
    }
}

class Coordinate {
    int x, y;
    Coordinate(int a, int b) {
        this.x = a;
        this.y = b;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

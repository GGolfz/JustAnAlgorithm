class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] firstMatrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] secondMatrix = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

        int[][] result = matrixMultiplication(firstMatrix, secondMatrix);

        for (int[] row: result) {
            printArray(row);
        }
    }

    /**
     * 
     * @param a - first integer matrix
     * @param b - second integer matrix
     * @return multiplied result of first two matrix
     */
    public static int[][] matrixMultiplication(int[][] a, int[][] b) {
        int[][] c = new int[a.length][b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return c;
    }

    /**
     * 
     * @param arr - integer array to pretty print
     */
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
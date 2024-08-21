package Task26;

public class MatrixMultiplication {

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 0, 1, 2}
        };

        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {0, 1, 2}
        };

        int[][] result = multiplyMatrices(matrix1, matrix2);

        System.out.println("Product of the matrices is: ");
        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        int rows1 = firstMatrix.length;
        int columns1 = firstMatrix[0].length;
        int columns2 = secondMatrix[0].length;

        int[][] product = new int[rows1][columns2];
        Thread[][] threads = new Thread[rows1][columns2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns2; j++) {
                RunnableClass running = new RunnableClass(firstMatrix,secondMatrix,product,i,j,columns1);
                threads[i][j] = new Thread(running);
                threads[i][j].start();
            }
        }

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns2; j++) {
                try {
                    threads[i][j].join();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }


        return product;
    }
}

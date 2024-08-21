package Task27;

public class ThreadingClass extends Thread
{
    private final int[][] matrixA;
    private final int[][] matrixB;
    private final int[][] product;
    private final int row;
    private final int col;
    private final int columnsA;

    public ThreadingClass(int[][] matrixA, int[][] matrixB, int[][] product, int row, int col, int columnsA) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.product = product;
        this.row = row;
        this.col = col;
        this.columnsA = columnsA;
    }

    @Override
    public void run()
    {
        product[row][col] = 0;
        for(int k=0;k<columnsA;k++)
        {
            product[row][col] += matrixA[row][k] * matrixB[k][col] ;
        }
    }
}

package threads;

public class Sudoku {

    private static final int NUM_THREAD = 27;

    private static final int[][] sudoku = {
            {6, 2, 4, 5, 3, 9, 1, 8, 7},
            {5, 1, 9, 7, 2, 8, 6, 3, 4},
            {8, 3, 7, 6, 1, 4, 2, 9, 5},
            {1, 4, 3, 8, 6, 5, 7, 2, 5},
            {9, 5, 8, 2, 4, 7, 3, 6, 1},
            {7, 6, 2, 3, 9, 1, 4, 5, 8},
            {3, 7, 1, 9, 5, 6, 8, 4, 2},
            {4, 9, 6, 1, 8, 2, 5, 7, 3},
            {2, 8, 5, 4, 7, 3, 9, 1, 6}
    };

    private static boolean[] valid;

    public static class RowColumnObject {
        int row;
        int col;

        RowColumnObject(int row, int column) {
            this.row = row;
            this.col = column;
        }
    }

    public static class IsRowValid extends RowColumnObject implements Runnable {

        IsRowValid(int row, int column) {
            super(row, column);
        }

        @Override
        public void run() {
            if (col != 0 || row > 8) {
                System.out.println("Invalid row or column for row subsection"+" row ="+row+" col ="+col+"  ROW");
                return;
            }

            boolean[] validityArray = new boolean[9];
            for (int i = 0; i < 9; i++) {
                int num = sudoku[row][i];
                if (num < 1 || num > 9 || validityArray[num - 1]) {
                    System.out.println("row="+row+"   invalid");
                    return;
                } else if (!validityArray[num - 1]) {
                    validityArray[num - 1] = true;
                }
            }

            //row's valid = 9~17
            valid[9 + row] = true;
        }
    }

    public static class IsColumnValid extends RowColumnObject implements Runnable {

        IsColumnValid(int row, int column) {
            super(row, column);
        }

        @Override
        public void run() {
            if (row != 0 || col > 8) {
                System.out.println("Invalid row or column for row subsection"+" row ="+row+" col ="+col+"  COL");
                return;
            }

            boolean[] validityArray = new boolean[9];

            for (int i = 0; i < 9; i++) {
                int num = sudoku[i][col];
                if (num < 1 || row > 9 || validityArray[num - 1]) {
                    System.out.println("col="+col+"   invalid");
                    return;
                } else if (!validityArray[num - 1]) {
                    validityArray[num - 1] = true;
                }
            }

            valid[18 + col] = true;

        }
    }


    public static class Is3x3Valid extends RowColumnObject implements Runnable {

        Is3x3Valid(int row, int column) {
            super(row, column);
        }

        @Override
        public void run() {
            if (row > 6 || row % 3 != 0 || col > 6 || col % 3 != 0) {
                System.out.println("Invalid row or column for row subsection"+" row ="+row+" col ="+col+"  3x3");
                return;
            }

            boolean[] validityArray = new boolean[9];
            for (int i = row; i < row + 3; i++) {
                for (int j = col; j < col + 3; j++) {
                    int num = sudoku[i][j];
                    if (num < 1 || num > 9 || validityArray[num - 1]) {
                        System.out.println("row="+row+" col="+col+"   invalid");
                        return;
                    } else if (!validityArray[num - 1]) {
                        validityArray[num - 1] = true;
                    }
                }
            }

            valid[row + col / 3] = true;
        }
    }


    public static void main(String[] args) {
        valid = new boolean[NUM_THREAD];
        Thread[] threads = new Thread[NUM_THREAD];
        int threadIndex = 0;


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i % 3 == 0 && j % 3 == 0) {
                    threads[threadIndex++] = new Thread(new Is3x3Valid(i, j));
                }
                if (i == 0) {
                    threads[threadIndex++] = new Thread(new IsColumnValid(i, j));
                }
                if (j == 0) {
                    threads[threadIndex++] = new Thread(new IsRowValid(i, j));
                }
            }
        }

        //start all threads
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        //wait for all threads to finish
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        //valid's check
        for (int i = 0; i < valid.length; i++) {
            if(!valid[i]){
                System.out.println("Sudoku solution is invalid!");
                return;
            }
        }

        System.out.println("Sudoku solution is valid!");

    }
}

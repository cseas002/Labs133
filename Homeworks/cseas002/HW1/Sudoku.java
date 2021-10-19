package Homeworks.cseas002.HW1;

import edu.princeton.cs.introcs.*;

public class Sudoku {

    public Sudoku() {}

    /**
     *@author: Chirstoforos Seas 1028675
     */
    private int[][] sudoku = new int[9][9]; //sudoku array
    private boolean[][] sudoku_numbers = new boolean[9][9]; //pinakas pou exei ta stoixeia an oi arithmoi dwthikan apo prin
    private In scan; //scanning from file

    /**
     * Returns sudoku
     * @return sudoku array
     */
    public int[][] getSudoku()
    {
        return sudoku;
    }
    public boolean[][] getSudokuNumbers()
    {
        return sudoku_numbers;
    }


    /**
     * Initializing sudoku
     */
    private void initialize(String args)
    {
        scan = new In(args);
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = scan.readInt();
                if (sudoku[i][j] != 0)
                    sudoku_numbers[i][j] = true;
            }
    }

    /**
     * Printing menu and playing the Game
     */
    private void menu()
    {
        int choose;
        int i, j, num;
        while (true) {
            if (check_done())
            {
                StdOut.println("You won! ");
                return ;
            }
            StdOut.println("MENU:\n1: ADD A NUMBER\n2: REMOVE A NUMBER\n3: EXIT\n\n\nChoose: ");
            do {
                choose = StdIn.readInt();
                if (choose < 1 || choose > 3)
                    StdOut.println("Wrong Input");
            } while (choose < 1 || choose > 3);

            switch (choose) {
                case 1:
                    StdOut.print("Which number do you want to add and where? (Type the number first and then its X Y coordinates starting with 0) ");
                    num = StdIn.readInt();
                    j = StdIn.readInt();
                    i = StdIn.readInt();
                    add(i, j, num);
                    break;

                case 2:
                    StdOut.print("Where? (X Y coordinates starting with 0)");
                    j = StdIn.readInt();
                    i = StdIn.readInt();
                    remove(i, j);
                    break;

                case 3:
                    StdOut.println("Program stopped. Thank you for playing! ");
                    return;
            }
            StdOut.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            print();
        }
    }

    /**
     * Checking if the sudoku is done
     * @return true if sudoku is done
     */
    public boolean check_done()
    {
        return Sudoku_Checker.checkDone(sudoku);
    }


    /**
     * printing Sudoku
     */
    private void print()
    {
        boolean found;
        for (int i = 0; i < 9; i++)
        {
            found = false;
            for (int j = 0; j < 9; j++)
            {
                if (i % 3 == 0 && !found) {
                    found = true;
                    for (int k = 0; k < 13; k++)
                        if (k % 4 == 0)
                            StdOut.print("+ ");
                        else
                        StdOut.print("- ");
                    StdOut.println();
                }
                if (j % 3 == 0)
                    StdOut.print("| ");

                if (sudoku[i][j] != 0)
                    StdOut.print(sudoku[i][j] + " ");
                else
                    StdOut.print("  ");
            }
            StdOut.println("|");
        }

        for (int k = 0; k < 13; k++)
            if (k % 4 == 0)
                StdOut.print("+ ");
            else
                StdOut.print("- ");

            StdOut.println("\n\n");
    }


    /**
     * Adding a number to sudoku
     * @param i Y coordinate
     * @param j X coordinate
     * @param num number to add
     */
    private void add(int i, int j, int num)
    {
        if (num < 1 || num > 9)
        {
            StdOut.println("Wrong number Input ");
            return ;
        }

        if (sudoku_numbers[i][j])
        {
            StdOut.println("Wrong coordinates Input ");
            return ;
        }

        sudoku[i][j] = num;
    }

    /**
     * Removing a number from sudoku
     * @param i Y coordinate
     * @param j X coordinate
     */
    private void remove(int i, int j)
    {
        if (sudoku_numbers[i][j])
        {
            StdOut.println("Wrong coordinates Input ");
            return ;
        }

        sudoku[i][j] = 0;
    }

    /**
     * Exporting sudoku to a text file
     */
    private void export_sudoku()
    {
        Out export = new Out("out-sudoku.txt");
        for (int i = 0; i < 9; i++)
        {
            export.println();
            for (int j = 0; j < 9; j++)
                export.print(sudoku[i][j] + " ");
        }
    }


    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {
        Sudoku test_sudoku = new Sudoku(); {}
            test_sudoku.initialize(args[0]);

            StdDraw.setXscale(-20, 20);
            StdDraw.setYscale(-20, 20);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setPenRadius(0.1);
            boolean valid = false;

            StdDraw.text(0, 18, "Έκανα το πρόγραμμα και με γραφικό τρόπο,");
            StdDraw.text(0, 16, "αν θέλετε να χρησιμοποιήσετε τον CLI τρόπο όμως επιλέξτε CLI,");
            StdDraw.text(0, 14, "αλλιώς GUI");

            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.filledSquare(-5, 5, 4);
            StdDraw.filledSquare(5, 5, 4);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(-5, 5, "CLI");
            StdDraw.text(5, 5, "GUI");

            while (!valid) { //gia to gui i to cli
                if (StdDraw.isMousePressed())
                    if (StdDraw.mouseX() > 1 && StdDraw.mouseX() < 9 && StdDraw.mouseY() > 1 && StdDraw.mouseY() < 9) {
                        valid = true;
                        StdDraw.clear();
                        Sudoku_GUI my_sudoku = new Sudoku_GUI(test_sudoku);
                    } else if (StdDraw.mouseX() < -1 && StdDraw.mouseX() > -9 && StdDraw.mouseY() > 1
                            && StdDraw.mouseY() < 9) {
                        StdDraw.text(-5, -1, "Συνεχίστε από το terminal");
                        test_sudoku.print();
                        test_sudoku.menu();
                        valid = true;
                    }
            }
            test_sudoku.export_sudoku();
        }
}

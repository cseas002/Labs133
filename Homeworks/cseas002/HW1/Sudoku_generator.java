package Homeworks.cseas002.HW1;

import edu.princeton.cs.introcs.StdOut;

public class Sudoku_generator {
    private int dyskolia;
    private int[][] sudoku = new int[9][9];
    private boolean[][] sudoku_numbers = new boolean[9][9];


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


    private void create_boolean_sudoku()
    {
        double difficulty = 0;
        switch (dyskolia)
        {
            case 1:
                difficulty = 0.667;
                break;

            case 2:
                difficulty = 0.5;
                break;

            case 3:
                difficulty = 0.3333;
        }

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (Math.random() <= difficulty)
                    sudoku_numbers[i][j] = true;
    }

    private boolean valid(int[] arr)
    {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < i; j++)
                if (arr[i] == 0)
                    return true;
                else if (arr[j] == arr[i])
                    return false;

                return true;
    }

    private boolean valid_box(int box, int itarget, int jtarget)
    {
            for (int i = 0 + box * 3; i < 3 + box * 3; i++)
                for (int j = 0 + box * 3; j < 3 + box * 3; j++)
                    if (sudoku[i][j] == 0)
                        return true;
                    else if (i == itarget && j == jtarget)
                        return true;
                    else if (sudoku[i][j] == sudoku[itarget][jtarget])
                        return false;


                return true;
    }

    private void create_independent_boxes()
    {
        //box 0 top left
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
            {
                do {
                    sudoku[i][j] = (int) (Math.random() * 9) + 1;
                } while (!valid_box(0, i, j));
            }

        //box 1 center
        for (int i = 3; i < 6; i++)
            for (int j = 3; j < 6; j++)
            {
                do {
                    sudoku[i][j] = (int) (Math.random() * 9) + 1;
                } while (!valid_box(1, i, j));
            }

        //box 2 bottom right
        for (int i = 6; i < 9; i++)
            for (int j = 6; j < 9; j++)
            {
                do {
                    sudoku[i][j] = (int) (Math.random() * 9) + 1;
                } while (!valid_box(2, i, j));
            }
    }

    private boolean box(int i, int j)
    {
        boolean box0 = i >= 0 && i < 3 && j >= 0 && j < 3;
        boolean box1 = i >= 3 && i < 6 && j >= 3 && j < 6;
        boolean box2 = i >= 6 && i < 9 && j >= 6 && j < 9;
        return (box0 || box1 || box2);
    }

    private void create_sudoku()
    {
        int[] box1, box2;
        //ta koutia 0, 4 kai 8 einai aneksartita gi' afto tha ginontai afta prwta kai den tha allazoun
        create_independent_boxes();
        boolean valid = false;

        //top 3 lines
        do {
            //ta ksanamidenizei etsi wste an den doulevoun na ta ksanakanei
            for (int i = 0; i < 3; i++)
                for (int j = 3; j < 9; j++)
                    sudoku[i][j] = 0;

            for (int i = 0; i < 3; i++)
                for (int j = 3; j < 9; j++)
                    do {
                        sudoku[i][j] = (int) (Math.random() * 9 + 1);
                    } while (!valid(sudoku[i]));

                    box1 = Sudoku_Checker.create_box(sudoku, 1);
            box2 = Sudoku_Checker.create_box(sudoku, 2);
        }while (!(Sudoku_Checker.checkLine(box1) && Sudoku_Checker.checkLine(box2)));

        //middle 3  lines
        do {
            //ta ksanamidenizei etsi wste an den doulevoun na ta ksanakanei
            for (int i = 3; i < 6; i++)
                for (int j = 0; j < 9; j++)
                    if (j < 3 || j > 5)
                    sudoku[i][j] = 0;


            for (int i = 3; i < 6; i++)
                for (int j = 0; j < 9; j++)
                    if (j < 3)
                    do {
                        sudoku[i][j] = (int) (Math.random() * 9 + 1);
                    } while (sudoku[i][0] == sudoku[i][1] || sudoku[i][0] == sudoku[i][2]);
                    else if (j > 5)
                        do {
                            sudoku[i][j] = (int) (Math.random() * 9 + 1);
                        } while (sudoku[i][6] == sudoku[i][7] || sudoku[i][6] == sudoku[i][8]);

            box1 = Sudoku_Checker.create_box(sudoku, 3);
            box2 = Sudoku_Checker.create_box(sudoku, 5);
            valid = Sudoku_Checker.checkLine(sudoku[3]) && Sudoku_Checker.checkLine(sudoku[4]) && Sudoku_Checker.checkLine(sudoku[5]) && Sudoku_Checker.checkLine(box1) && Sudoku_Checker.checkLine(box2);

        }while (!valid);

        //bottom 3 lines
        do {
            //ta ksanamidenizei etsi wste an den doulevoun na ta ksanakanei
            for (int i = 6; i < 9; i++)
                for (int j = 0; j < 6; j++)
                    sudoku[i][j] = 0;

            for (int i = 6; i < 9; i++)
                for (int j = 0; j < 6; j++)
                    if (j < 3)
                        do {
                            sudoku[i][j] = (int) (Math.random() * 9 + 1);
                        } while (sudoku[i][0] == sudoku[i][1] || sudoku[i][0] == sudoku[i][2]);
                    else // j < 6
                        do {
                            sudoku[i][j] = (int) (Math.random() * 9 + 1);
                        } while (sudoku[i][3] == sudoku[i][4] || sudoku[i][3] == sudoku[i][5]);

            box1 = Sudoku_Checker.create_box(sudoku, 6);
            box2 = Sudoku_Checker.create_box(sudoku, 7);
            valid = Sudoku_Checker.checkLine(sudoku[6]) && Sudoku_Checker.checkLine(sudoku[7]) && Sudoku_Checker.checkLine(sudoku[8]) && Sudoku_Checker.checkLine(box1) && Sudoku_Checker.checkLine(box2);
        }while (!valid);


    }

    private void generate_sudoku()
    {
        create_boolean_sudoku();
        create_sudoku();
    }

    public Sudoku_generator(boolean GUI, int dyskolia)
    {
        this.dyskolia = dyskolia;
        generate_sudoku();
    }

    public static void main(String[] args) {
        Sudoku_generator test = new Sudoku_generator(true, 1);
        test.print();
    }
}

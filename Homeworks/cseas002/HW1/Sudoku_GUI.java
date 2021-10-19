package Homeworks.cseas002.HW1;

import edu.princeton.cs.introcs.StdDraw;

public class Sudoku_GUI {
    private int[][] sudoku;
    private boolean[][] sudoku_numbers;

    private void show_panel()
    {
        StdDraw.setXscale(-45, 45);
        StdDraw.setYscale(-45, 45);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);
        StdDraw.line(-45, 45, 45, 45); //panw grammi
        StdDraw.line(-45, -45, 45, -45); //katw grammi
        StdDraw.line(45, 45, 45, -45); //deksia grammi
        StdDraw.line(-45, -45, -45, 45); //aristeri grammi

        //oi xontres grammes gia na diaxwrizoun ta koutia
        StdDraw.line(-15, -45, -15, 45);
        StdDraw.line(15, -45, 15, 45);

        StdDraw.line(-45, -15, 45, -15);
        StdDraw.line(-45, 15, 45, 15);

        StdDraw.setPenRadius(0.003);
        for (int i = 0; i < 9; i++) { //oi pio leptes grammes
            StdDraw.line(-35 + i * 10, -45, -35 + i * 10, 45);
            StdDraw.line(-45, -35 + i * 10, 45, -35 + i * 10);
        }
    }

    private void show_numbers() //parousiazei tous arithmous stis theseis tous
    {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (sudoku[i][j] != 0)
                StdDraw.text(-40 + (j * 10), 40 - (i * 10), String.valueOf(sudoku[i][j]));
    }

    /**
     * elegxei an mporei na allaksei o arithmos ekei pou patise o xristis
     * @param x to x tou mouse
     * @param y to y tou mouse
     * @return an mporei na allaksei epistrefei true
     */
    private boolean check_valid(double x, double y)
    {
        double I = (45 - y) / 10;
        double J = (45 + x) / 10;
        int i = (int) I;
        int j = (int) J;
        return !sudoku_numbers[i][j]; //true an ypirxe prin arithmos ara tha epistrefei to anapodo
    }

    /**
     * Vafei to tetragwno pou patithike
     * @param x to x tou mouse
     * @param y to y tou mouse
     */
    private void vapsimo(double x, double y)
    {
        double I = (45 - y) / 10;
        double J = (45 + x) / 10;
        int i = (int) I;
        int j = (int) J;
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledSquare(-40 + j * 10, 40 - i * 10, 5);
    }

    /**
     *
     * @param x to x tou mouse
     * @param y to y tou mouse
     */
    private void pliktrologio(double x, double y)
    {
        double I = (45 - y) / 10;
        double J = (45 + x) / 10;
        int i = (int) I;
        int j = (int) J;

        boolean is_key_pressed = false;

        while (!is_key_pressed)
            if (StdDraw.hasNextKeyTyped())
            {
                char num = StdDraw.nextKeyTyped();
                if (Character.isDigit(num))
                {
                    sudoku[i][j] = num - 48;
                    is_key_pressed = true;
                }
            }
    }

    private void mouse_interactions()
    {
        boolean click = false;

        while (!click)
            if (StdDraw.isMousePressed())
                if (check_valid(StdDraw.mouseX(), StdDraw.mouseY()))
                {
                    click = true;
                    vapsimo(StdDraw.mouseX(), StdDraw.mouseY());
                    pliktrologio(StdDraw.mouseX(), StdDraw.mouseY());
                }
    }

    /**
     *
     * @param my_sudoku to sudoku pou epeksergazomaste
     */
    public Sudoku_GUI(Sudoku my_sudoku)
    {
        sudoku = my_sudoku.getSudoku();
        sudoku_numbers = my_sudoku.getSudokuNumbers();
        while (!my_sudoku.check_done()) {
            show_panel();
            show_numbers();
            mouse_interactions();
            StdDraw.clear();
        }
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(0,0,"You win!!!");
    }
}

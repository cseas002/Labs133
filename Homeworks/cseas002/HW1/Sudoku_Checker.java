package Homeworks.cseas002.HW1;


public class Sudoku_Checker {

    private static int[] checker = {1, 2, 3, 4, 5, 6, 7, 8 , 9};

    /**
     *
     * @param arr o pinakas pou einai o arithmos (9 thesewn)
     * @param num o arithmos pou elegxoume an einai swstos
     * @return true an einai valid
     */
    private static boolean valid_num(int[] arr, int num)
    {
        if (num == 0) //an dinetai o arithmos 0 diladi den exei arithmo tote stamata dinontas pws einai lathos
            return false;

        for (int i = 0; i < 9; i++)
            if (arr[i] == num) //an vrei ton arithmo ton midenizei ston pinaka kai stamata
            {
                arr[i] = 0;
                return true;
            }

        return false; //epistrefei lathos an den ton vrei
    }

    /**
     *
     * @param sudoku to sudoku pou epeksergazomaste
     * @param target poia stili kanoume pinaka
     * @return ton pinaka sti stili target
     */
    private static int[] create_column_array(int[][] sudoku, int target)
    {
        int[] column = new int[9];

        for (int i = 0; i < 9; i++)
            column[i] = sudoku[i][target];

        return column;
    }

    /**
     *
     * @param arr o pinakas 9 thesewn
     * @return true an einai entaksei i grammi / stili / tetragwno
     */
    public static boolean checkLine(int[] arr)
    {
        int[] check = new int[9];

        for (int i = 0; i < 9; i++)
            check[i] = checker[i];

        for (int i : arr)
            if (!valid_num(check, i)) //elegxei kathe arithmos an einai to 0 i an ksanavrethike
                return false;


        return true; //an vrethikan oloi tote epistrefei true
    }

    /**
     *
     * @param sudoku to sudoku pou epeksergazomaste
     * @return true an oles oi grammes einai swstes
     */
    public static boolean checkLines(int[][] sudoku)
    {
        for (int[] row : sudoku) {
            if (!checkLine(row))
                return false;
        }

        for (int i = 0; i < 9; i++) {
            int[] column = create_column_array(sudoku, i);
            if (!checkLine(column))
                return false;
        }

        return true;
    }

    /**
     *
     * @param sudoku to sudoku pou epeksergazomaste
     * @param box_num poio kouti tha kanoume pinaka (panw aristera 0, deksia tou 1 kai katw tou to 4)
     * @return to kouti se morfi pinaka 9 thesewn
     */
    public static int[] create_box(int[][] sudoku, int box_num)
    {
        int starti, startj; //oi syntetagmenes pou tha ksekinisei
        int a, b;
        starti = box_num / 3 * 3; //apo pou tha ksekinisei se ypsos
        startj = box_num % 3 * 3; //apo pou tha ksekinisei se mikos
        int[] box = new int[9];

        for (int i = 0; i < 9; i++) {
            b = i % 3; //proxwra pros ta deksia kai meta
            a = i / 3; //paei ena vima katw
            box[i] = sudoku[starti + a][startj + b];
        }
        return box;
    }

    /**
     *
     * @param sudoku to sudoku pou epeksergazomaste
     * @return true an ola ta koutia einai entaksei
     */
    public static boolean checkBoxes(int[][] sudoku)
    {
        for (int i = 0; i < 9; i++)
        {
            int[] box = create_box(sudoku, i); //to prwto box einai to panw aristera kai to teleftaio to katw deksia
            if (!checkLine(box))
                return false;
        }

        return true;
    }

    public static boolean checkDone(int[][] sudoku)
    {
        return checkLines(sudoku) && checkBoxes(sudoku);
    }
}

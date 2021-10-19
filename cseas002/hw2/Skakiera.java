package cseas002.hw2;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Skakiera {
    /**
     * @author Chritoforos Seas 1028675
     */


    private final int N;
    private final Cell[][] board;
    private int FruitX, FruitY;
    private int HeadX, HeadY;
    private int score; //0 by default
    private char dir = 'r';
    public boolean GUI;

    /**
     * Constructor with given rows
     * @param N rows number
     */
    Skakiera(int N)
    {
        this.N = N;
        board = new Cell[N][2 * N + 1];
        initialize();
    }

    /**
     * Default constructor with 8 rows
     * using {@link #Skakiera()}
     */
    Skakiera()
    {
        this(8);
    }

    /**
     * Method that prints the board
     */
    private void print()
    {
        StdOut.print("Score: " + score + "\n\n");
        for (int j = 0; j < 2 * N + 3; j++)
            StdOut.print("*");

        StdOut.println();

        for (int i = 0; i < N; i++)
        {
            StdOut.print("*");
            for (int j = 0; j < 2 * N + 1; j++)
                StdOut.print(board[i][j]);
            StdOut.println("*");
        }

        for (int j = 0; j < 2 * N + 3; j++)
            StdOut.print("*");

        StdOut.println("\n\n\n\n");
    }

    /**
     * Method which calculates the next Fruit coordinates
     */
    private void FruitPositions()
    {
        do
        {
            FruitX = (int) (Math.random() * (2 * N + 1)); //apo 0 mexri 2N
            FruitY = (int) (Math.random() * N); //apo 0 mexri N
        }while (!board[FruitY][FruitX].isEmpty());
    }

    /**
     * initialization method
     */
    private void initialize()
    {
        HeadX = N; //sto kentro
        HeadY = N / 2 - 1; //sto kentro
        for (int i = 0; i < N; i++)
            for (int j = 0; j < 2 * N + 1; j++)
                board[i][j] = new Cell();

        board[HeadY][HeadX].setHead(true);
        FruitPositions();
        board[FruitY][FruitX].setFruit(true);
        board[HeadY][HeadX].tailpos = 1;
    }

    /**
     * Method which refreshes tail positions
     * adding 1 to every position and removing the last
     * or just adding one if the snake eats fruit adding one extra tail
     */
    private void refreshpositions()
    {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < 2 * N + 1; j++)
                if (!board[i][j].getHead()) {
                    if (board[i][j].tailpos > 0) {
                        if (board[i][j].tailpos == score + 1) //an einai to teleftaio stin oura
                        {
                            if (!board[i][j].getFruit()) //kai den efage frouto
                                board[i][j].tailpos = 0;
                        }  else
                                board[i][j].tailpos++;
                    }

                }
    }

    /**
     * Method that checks if you lose
     * @return true if you lose with a message
     */
    private boolean checklose()
    {
        if (HeadY < 0 || HeadY >= N || HeadX < 0 || HeadX > 2 * N || board[HeadY][HeadX].tailpos > 1) //an vgike extos i yparxei oura ekei
        {
            StdOut.println("Game Over!");
            return true;
        }
        return false;
    }

    /**
     * Method which is used to move the snake
     */
    private void move()
    {
        refreshpositions();

        if (board[HeadY][HeadX].getFruit())
        {
            score ++;
            FruitPositions();
            board[FruitY][FruitX].setFruit(true);
            board[HeadY][HeadX].setFruit(false);
        }


    }

    /**
     * main menu method which controls the Game
     */
    private void menu()
    {
        while (true){

            if (!GUI) {
                print();
                StdOut.print("Player move (l - left, r – right, u – up, d - down, e - exit): ");

                do {
                    dir = StdIn.readString().charAt(0);
                    if (!(dir == 'l' || dir == 'r' || dir == 'u' || dir == 'd' || dir == 'e'))
                        StdOut.println("Wrong Input");
                } while (!(dir == 'l' || dir == 'r' || dir == 'u' || dir == 'd' || dir == 'e'));
            }
            else
            {
                FidakiGUI fidaki = new FidakiGUI(this, dir);
            }

                board[HeadY][HeadX].setHead(false);
                if (score == 0)
                    board[HeadY][HeadX].tailpos = 0;

                switch (dir) {
                    case 'l':
                        HeadX--;
                        break;

                    case 'r':
                        HeadX++;
                        break;

                    case 'u':
                        HeadY--;
                        break;

                    case 'd':
                        HeadY++;
                        break;

                    case 'e':
                        HeadX = -1;
                }

                if (checklose())
                    return;

                board[HeadY][HeadX].setHead(true);

            move();
        }
    }

    /**
     * N getter for GUI
     * @return N value
     */
    public int getN()
    {
        return N;
    }

    /**
     * board getter for GUI
     * @param i i of board
     * @param j j of board
     * @return toString() value of board[i][j]
     * F for fruit, S for head, s for tail and space for other
     */
    public String getBoard(int i, int j)
    {
        return board[i][j].toString();
    }

    /**
     * Direction setter
     * @param dir value which will be set
     */
    public void setDir(char dir)
    {
        this.dir = dir;
    }

    /**
     * Method for the start menu
     */
    public void startmenu()
    {
        StdDraw.setXscale(-20, 20);
        StdDraw.setYscale(-20, 20);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.1);
        boolean valid = false;

        StdDraw.text(0, 18, "Έκανα το πρόγραμμα και με γραφικό τρόπο,");
        StdDraw.text(0, 16, "αν θέλετε να χρησιμοποιήσετε τον CLI τρόπο όμως επιλέξτε CLI,");
        StdDraw.text(0, 14, "αλλιώς GUI (κινείται με τα wasd)");

        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledSquare(-5, 5, 4);
        StdDraw.filledSquare(5, 5, 4);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(-5, 5, "CLI");
        StdDraw.text(5, 5, "GUI");

        while (!valid) { //for GUI or CLI
            if (StdDraw.isMousePressed())
                if (StdDraw.mouseY() > 1 && StdDraw.mouseY() < 9) {
                    if (StdDraw.mouseX() > 1 && StdDraw.mouseX() < 9) {
                        valid = true;
                        StdDraw.clear();
                        GUI = true;
                    } else if (StdDraw.mouseX() < -1 && StdDraw.mouseX() > -9) {
                        StdDraw.text(-5, -1, "Συνεχίστε από το terminal");
                        GUI = false;
                        valid = true;
                    }
                }
        }
    }

    /**
     * Main method for test
     * @param args if empty then 8 rows
     *             otherwise args[0] rows
     */
    public static void main(String[] args) {
        Skakiera test;
        if (args.length == 0) {
            test = new Skakiera();
        }
        else
            test = new Skakiera(Integer.parseInt(args[0]));

        test.startmenu();
        test.menu();
    }
}

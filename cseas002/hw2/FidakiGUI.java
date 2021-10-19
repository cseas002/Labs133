package cseas002.hw2;

import static edu.princeton.cs.introcs.StdDraw.*;


public class FidakiGUI {
    /**
     * @author Chritoforos Seas 1028675
     * Class that controls GUI
     * Creates an object every time a change is being made
     * Using {@link Skakiera} object and direction
     * Using {@link edu.princeton.cs.introcs.StdDraw}
     */
    Skakiera fidaki;
    char dir;
    public static boolean once = false; //static parameter for printing outline only once

    /**
     * Method which prints the outline
     */
    private void outline()
    {
        for (double i = -fidaki.getN() + 0.5; i < 1; i++)
        {
            setPenColor(GREEN);
            filledRectangle(-0.75, i, 0.25, 0.5);
        }

        for (double i = -fidaki.getN() + 0.5; i < 1; i++)
        {
            setPenColor(GREEN);
            filledRectangle(fidaki.getN() * 2 + 0.75, i, 0.25, 0.5);
        }

        for (double j = -0.5; j < fidaki.getN() * 2 + 1; j++)
        {
            setPenColor(GREEN);
            filledRectangle(j, -fidaki.getN() + 0.25, 0.5, 0.5);
        }

        for (double j = -0.5; j < fidaki.getN() * 2 + 1; j++)
        {
            setPenColor(GREEN);
            filledRectangle(j, 0.75, 0.5, 0.5);
        }
        FidakiGUI.once = true;
    }


    /**
     * Methods which prints everything on screen
     */
    private void show()
    {
        setYscale(-fidaki.getN(), 1);
        setXscale(-1, fidaki.getN() * 2 + 1);

        if (!once)
        outline();


        for (int i = 0; i < fidaki.getN(); i++)
            for (int j = 0; j < fidaki.getN() * 2 + 1; j++)
                switch (fidaki.getBoard(i, j).charAt(0))
                {
                    case 'F':
                        setPenColor(RED);
                        filledRectangle(j, -i, 0.5, 0.25);
                        break;
                    case 'S':
                        setPenColor(BLUE);
                        filledRectangle(j, -i, 0.5, 0.25);
                        break;
                    case 's':
                        setPenColor(BOOK_BLUE);
                        filledRectangle(j, -i, 0.5, 0.25);
                        break;
                    default:
                        setPenColor(WHITE);
                        filledRectangle(j, -i, 0.51, 0.26); //instead of clear
                        break;
                }
    }

    /**
     * Method which controls movement with keyboard keys
     * w for up
     * s for down
     * a for left
     * d for right
     */
    private void pliktrologio()
    {
        double time = System.currentTimeMillis();

        while (System.currentTimeMillis() - time < 10) //every 10ms the snake moves
            if (hasNextKeyTyped())
                switch (nextKeyTyped())
                {
                    case 'w':
                        fidaki.setDir('u');
                        break;

                    case 's':
                        fidaki.setDir('d');
                        break;

                    case 'a':
                        fidaki.setDir('l');
                        break;

                    case 'd':
                        fidaki.setDir('r');
                }


    }

    /**
     * Constructor
     * @param fidaki the board object
     * @param dir the direction of the snake which
     *            is right by default
     */
    public FidakiGUI(Skakiera fidaki, char dir)
    {
        this.fidaki = fidaki;
        this.dir = dir;
        show();
        pliktrologio();
    }
}

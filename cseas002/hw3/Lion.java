package cseas002.hw3;

import java.awt.*;
import java.util.Random;

/**
 * @author Christoforos Seas 1028675
 */
public class Lion extends Critter {
    private Color color;
    private int count = 1;

    /**
     * Default constructor
     */
    public Lion()
    {
        choose_color();
    }

    /**
     * Method which chooses the lion's color
     * using {@link Random}
     */
    private void choose_color()
    {
        Random r = new Random();
        int rand = r.nextInt(3);
        if (rand == 0)
            color = Color.RED;
        else if (rand == 1)
            color = Color.GREEN;
        else
            color = Color.BLUE;
    }

    /**
     * color parameter getter
     * @return color
     */
    public Color getColor()
    {
        return color;
    }

    /**
     * Method which returns the action the animal will do
     * @param info information of the simulation
     * @return the action it will take
     */
    public Action getMove(CritterInfo info)
    {
        count ++;
        if (info.getFront().equals(Neighbor.OTHER))
            return Action.INFECT;
        else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL)
            return Action.LEFT;
        else if (info.getFront() == Neighbor.SAME)
            return Action.RIGHT;
        else
            return Action.HOP;
    }

    /**
     * To String method
     * @return "L"
     */
    public String toString()
    {
        if (count % 3 == 0)
            choose_color();
        return "L";
    }
}

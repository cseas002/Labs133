package cseas002.hw3;

import java.awt.*;

/**
 * @author Christoforos Seas 1028675
 */

public class Bear extends Critter {
    private final Color color;
    private boolean forward;

    /**
     * Default constructor
     */
    public Bear(boolean polar)
    {
      //  boolean polar = Math.random() < 0.5; //50% chance
        if (polar)
            color = Color.WHITE;
        else
            color = Color.BLACK;
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
        if (info.getFront().equals(Neighbor.OTHER))
            return Action.INFECT;
        else if (info.getFront() == Neighbor.EMPTY)
            return Action.HOP;
        else
        return Action.LEFT;
    }

    /**
     * To String method
     * @return "\" or "/"
     */
    public String toString()
    {
        if (forward)
        {
            forward = false;
            return "\\";
        }
        else
        {
            forward = true;
            return "/";
        }
    }
}

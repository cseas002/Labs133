package cseas002.hw3;

import java.awt.*;

/**
 * @author Christoforos Seas 1028675
 */

public class Giant extends Critter {
    private int moves = 0;
    private final Color color = Color.GRAY;

    /**
     * Default constructor
     */
    public Giant() {}

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
        moves++;
        if (info.getFront().equals(Neighbor.OTHER))
            return Action.INFECT;
        else if (info.getFront() == Neighbor.EMPTY)
            return Action.HOP;
        else
            return Action.LEFT;
    }

    /**
     * ToString method
     * @return "fee" or "fie" or "foe" or "fum"
     */
    public String toString()
    {
        if (moves == 24)
            moves = 0;

        if (moves < 6)
            return "fee";
        else if (moves < 12)
            return "fie";
        else if (moves < 18)
            return "foe";
        else if (moves < 24)
            return "fum";

        else
            return "WRONG";
    }
}

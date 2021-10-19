package cseas002.hw3;

import java.awt.*;

public class Husky extends Critter {
    /**
     * @author Christoforos Seas 1028675
     * Ta husky pairnoun mia monada power otan kanoun infect kati allo, kai gia na ginoun infected
     * xreiazontai tosa infections osa einai to power tous
     *
     * Diladi ena husky me power 4 xreiazetai 4 infections gia na ginei infected
     */

    private final Color color = Color.MAGENTA;
    private int power; //from 0-9

    /**
     * Default constructor
     */
    public Husky()
    {}

    /**
     * Method which returns the action the animal will do
     * @param info information of the simulation
     * @return the action it will take
     */
    public Action getMove(CritterInfo info)
    {
        if (info.getFront().equals(Neighbor.OTHER)) {
            power ++;
            return Action.INFECT;
        }
        else if (info.getRight() != Neighbor.WALL && Math.random() > 0.9)
            return Action.RIGHT; //turns right every 10 steps approximately
        else if (info.getFront() == Neighbor.EMPTY)
            return Action.HOP;
        else
            return Action.LEFT;
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
     * Method which lowers the power of the husky by one
     * Used when the husky is infected and its power is more than 0
     */
    public void lowerPower()
    {
        power --;
    }

    /**
     * To String method
     * @return "h" for 0 power, "hu" for 1, "hus" for 2, "husk" for 3, "husky" for 4,
     * "Husky" for 5, "HUsky" for 6, "HUSky" for 7, "HUSKy" for 8 and "HUSKY" for 9
     *
     * it can be replaced with enhanced switch (lines 117 - 132) (Java version 13)
     */
    public String toString()
    {
        String str;
        switch (power)
        {
            case 0:
                str = "h";
                break;

            case 1:
                str = "hu";
                break;

            case 2:
                str = "hus";
                break;

            case 3:
                str = "husk";
                break;

            case 4:
                str = "husky";
                break;

            case 5:
                str = "Husky";
                break;

            case 6:
                str = "HUsky";
                break;

            case 7:
                str = "HUSky";
                break;

            case 8:
                str = "HUSKy";
                break;

            default:
                str = "HUSKY";
                power = 9;
        }

        return str;
    }


    /**
     * switch (power) {
     *             case 0 -> str = "h";
     *             case 1 -> str = "hu";
     *             case 2 -> str = "hus";
     *             case 3 -> str = "husk";
     *             case 4 -> str = "husky";
     *             case 5 -> str = "Husky";
     *             case 6 -> str = "HUsky";
     *             case 7 -> str = "HUSky";
     *             case 8 -> str = "HUSKy";
     *             default -> {
     *                 str = "HUSKY";
     *                 power = 9;
     *             }
     *         }
     */
}

package cseas002.hw2;

public class Cell {
    /**
     * @author Chritoforos Seas 1028675
     * Class for every cell in the snake's board
     * Used from {@link Skakiera}
     * Having 3 variables {@link #fruit} true if the cell has a fruit
     * {@link #head} true if a cell has the snake's head
     * {@link #tailpos} the tail position of the snake, 1 for head
     */
    private boolean fruit, head; //false by default
    public int tailpos; //tail position

    /**
     * Default constructor
     */
    Cell() {} //default constructor, it could be not added

    /**
     * Checking if a cell is empty
     * @return true if it's empty
     */
    public boolean isEmpty()
    {
        return tailpos == 0 && !fruit;
    }

    /**
     * fruit variable Setter
     * @param fruit the fruit value
     */
    public void setFruit(boolean fruit)
    {
        this.fruit = fruit;
    }

    /**
     * head variable Setter
     * @param head the head value
     */
    public void setHead(boolean head)
    {
        this.head = head;
        if (head)
            tailpos = 1;
    }

    /**
     * toString() method which is used for printing
     * @return the string which will be printed
     */
    public String toString()
    {
        if (fruit)
            return "F";
        if (head)
            return "S";
        if (tailpos > 1)
            return "s";

        return " ";
    }

    /**
     * fruit variable getter
     * @return fruit value
     */
    public boolean getFruit()
    {
        return fruit;
    }

    /**
     * head variable getter
     * @return head value
     */
    public boolean getHead()
    {
        return head;
    }
}

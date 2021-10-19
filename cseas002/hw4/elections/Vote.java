package cseas002.hw4.elections;

/**
 * @author Christoforos Seas 1028675
 * Vote class
 */
abstract public class Vote {

    /**
     * name getter
     * @return the name
     */
    abstract String getName();

    /**
     * Date getter
     * @return the date
     */
    abstract int getDate();

    /**
     * Date Limit getter
     * @return date limit
     */
    abstract int getDateLimit();

    /**
     * name setter
     * @param name the name
     */
    abstract void setName(String name);

    /**
     * Date setter
     * @param date to be set
     */
    abstract void setDate(int date);

    /**
     * Date Limit setter
     * @param datelimit Date Limit
     */
    abstract void setDateLimit(int datelimit);

    /**
     * Method which checks if the vote is valid or not
     * @return true if the order is valid
     */
    abstract public boolean isValid();


    /**
     * Abstract Constructor
     * @param name name of the voted person
     * @param date date of vote
     * @param datelimit date limit for the vote
     */
    public Vote(String name, int date, int datelimit)
    {
        setName(name);
        setDate(date);
        setDateLimit(datelimit);
    }


    /**
     * toString() method
     * @return String
     */
    public String toString()
    {
        String str = "for " + getName();
        if (this instanceof BulletinElectronique)
            str += "\t\t\t\t";
        else if (this instanceof BulletinCourrier)
            str += "\t";
        else if (this instanceof BulletinPaper)
            str += "\t\t";

        if (getName().length() < 16)
            str += "\t";

        str += "-> " + (isValid() ? "valid" : "invalid");
        return str;
    }

}

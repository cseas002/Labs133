package cseas002.hw4.elections;

/**
 * @author Christoforos Seas 1028675
 * Bullet In Electronic class
 */

public class BulletinElectronique extends Vote implements CheckBulletin{

    private String name;
    private int date;
    private int datelimit;

    /**
     * name getter
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Date getter
     * @return date
     */
    @Override
    int getDate() {
        return date;
    }

    /**
     * Date Limit getter
     * @return Date Limit
     */
    @Override
    int getDateLimit() {
        return datelimit;
    }

    /**
     * Name Setter
     * @param name the name
     */
    @Override
    void setName(String name) {
        this.name = name;
    }

    /**
     * Date setter
     * @param date to be set
     */
    @Override
    public void setDate(int date) {
        this.date = date;
    }

    /**
     * Date Limit Setter
     * @param datelimit Date Limit
     */
    @Override
    public void setDateLimit(int datelimit) {
        this.datelimit = datelimit;
    }

    /**
     * Constructor
     * @param name name of the voted person
     * @param date date of vote
     * @param datelimit date limit for the vote
     */
    BulletinElectronique(String name, int date, int datelimit)
    {
        super(name, date, datelimit);
    }

    /**
     * Method which checks if the vote is valid or not
     * @return true if the order is valid
     */
    @Override
    public boolean isValid() {
        return checkDate();
    }

    /**
     * toString() method
     * @return String
     */
    public String toString()
    {
        return "electronic vote " + super.toString();
    }

    /**
     * Method which checks if the date is valid
     * @return true if the date is valid
     */
    @Override
    public boolean checkDate() {
        return datelimit - date >= 2;
    }
}

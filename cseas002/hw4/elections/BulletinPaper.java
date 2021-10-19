package cseas002.hw4.elections;

/**
 * @author Christoforos Seas 1028675
 * Bullet In Paper class
 */
public class BulletinPaper extends Vote implements CheckBulletin{

    private String name;
    private int date;
    private int datelimit;
    private boolean signed;

    /**
     * Sign getter
     * @return signed
     */
    public boolean isSigned() {
        return signed;
    }

    /**
     * Constructor
     * @param name name of the voted person
     * @param date date of vote
     * @param datelimit date limit for the vote
     * @param signed if the vote is signed or not
     */
    BulletinPaper(String name, int date, int datelimit, boolean signed)
    {
        super(name, date, datelimit);
        setSigned(signed);
    }

    /**
     * Sign setter
     * @param signed signed or not
     */
    public void setSigned(boolean signed)
    {
        this.signed = signed;
    }

    /**
     * Method which checks if the vote is valid or not
     * @return true if the order is valid
     */
    @Override
    public boolean isValid() {
        return checkDate() && isSigned();
    }

    /**
     * Method which checks if the date is valid
     * @return true if the date is valid
     */
    @Override
    public boolean checkDate() {
        return datelimit - date >= 2;
    }

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
     * @return date limit
     */
    @Override
    int getDateLimit() {
        return datelimit;
    }

    /**
     * name setter
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
     * Date limit setter
     * @param datelimit the date limit
     */
    @Override
    public void setDateLimit(int datelimit) {
        this.datelimit = datelimit;
    }

    /**
     * toString() method
     * @return String
     */
    public String toString()
    {
        return "voting by paper ballot " + super.toString();
    }
}

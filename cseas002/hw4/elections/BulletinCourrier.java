package cseas002.hw4.elections;

/**
 * @author Christoforos Seas 1028675
 * Bullet in Courrier class
 */
public class BulletinCourrier extends BulletinPaper implements CheckBulletin {

    private String name;
    private int date;
    private int datelimit;
    private boolean signed;

    /**
     * Constructor
     * @param name name of the voted person
     * @param date date of vote
     * @param datelimit date limit for the vote
     * @param signed if the vote is signed or not
     */
    BulletinCourrier(String name, int date, int datelimit, boolean signed)
    {
        super(name, date, datelimit, signed);
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
     * Sign getter
     * @return signed
     */
    public boolean isSigned() {
        return signed;
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
     * date setter
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
     * Method which checks if the date is valid
     * @return true if the date is valid
     */
    @Override
    public boolean checkDate() {
        return datelimit >= date;
    }

    /**
     * Method which checks if the vote is valid or not
     * @return true if the order is valid
     */
    @Override
    public boolean isValid()
    {
        return checkDate() && isSigned();
    }

    /**
     * toString() method
     * @return String
     */
    public String toString()
    {
        return super.toString().replace("voting by", "mailing of a");
    }

}

package cseas002.hw4.elections;

/**
 * @author Christoforos Seas 1028675
 * Candidate class
 */
public class Candidate {

    private final String name;
    private int votes;


    /**
     * name getter
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * votes getter
     * @return votes
     */
    public int getVotes() {
        return votes;
    }

    /**
     * Constructor
     * @param name the name of the candidate
     */
    public Candidate(String name)
    {
        this.name = name;
    }

    /**
     * Constructor
     * @param name the name of the candidate
     * @param votes amount of votes
     */
    public Candidate(String name, int votes)
    {
        this(name);
        this.votes = votes;
    }

    /**
     * Copy constructor
     * @param other the Candidate which will be copied
     */
    public Candidate(Candidate other)
    {
        this(other.name, other.votes);
    }

    /**
     * Method which adds 1 to votes
     */
    public void elect() {
        votes++;
    }

    /**
     * Method which initializes the votes to 0
     */
    public void init()
    {
        votes = 0;
    }

}

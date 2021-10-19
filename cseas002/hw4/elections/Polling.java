package cseas002.hw4.elections;

import java.util.ArrayList;

/**
 * @author Christoforos Seas 1028675
 */

public class Polling {
    private final ArrayList <Candidate> candidates = new ArrayList<>();
    private final ArrayList <Vote> votes = new ArrayList<>();
    private final int max_candidates;
    private final int date;

    /**
     * Constructor
     * @param candidates candidates list
     * @param max_candidates the maximum number of candidates
     * @param date the date
     */
    public Polling(ArrayList <Candidate> candidates, int max_candidates, int date)
    {
        for (Candidate candidate : candidates)
            this.candidates.add(new Candidate(candidate));
        this.max_candidates = max_candidates;
        this.date = date;
    }

    /**
     * Method which counts voters
     * @return voters number
     */
    public int countVoters()
    {
        int votes = 0;
        for (Candidate candidate : candidates)
            votes += candidate.getVotes();

        return votes;
    }

    /**
     * Method which returns the winner's name
     * @return winner's name
     */
    public String winner()
    {
        int max = 0;
        String name = "";

        for (Candidate candidate : candidates)
            if (candidate.getVotes() >= max) {
                name = candidate.getName();
                max = candidate.getVotes();
            }

        return name;
    }

    /**
     * Initializer
     * Method which initializes all candidates to 0 votes
     */
    public void init()
    {
        for (Candidate candidate : candidates)
            candidate.init();
    }

    /**
     * Method which calculates the votes
     */
    public void countVotes()
    {
        for (Vote vote : votes) //for each candidate
            if (vote.isValid()) //if his vote is valid
                for (Candidate cand : candidates) //search for the voted candidate
                    if (vote.getName().equals(cand.getName())) //if found
                    {
                        cand.elect(); //add one vote
                        break;
                    }
    }

    /**
     * Simulation method
     * @param percentage the percentage of voters
     * @param date the date
     */
    public void simulate(double percentage, int date)
    {
        int voters = (int) ((double) max_candidates * percentage);

        for (int i = 0; i < voters; i++)
        {
            int candNum = Utils.randomInt(candidates.size());
            Candidate cand = candidates.get(candNum);

            if (i % 3 == 0)
                votes.add((new BulletinElectronique(cand.getName(), date, this.date)));
            else if (i % 2 == 0)
                votes.add((new BulletinPaper(cand.getName(), date, this.date, candNum % 2 == 1))); //true if candNum is odd
            else
                votes.add(new BulletinCourrier(cand.getName(), date, this.date, candNum % 2 == 1));

        }

        for (Vote vote : votes)
            System.out.println(vote);
    }

    /**
     * Method which shows the results
     */
    public void results()
    {
        System.out.print("Rate of participation\t\t\t -> ");
        System.out.printf("%.1f", 100 * (double) countVoters() / (double) max_candidates);
        System.out.println(" per cent");
        System.out.println("Effective number of voters\t\t -> " + countVoters());
        System.out.println("The chosen leader is\t\t\t -> " + winner());
        System.out.println("\nDistribution of voters ");

        for (Candidate candidate : candidates) {
            System.out.print(candidate.getName() + (candidate.getName().length() > 16 ? "\t" : "\t\t") + " ->  + ");
            System.out.printf("%.2f", 100 * (double) candidate.getVotes() / (double) countVoters());
            System.out.println(" per cent of the voters");
        }

        System.out.println("\n\n\n\n\n\n");
    }

}

package cseas002.hw4.elections;//package hw4.spring2021;

import java.util.ArrayList;

/**
 * Test class  for the simulation
 */

public class Election {

	public static void main(String[] args) {
		// TEST 1
		System.out.println("Test part I:");
		System.out.println("-------------------------------------------------");

		ArrayList<Candidate> candidates = new ArrayList<>();
		candidates.add(new Candidate("Emmanuel Macron"));
		candidates.add(new Candidate("Marine Le Pen  "));
		candidates.add(new Candidate("Nicolas Sarkozy"));
		candidates.add(new Candidate("Jean-Luc Melenchon"));

		candidates.get(0).elect();
		candidates.get(0).elect();

		candidates.get(1).elect();
		candidates.get(1).elect();
		candidates.get(1).elect();

		candidates.get(2).elect();

		candidates.get(3).elect();
		candidates.get(3).elect();
		candidates.get(3).elect();
		candidates.get(3).elect();

		// 30 -> maximum number of voters
		// 15 day of election
		Polling polling = new Polling(candidates, 30, 15);
		polling.countVoters();
		polling.results();

		// END TEST 1

		// TEST 2
		System.out.println("\nTest part II:");
		System.out.println("-------------------------------------------------");

		polling = new Polling(candidates, 30, 15);
		polling.init();
		// all the ballots all bulletins pass the date check
		// the simulate parameters are in order::
		// the percentage of voters and the day of the vote
		polling.simulate(0.75, 12);
		polling.countVotes();
		polling.results();

		polling = new Polling(candidates, 30, 15);
		polling.init();
		// only paper ballots pass
		polling.simulate(0.75, 15);
		polling.countVotes();
		polling.results();

		polling = new Polling(candidates, 30, 15);
		polling.init();
		// electronic ballots do not pass
		polling.simulate(0.75, 15);
		polling.countVotes();
		polling.results();
		// END TEST 2

	}
}

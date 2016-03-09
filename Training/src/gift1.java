/*
ID: ikalvin1
LANG: JAVA
TASK: gift1
 */
import java.io.*;
import java.util.*;

public class gift1 {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File("gift1.in"));
//		Scanner s = new Scanner(new File("gift2.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"gift1.out")));

		int numFriends = s.nextInt();
		int[] profit = new int[numFriends];
		List<String> names = new ArrayList<String>(numFriends);

		// fill in name array
		for (int i = 0; i < numFriends; i++) {
			names.add(s.next());
		}

		while (s.hasNext()) {
			String personGiving = s.next();
			int amountGiven = s.nextInt();
			int amountOfPeopleSharingGift = s.nextInt();
			int amountGivenToEachPerson;
			
			//if either are 0, don't take any further actions
			if(amountOfPeopleSharingGift == 0) {
				
			}
			
			else {
				amountGivenToEachPerson = amountGiven / amountOfPeopleSharingGift;
				// take money away from person giving
				profit[names.indexOf(personGiving)] -= amountGiven;
				
				// give the money giver back the remainder
				if(amountGiven != amountGivenToEachPerson * amountOfPeopleSharingGift) {
					profit[names.indexOf(personGiving)] += (amountGiven - (amountGivenToEachPerson * amountOfPeopleSharingGift));
				}

				// give money to people receiving
				for (int i = 0; i < amountOfPeopleSharingGift; i++) {
					profit[names.indexOf(s.next())] += amountGivenToEachPerson;
				}
			}

		}
		
		for(int i = 0; i < numFriends; i++) {
			out.println(names.get(i) + " " + profit[i]);
//			System.out.println(names.get(i) + " " + profit[i]);
		}
		
		out.close();

	}
}

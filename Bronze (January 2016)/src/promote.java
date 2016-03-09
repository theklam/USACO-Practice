/*
ID: ikalvin1
LANG: JAVA
TASK: promote
 */
import java.io.*;
import java.util.*;

public class promote {
	public static void main(String[] args) throws IOException {
//		Scanner s = new Scanner(new File("promote.in"));
		Scanner s = new Scanner(new File("promote.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"gift1.out")));
		
		List<Integer> before = new ArrayList<Integer>();
		List<Integer> after = new ArrayList<Integer>();
		int[] promotions = new int[3];
		
		while(s.hasNext()) {
			before.add(s.nextInt());
			after.add(s.nextInt());
		}
		
		//go through the array starting from the last spot
		//don't process first element
		for(int i = after.size() - 1; i > 0; i--) {
			//at this index, after is bigger than before
			if(after.get(i) > before.get(i)) {
				
				//trace back from current index - 1
				for(int start = i - 1; after.get(i) != before.get(i) && start >= 0; start--) {
					
					//if elem > 0 
					if(before.get(start) > 0) {
						
						while(before.get(start) > 0 && after.get(i) != before.get(i)) {
							before.set(start, before.get(start) - 1);
							before.set(i, before.get(i) + 1);
							promotions[i-1]++;
						}
						
					}
					
					//elem <= 0
					else {
						
					}
					
				}
				
			}
			
			//at this index, before is bigger than after
			else if(before.get(i) > after.get(i)) {
				
			}
			
			//at this index, before = after
			else {
				
			}

		}
		
		for(int n: promotions) {
			System.out.println(n);
		}
		
//		out.close();

	}
}

/*
ID: ikalvin1
LANG: JAVA
TASK: beads
 */
import java.io.*;
import java.util.*;

public class beads1 {
	public static void main(String[] args) throws IOException {
//		Scanner s = new Scanner(new File("beads.in"));
		Scanner s = new Scanner(new File("beads1.txt"));	
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"beads.out")));
		
		int total = 0;
		int max = 0;
		
		int numBeads = s.nextInt();
		String originalStrand = s.next();
		
		System.out.println("original strand is " + originalStrand);
		
		String modifiedStrand = originalStrand.substring(originalStrand.length()/2) + originalStrand + originalStrand.substring(0, originalStrand.length()/2);
		
		System.out.println("modified strand is " + modifiedStrand);
		
//		originalStrand = originalStrand + originalStrand;
//		numBeads *= 2;
		
		int start = modifiedStrand.indexOf(originalStrand);
		
		//where is the original strand in the modified strand?
		System.out.println("start is " + start);
		
		System.out.println("start + numbeads is " + (start + numBeads));
		System.out.println("char at " + modifiedStrand.charAt(start+numBeads));
		
		for(int spot = 1; spot < numBeads; spot++) {
			System.out.println("Spot " + spot + " is in between beads of " + (spot - 1) + " and " + spot);
			boolean leftOrRightBeadIsWhite = originalStrand.charAt(spot-1) == 'w' || originalStrand.charAt(spot) == 'w';
			boolean leftAndRightBeadSameColor = originalStrand.charAt(spot-1) == originalStrand.charAt(spot);

			//check if left or right bead is  white
			if(leftOrRightBeadIsWhite) {
				
			}
			
			//check if left and right bead are same color
			else if(leftAndRightBeadSameColor) {
				
			}
			
			else {
				int count = 0;
				System.out.println("CHANGE POINT AT SPOT " + spot);
				System.out.println("between beads " + originalStrand.charAt(spot-1) + originalStrand.charAt(spot));
				
				//at change point we want to begin count and see if count can reach pass the current max
				
				//check left first
				int left = spot-1;
				char desiredLeft = originalStrand.charAt(left);
				while(left >= 0 && (originalStrand.charAt(left) == desiredLeft || originalStrand.charAt(left) == 'w')) {
					left--;
					count++;
				}
				
				//check right second
				int right = spot;
				char desiredRight = originalStrand.charAt(right);
				while(right < numBeads && (originalStrand.charAt(right) == desiredRight || originalStrand.charAt(right) == 'w')) {
					right++;
					count++;
				}
				
				if(count>max) {
					max = count;
				}
				
				System.out.println("count is " + count);
				
				
			}
			
			
		}		
		
		System.out.println("max is " + max);
		
//		out.println(max);
		
//		out.close();

	}
}

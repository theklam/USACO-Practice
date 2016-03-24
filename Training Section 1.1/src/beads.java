/*
ID: ikalvin1
LANG: JAVA
TASK: beads
 */
import java.io.*;
import java.util.*;

public class beads {
	public static void main(String[] args) throws IOException {
//		Scanner s = new Scanner(new File("beads.in"));
		Scanner s = new Scanner(new File("beads5.txt"));	
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"beads.out")));
		
		int total = 0;
		int max = 0;
		boolean hasChangePoint = false;
		
		int numBeads = s.nextInt();
		String originalStrand = s.next();
		
		System.out.println("original strand is " + originalStrand);
		
//		String modifiedStrand = originalStrand.substring(originalStrand.length()/2) + originalStrand + originalStrand.substring(0, originalStrand.length()/2);
		//check if last bead is equal to first bead for wrap around
		//checking if wraparound is even needed
		if(originalStrand.charAt(0) == originalStrand.charAt(originalStrand.length()-1)) {
			
			
			
		}
		
//		String modifiedStrand = originalStrand + originalStrand;
		
		
		System.out.println("modified strand is " + modifiedStrand);
		
//		originalStrand = originalStrand + originalStrand;
//		numBeads *= 2;
		
		int start = modifiedStrand.indexOf(originalStrand);
		
		//where is the original strand in the modified strand?
		System.out.println("start is " + start);
		
		System.out.println("start + numbeads is " + (start + numBeads));
		System.out.println("char at " + modifiedStrand.charAt(start+numBeads));
		

		
		for(int spot = 1; spot < numBeads*2; spot++) {
			System.out.println("Spot " + spot + " is in between beads of " + (spot - 1) + " and " + spot);
			boolean leftOrRightBeadIsWhite = modifiedStrand.charAt(spot-1) == 'w' || modifiedStrand.charAt(spot) == 'w';
			boolean leftAndRightBeadSameColor = modifiedStrand.charAt(spot-1) == modifiedStrand.charAt(spot);
			boolean leftBeadWhite = modifiedStrand.charAt(spot-1)=='w';
			boolean rightBeadWhite = modifiedStrand.charAt(spot)=='w';
			int count = 0;

			//check if left or right bead is  white
			if(leftOrRightBeadIsWhite) {
				
				if(leftBeadWhite && rightBeadWhite) {
					
					//check left first
					int left = spot-1;
					if(left-1 >= 0) { //make sure we are in bounds
						char desiredLeft = modifiedStrand.charAt(left - 1); //put the -1 to skip the white beat
						while(left >= 0 && (modifiedStrand.charAt(left) == desiredLeft || modifiedStrand.charAt(left) == 'w')) {
							left--;
							count++;
						}
					}
					else {	
						
					}
					
					//check right second
					int right = spot;
					if(right+1 < numBeads*2) {
						char desiredRight = modifiedStrand.charAt(right + 1); //put the +1 to skip the white bead
						while(right < numBeads*2 && (modifiedStrand.charAt(right) == desiredRight || modifiedStrand.charAt(right) == 'w')) {
							right++;
							count++;
						}
					}
					
				}
				
				else if(leftBeadWhite) {
					
					//check left first
					int left = spot-1;
					char desiredLeft = modifiedStrand.charAt(left - 1); //put the -1 to skip the white beat
					while(left >= 0 && (modifiedStrand.charAt(left) == desiredLeft || modifiedStrand.charAt(left) == 'w')) {
						left--;
						count++;
					}
					
					//check right second
					int right = spot;
					char desiredRight = modifiedStrand.charAt(right); 
					while(right < numBeads*2 && (modifiedStrand.charAt(right) == desiredRight || modifiedStrand.charAt(right) == 'w')) {
						right++;
						count++;
					}
					
				}
				
				else {
					
					//check left first
					int left = spot-1;
					char desiredLeft = modifiedStrand.charAt(left); 
					while(left >= 0 && (modifiedStrand.charAt(left) == desiredLeft || modifiedStrand.charAt(left) == 'w')) {
						left--;
						count++;
					}
					
					//check right second
					int right = spot;
					char desiredRight = modifiedStrand.charAt(right + 1); //put the +1 to skip the white bead
					while(right < numBeads*2 && (modifiedStrand.charAt(right) == desiredRight || modifiedStrand.charAt(right) == 'w')) {
						right++;
						count++;
					}
					
					
				}
				
			}
			
			//check if left and right bead are same color
			else if(leftAndRightBeadSameColor) {
				
			}
			
			else {
				hasChangePoint = true;
				System.out.println("CHANGE POINT AT SPOT " + spot);
				System.out.println("between beads " + modifiedStrand.charAt(spot-1) + modifiedStrand.charAt(spot));
				
				//at change point we want to begin count and see if count can reach pass the current max
				
				//check left first
				int left = spot-1;
				char desiredLeft = modifiedStrand.charAt(left);
				while(left >= 0 && (modifiedStrand.charAt(left) == desiredLeft || modifiedStrand.charAt(left) == 'w')) {
					left--;
					count++;
				}
				
				//check right second
				int right = spot;
				char desiredRight = modifiedStrand.charAt(right);
				while(right < numBeads*2 && (modifiedStrand.charAt(right) == desiredRight || modifiedStrand.charAt(right) == 'w')) {
					right++;
					count++;
				}
				
			}
			
			if(count>max) {
				max = count;
			}
			
			System.out.println("count is " + count);
			
		}
		
		//duplicates array, blue at index 0, red at index 1, white at index 2
		int[] duplicates = new int[3];
		//for cases where all beads are same color, check to see if there are duplicates
		char[] strand = originalStrand.toCharArray();
		for(char b: strand) {
			if(b == 'b') {
				duplicates[0]++;
			}
			if(b=='r'){
				duplicates[1]++;
			}
			if(b=='w'){
				duplicates[2]++;
			}
		}
		
		for(int i: duplicates) {
			if(i==numBeads) {
				max = numBeads;
			}
		}
		
		System.out.println("max is " + max);
		
		out.println(max);
		
		out.close();

	}
}

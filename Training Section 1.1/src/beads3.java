/*
ID: ikalvin1
LANG: JAVA
TASK: beads
 */
import java.io.*;
import java.util.*;

public class beads3 {
	public static void main(String[] args) throws IOException {
//		Scanner s = new Scanner(new File("beads.in"));
		Scanner s = new Scanner(new File("beads2.txt"));	
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"beads.out")));
		
		int numBeads = s.nextInt();
		System.out.println("Number of beads is " + numBeads);
		String oneStrandBeads = s.next();
		int count = 0;
		int max = -55555;
		String twoStrandsBeads = oneStrandBeads + oneStrandBeads;
		char[] beads = twoStrandsBeads.toCharArray();
		boolean hasChangePoint = false;
		
		//process all beads
		for(int i = 1; i < numBeads; i++) {
			
			int counter = 0;
			
			//if right or left bead is diff color, it's a changing point, cannot have white at the change point
			if( beads[i] != 'w' && (beads[i-1] != 'w' && beads[i-1] != beads[i] || beads[i+1] != 'w' && beads[i] != beads[i+1]) ) {
				
				hasChangePoint = true;
				System.out.println("Changing point is at bead " + i);
				
				//is left diff color
				if(beads[i-1] != beads[i]) {
					
					char desiredLeft;
					
					//determine which color left bead should be
					if(beads[i] == 'r') {
						desiredLeft = 'b';
					}
					else{
						desiredLeft = 'r';
					}
					
					//run while left bead is correct color AND in bounds
					for(int left = i - 1; left >= 0 && (beads[left] == desiredLeft || beads[left] == 'w'); left--) {
						counter++;
					}
					
					//run while right bead is correct color AND in bounds
					for(int right = i; right < beads.length && (beads[right] == beads[i] || beads[right] == 'w'); right++) {
						counter++;
					}
					
				}
				
				//is right diff color
				else {
					
					System.out.println("Right bead is diff color at bead " + i);
					
					char desiredRight;
					
					//determine which color right bead should be
					if(beads[i] == 'r') {
						desiredRight = 'b';
					}
					else{
						desiredRight = 'r';
					}
					
					System.out.println("The desired right char is " + desiredRight);
					
					//run while right bead is correct color AND in bounds
					for(int right = i + 1; right < beads.length && (beads[right] == desiredRight || beads[right] == 'w'); right++) {
						counter++;
						System.out.println("first for loop run");
						System.out.println("counter is " + counter);
					}
					
					//run while left bead is correct color AND in bounds
					for(int left = i; left >= 0 && (beads[left] == beads[i] || beads[left] == 'w'); left--) {
						counter++;
						System.out.println("second for loop run");
						System.out.println("counter is " + counter);
					}
					
				}
			}

			//if it is NOT change point "rrrr"
			else {
				System.out.println("Not at change point");
				//go right
				for(int right = i; right < numBeads && (beads[right] == 'w' || beads[right] == beads[i]); right++) {
					System.out.println("first for loop run at index " + right);
					counter++;
				}
				
				//go left
				for(int left = i - 1; left >= 0 && (beads[left] == 'w' || beads[left] == beads[i]); left--) {
					counter++;
				}
				
			}
			
			//check if current count is greater than max before incrementing to next bead
			if(counter > max) {
				max = counter;
			}
		}
		
		out.println(max);
		System.out.println(max);
		
		out.close();

	}
}

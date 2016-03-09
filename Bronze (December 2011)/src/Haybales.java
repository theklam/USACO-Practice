import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Haybales {
	
	public static void main(String[] args) {
		
		try {
			Scanner s = new Scanner(new File("haybales.txt"));
			int numPiles = s.nextInt(); 
			int balesMoved = 0;
			List<Integer> piles = new ArrayList<Integer>();
			
			while(s.hasNext()) {
				piles.add(s.nextInt());
			}
			
			int totalBales = 0;
			//summing totalBales
			for(int n: piles) {
				totalBales += n;
			}			
			
			int desiredBalesPerPile = totalBales / numPiles;
			
			
			//printing out un-sorted arraylist
			System.out.println("Un-sorted arraylist below");
			for(int n: piles) {
				System.out.println(n);
			}
			
			System.out.println("Total bales: " + totalBales);
			System.out.println("Desired bales per pile: " + desiredBalesPerPile);
			System.out.println();

			
			//sorting arrayList
			Collections.sort(piles);
			
			//printing out sorted arraylist
			System.out.println("Sorted arraylist below");
			for(int n: piles) {
				System.out.println(n);
			}
			System.out.println();
			
			//processing all haybale piles
			//do not process last pile, since we are assuming that the last pile will have the desired amount of bales
			for(int i = 0; i < piles.size() - 1; i++) {  
				
				//if current pile has desired amount of bales, do nothing -> move to next pile
				if(piles.get(i) == desiredBalesPerPile) {
					
				}
				
				//if this current pile has less than the desired amount of bales
				else { 
					int balesNeeded = desiredBalesPerPile - piles.get(i);
					System.out.println("Bales needed for pile " + (i+1) + ": " + balesNeeded);
					balesMoved += balesNeeded; //increase count of bales moved
					
					//keep going until this pile gets the desired amount of bales per pile OR until we reach the end of piles
					//start processing on the next pile
					for(int pile = i + 1; pile < piles.size() && piles.get(i) != desiredBalesPerPile; pile++) {
						if(piles.get(pile) > desiredBalesPerPile) { //if the next pile has more bales than desired
							
							//check how many extra bales it has
							
							if(piles.get(pile) - desiredBalesPerPile > balesNeeded) {
								
								//reducing current pile by the amount of bales taken away
								piles.set(pile, piles.get(pile) - balesNeeded); 
								
								//set current pile to desired
								piles.set(i, desiredBalesPerPile);
								
							}
							
							else if(piles.get(pile) - desiredBalesPerPile == balesNeeded) {
								
								//exact amount of bales needed
								piles.set(pile, desiredBalesPerPile);
								
								//set current pile to desired
								piles.set(i, desiredBalesPerPile);
								
								
							}
							
							else { //piles.get(pile) - desiredBalesPerPile < balesNeeded
								
								piles.set(i, piles.get(i) + (piles.get(pile) - desiredBalesPerPile));
								piles.set(pile, desiredBalesPerPile);
								
							}
						}
					}
				}
			}
			
			for(int n: piles) {
				System.out.println(n);
			}
			
			System.out.println("Bales moved: " + balesMoved);
			
		}
		
		catch(FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
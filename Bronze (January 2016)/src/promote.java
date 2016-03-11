/*
ID: ikalvin1
LANG: JAVA
TASK: promote
 */
import java.io.*;
import java.util.*;

public class promote {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File("promote.in"));
//		Scanner s = new Scanner(new File("promote.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"promote.out")));
		
		List<Integer> before = new ArrayList<Integer>();
		List<Integer> after = new ArrayList<Integer>();
		List<Integer> promotions = new ArrayList<Integer>();
		promotions.add(0);
		promotions.add(0);
		promotions.add(0);

		
		
		while(s.hasNext()) {
			before.add(s.nextInt());
			after.add(s.nextInt());
		}
		
//		//printing before array
//		for(int n: before) {
//			System.out.println(n);
//		}
//		
//		System.out.println();
//		
//		//printing after array
//		for(int n: after) {
//			System.out.println(n);
//		}
//		
//		System.out.println();
		
		int sumBefore = 0;
		int sumAfter = 0;
		
		//calculate sums
		for(int n: before) {
			sumBefore += n;
		}
		for(int n: after) {
			sumAfter += n;
		}
		
//		System.out.println("Sum before is " + sumBefore);
//		System.out.println("Sum after is " + sumAfter);
//		System.out.println();
		
		if(sumAfter>sumBefore) {
			before.set(0, before.get(0) + (sumAfter - sumBefore));
		}
		
//		//printing before array after adding to the first index
//		for(int n: before) {
//			System.out.println(n);
//		}
		
		for(int i = 0; i < before.size() - 1; i++) {
			
			if(before.get(i) > after.get(i)) {
				int diff = before.get(i) - after.get(i);
				before.set(i, before.get(i) - diff);
				before.set(i+1, before.get(i+1) + diff);
				promotions.set(i, promotions.get(i) + diff);
				System.out.println("This is the " + i + "th run");
			}
		}
		
		
		
		for(int n: promotions) {
			out.println(n);
//			System.out.println(n);
		}
		
		out.close();

	}
}

/*
ID: ikalvin1
LANG: JAVA
TASK: friday
 */
import java.io.*;
import java.util.*;

public class friday {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File("friday.in"));
//		Scanner s = new Scanner(new File("friday.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"friday.out")));

		int n = s.nextInt();
		int yearToStopAt = 1900 + (n-1);
		int[] output = new int[7];
		int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int jan131900 = 0; //starts on saturday
		
		for(int year = 1900; year <= yearToStopAt; year++) {
			boolean leapYear = false;

			//check for leap year
			
			//century year
			if(year % 100 == 0) { 
				if(year % 400 == 0) {
					leapYear = true;
				}
			}
			
			//not century year
			else {
				if(year % 4 == 0) {
					leapYear = true;
				}
			}
			
			if(leapYear) {
				daysInMonth[1] = 29;
			}
			
			else {
				daysInMonth[1] = 28;
			}
			
			//if it is 1900
			if(year == 1900) {
				//increment saturday for the first 13th of the yaer 1900
				output[0]++;
				
				//process each month, start at february
				for(int i = 1; i < daysInMonth.length; i++) {
					
					int daysToAdvance = daysInMonth[i-1] % 7;
					
					jan131900 += daysToAdvance;

					if(jan131900 > 6) {
						jan131900 = jan131900 % 7;
					}
					
					output[jan131900]++;
					
				}
			}
			
			//past 1900
			else {
				//process each month, start at january
				for(int i = 0; i < daysInMonth.length; i++) {
					
					int daysToAdvance;
					
					if(i==0) {
						daysToAdvance = 31 % 7; //december
					}
					else {
						daysToAdvance = daysInMonth[i-1] % 7;
					}
					
					jan131900 += daysToAdvance;
					
					if(jan131900 > 6) {
						jan131900 = jan131900 % 7;
					}
					
					output[jan131900]++;
					
				}
			}
			
			
		}
		
		int counter = 0;
		for(int j: output) {
//			System.out.println(j);
			if(counter == output.length - 1) {
				out.print(j +"\n");

			}
			else {
				out.print(j + " ");
			}
			counter++;
		}
		out.close();
		
		
	}
}

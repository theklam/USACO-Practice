/*
ID: ikalvin1
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

public class ride {
  public static void main (String [] args) throws IOException {
    Scanner s = new Scanner(new File("ride.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
    int i = 0;
    String s1 = s.next();
    String s2 = s.next();
    
    int i1 = 1;
    int i2 = 1;
    
    //find numeric value for string 1
    for(i = 0; i < s1.length(); i++) {
    	i1 *= (s1.charAt(i) - 64);
    }
    
    //find numeric value for string 2
    for(i = 0; i < s2.length(); i++) {
    	i2 *= (s2.charAt(i) - 64);
    }
    
    if(i1 % 47 == i2 % 47) {
    	out.print("GO\n");
    }
    else {
    	out.print("STAY\n");
    }
    out.close();
    
	  

	  
	  

  }
}

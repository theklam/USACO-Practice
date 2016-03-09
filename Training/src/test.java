/*
ID: ikalvin1
LANG: JAVA
TASK: test
*/
import java.io.*;
import java.util.*;

public class test {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("test.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(f.readLine());
						  // Get line, break into tokens
    int i1 = Integer.parseInt(st.nextToken());    // first integer
    int i2 = Integer.parseInt(st.nextToken());    // second integer
    out.println(i1+i2);                           // output result
    out.close();                                  // close the output file
	  
//	  Scanner s = new Scanner(new File("test.in"));
//	  
//	  int i1 = s.nextInt();
//	  int i2 = s.nextInt();
//	  
//	  FileWriter file = new FileWriter("test.out");
//	  int sum = i1 + i2;
//	  String temp = "" + sum;
//	  file.write(temp, 0, temp.length());
//	  file.close();
	  
	  

  }
}

package com.hackerrank;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) { // s = aba n= 7
       	char[] charArray = s.toCharArray(); 
       	int length = charArray.length; //3
       	long multiply =   (n/length); //2
       	int rem =     (int) (n%length);// 1
       	
       	long count=0;
       	for (int i = 0; i < charArray.length; i++) {
			if(charArray[i]=='a') {
				count++;
			}
		}
       	
       	long tcount =  count * multiply;
       	
       	System.out.println("---------REM--------");

       	count=0;
    	for (int i = 0; i < rem ; i++) {
			if(charArray[i]=='a') {
				count++;
			}
		}

    	tcount+=count;
    	
    	System.out.println("Toal A :: " + tcount);
    	return tcount;
    }

}

public class RepeatedString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Interview/data.txt"));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

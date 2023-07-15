package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result1 {

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */

    public static int jumpingOnClouds(List<Integer> c) {
    	System.out.println("Cloud"+c);
    	int next_jump = 0;
    	int i = 0;

    	while (i < c.size()-1) {
			if(i+2 == c.size() || c.get(i+2) == 1) {
				i++;
				next_jump ++;
			}else {
				i+=2;
				next_jump++;
			}
		}
    	
    	System.out.println(next_jump);
    	return next_jump;
    }

}

public class JumpingOnClouds {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
        String[] cTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
        List<Integer> c = new ArrayList<>();
//
        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cTemp[i]);
            c.add(cItem);
        }

        int result = Result1.jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

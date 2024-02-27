package com.java.codility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenPalindrom {
	public static void main(String[] args) {
		//5,2 abbba , 3,2 aba, 8,3 ppsccspp dmeaaemd
		//generatePalindrome(5);
		//solution(5, 2); //
		//palindrome(5, 2);
		sol(8, 3);
	}
	public static void sol(int N, int K) {
		char[] alph = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		Random rand = new Random();
		StringBuilder str = new StringBuilder(N);	
		for (int i = 0; i < K; i++) {
			int nextInt = rand.nextInt(26);
			str.append(alph[nextInt]);
		}
		
		int rep = N-(K*2);
		
		StringBuilder ans = new StringBuilder();
		String m = str.substring(0,1);
		String bw= m.repeat(rep);
		ans.append(str).append(bw).append(str.reverse());
		
		System.out.println(ans);
		isPalindrom(ans.toString());
	}
	
	public static void isPalindrom(String str) {
		StringBuilder sb = new StringBuilder(str);
		StringBuilder reverse = sb.reverse();
		if(str.equals(reverse.toString())) {
			System.out.println("OK");
		}else {
			System.out.println("NOK");
		}
	}
	
	public static void generatePalindrome(int size) {
		Random rand = new Random();
		StringBuilder random = new StringBuilder(size);
		int n = (int) Math.ceil((double) size / 2);
		for (int i = 0; i < n; i++) {
			char ch = (char) (rand.nextInt(26) + 97);
			random.append(ch);
		}
		
		for (int i = size / 2 - 1; i >= 0; i--)
			random.append(random.charAt(i));

		System.out.println(random.toString());
	}
	public static void palindrome(int length, int distinctLetters)
	{
	    String[] s = new String[length];

	    String[] availableLetters =  { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	    List<String> lettersToUse = new ArrayList<String>();

	    for (int i = 0; i < distinctLetters; i++)
	        lettersToUse.add(availableLetters[i]);

	    int loopCount = (int)Math.ceil(length / 4) + 1;

	    for(int i = 0; i <= loopCount; i += distinctLetters)
	    {
	        for(int j = 0; j < distinctLetters; j++)
	        {
	            int startIndex = i + j;
	            int endIndex = length - j - i - 1;

	            if (startIndex > endIndex) // if start goes past end, then String is complete
	                break;

	            else
	            {
	                s[startIndex] = lettersToUse.get(j);

	                if (startIndex < endIndex) // Only add letter at the end if not past start
	                    s[endIndex] = lettersToUse.get(j);
	            }
	        }
	    }

	    String ans=  String.join("", s);
	    System.out.println(ans);
	}
	public static void solution(int N, int K) {
		String alph = "abcdefghijklmnopqrstuvwxyz";
        String alphRev = "zyxwvutsrqponmlkjihgfedcba";
        
        String s;
        String sRev;
        int between = 0;
        String bw = "";

        if(K > (N / 2)) {
            s = alph.substring(0, K);
            sRev =  alphRev.substring(26 - K + 1, 26);
        } else {
            s = alph.substring(0, K);
            sRev =  alphRev.substring(26 - K, 26);

            between = N - (K * 2);
            bw = "a".repeat(between);
        }
        String ans = s + bw + sRev;
        System.out.println(ans); 

		System.out.println(ans);
	}

}

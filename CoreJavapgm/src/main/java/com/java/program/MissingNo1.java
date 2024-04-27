package com.java.program;

import java.util.Arrays;

public class MissingNo1 {
public static void main(String[] args) {
	int array[]= {1,2,4};
	int res=1;
    int n= array.length;
    
	Arrays.sort(array);
    
	for(int i=0;i<array.length;i++){
         if(array[i] != i+1){
             res = i+1;
             break;
         }
     }
     
     if(res == 0){
         res = n;
     }
     
     System.out.println(res);
}
}
  
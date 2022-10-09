// 1. You are given a string(str) and a number K.
// 2. You have to find the count of valid substrings of the given string.
// 3. Valid substring is defined as a substring that has exactly K unique characters

import java.util.*;

public class Main {

	public static int solution(String str, int k){
	   int ans=0;
		int i=-1;
		int j=-1;
		HashMap<Character,Integer>hm=new HashMap<>();
		while(true){
		    
		    boolean f1=false;
		    boolean f2=false;
		    
		    while(i<str.length()-1){
		        f1=true;
		        i++;
		        char ch=str.charAt(i);
		       hm.put(ch,hm.getOrDefault(ch,0)+1);
		       if(hm.size()<=k){
		         ans+=hm.get(ch);
		       }
		  else {
		      break;
		  } 
		    }
		    
		    
		    while(j<i){
		        f2=true;
		        j++;
		        char ch=str.charAt(j);
		        int fq=hm.get(ch);
		        if(fq==1){
		            hm.remove(ch);
		        }
		        else{
		            hm.put(ch,fq-1);
		        }
		        if(hm.size()<k){
		            continue;
		        }
		        else break;
		    }
		    if(f1==false && f2== false)break;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

}

package hackerrank;

import java.util.Scanner;

public class NextLexographicalOrder {
    //this algorithm given a string, finds the lexographically bigger string
	
	public static String getNextBiggerString(String input) {
		//find longest decreasing suffix
		int length = input.length();
		int startIndex=length-1;
		for(int i=length-1;i>=0;i--) {
			if(i==0)
				break;
			if(input.charAt(i-1)<input.charAt(i))
				break;
			startIndex=i-1;
		}
		
		String longestSuffix = input.substring(startIndex);
		
		if(longestSuffix.equalsIgnoreCase(input))
			return "no answer";
		
		char replaceChar = input.charAt(startIndex-1);
		
		int replacementIndex = startIndex;
		for(int i=startIndex;i<length;i++)
		{
			if(replaceChar<input.charAt(i))
				replacementIndex=i;
				
		}
		
		char[] tempCharArray = input.toCharArray();
		tempCharArray[startIndex-1] = input.charAt(replacementIndex);
		tempCharArray[replacementIndex] = replaceChar;
		input = new String(tempCharArray);
		
		//lets now sort the longest suffix in ascending order
		longestSuffix = input.substring(startIndex);
		int j=longestSuffix.length()-1;
		for(int i=startIndex;i<length;i++) {
			tempCharArray[i]=longestSuffix.charAt(j--);
		}
		return new String(tempCharArray);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int iterations = scan.nextInt();
		for(int i=0;i<iterations;i++) {
			String curInput = scan.next();
			System.out.println(getNextBiggerString(curInput));
		}
	}

}

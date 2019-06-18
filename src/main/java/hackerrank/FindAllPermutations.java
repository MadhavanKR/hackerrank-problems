package hackerrank;

public class FindAllPermutations {

	static String swap(String input,int i,int j)
	{
		char[] inputArray=input.toCharArray();
		char temp = inputArray[i];
		inputArray[i] = inputArray[j];
		inputArray[j] = temp;
		return new String(inputArray);
	}
	
	static void permute(String input,int start, int end) {
		if(start==end) {
			System.out.println(input);
		}else {
			for(int i=start;i<end;i++) {
				input = swap(input,start,i);
				permute(input,start+1,end);
				input = swap(input,start,i);
			}
		}
	}
	public static void main(String[] args) {
		FindAllPermutations.permute("abcd", 0, "abc".length());
	}

}

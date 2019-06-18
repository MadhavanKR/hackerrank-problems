package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BiggerIsGreater {

	static ArrayList<String> allPermutations;

	static String swap(String input, int i, int j) {
		char[] inputArray = input.toCharArray();
		char temp = inputArray[i];
		inputArray[i] = inputArray[j];
		inputArray[j] = temp;
		return new String(inputArray);
	}

	static void permute(String input, int start, int end) {
		if (start == end) {
			allPermutations.add(input);
		} else {
			for (int i = start; i < end; i++) {
				input = swap(input, i, start);
				permute(input, start + 1, end);
				input = swap(input, i, start);
			}
		}
	}

	// Complete the biggerIsGreater function below.
	static String biggerIsGreater(String w) {
		allPermutations = new ArrayList<String>();
		permute(w, 0, w.length());
		int diff = Integer.MIN_VALUE;
		String minDiffString = "no answer";
		for (String currentPermutation : allPermutations) {
			// i am looking for a smallest negative number
			int curDiff = w.compareTo(currentPermutation);
			System.out.println("current string being compared with " + w + " is " + currentPermutation
					+ " and comparision score is " + curDiff);
			if (curDiff < 0 && curDiff >= diff) {
				diff = curDiff;
				if (diff == curDiff) {
					if (currentPermutation.compareTo(minDiffString) < 0)
						minDiffString = currentPermutation;
				} else {
					minDiffString = currentPermutation;
				}
				System.out.println("mindiffString=" + minDiffString);
			}
		}
		return minDiffString;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.out"));
		int T = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int TItr = 0; TItr < T; TItr++) {
			String w = scanner.nextLine();

			String result = biggerIsGreater(w);
			System.out.println("--------------------------");
			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}

}

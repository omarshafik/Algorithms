
import java.util.Scanner;

public class MaxPairwise {

	private static void getMaxPairwiseProduct() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] data = new int[n];
		long max = 0;
		long secMax = 0;
		for (int i = 0; i < n; i++) {
			data[i] = scan.nextInt();
			if (data[i] > max) {
				secMax = max;
				max = data[i];
			}
			else if(data[i] > secMax) {
				secMax = data[i];
			}
		}
		scan.close();
		long result = max * secMax;
		System.out.println(result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getMaxPairwiseProduct();
	}

}

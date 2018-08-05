
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ClosestPair {

	public static void sortbyColumn(double arr[][], int col) {
		// Using built-in sort function Arrays.sort
		Arrays.sort(arr, new Comparator<double[]>() {

			@Override
			// Compare values according to columns
			public int compare(final double[] entry1, final double[] entry2) {

				// To sort in descending order revert
				// the '>' Operator
				if (entry1[col] > entry2[col])
					return 1;
				else
					return -1;
			}
		}); // End of function call sort().
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastScanner fs = new FastScanner(System.in);
		int n = fs.nextInt();
		double[][] dist = new double[n][2];
		int min = -1000000000, max = 1000000000;
		int[][] pt = new int[n][2];
		for (int i = 0; i < n; i++) {
			pt[i][0] = fs.nextInt();
			pt[i][1] = fs.nextInt();
			dist[i][0] = (Math.pow(pt[i][0] - min, 2) + Math.pow(pt[i][1] - min, 2))
					+ (Math.pow(pt[i][0] - max, 2) + Math.pow(pt[i][1] - max, 2));
			dist[i][1] = i;
		}
		sortbyColumn(dist, 0);
		double minDist = dist[0][0] - dist[1][0];
		int minIndex = 0;
		for (int i = 0; i < n - 1; i++) {
			if (dist[i][0] - dist[i + 1][0] < minDist) {
				minDist = dist[i][0] - dist[i+1][0];
				minIndex = i;
			}
		}
		double result = Math.sqrt(Math.pow(pt[(int)dist[minIndex][1]][0] - pt[(int)dist[minIndex+1][1]][0], 2)
				+ Math.pow(pt[(int)dist[minIndex][1]][1] - pt[(int)dist[minIndex+1][1]][1], 2));
		System.out.println(result);
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}

}

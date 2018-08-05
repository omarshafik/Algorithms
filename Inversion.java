
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Inversion {

	public static int sortAndSplitCount(int[] arr, int low, int high) {
		int n = high - low;
		if (n < 2) {
			if (arr[low] <= arr[high]) {
				Arrays.sort(arr, low, high + 1);
				return 0;
			} else {
				Arrays.sort(arr, low, high + 1);
				return 1;
			}
		} else {
			int i = low;
			int j = n / 2 + n % 2;
			int count = 0;
			while (i < n / 2 + n % 2 && j <= high) {
				if (arr[i] < arr[j]) {
					i++;
				} else if (arr[i] > arr[j]) {
					count += j - i;
					j++;
				} else {
					count += j - i - 1;
					j++;
				}
			}
			Arrays.sort(arr, low, high + 1);
			return count;
		}

	}

	public static int getInversionsNo(int[] arr, int low, int high) {
		int x = 0, y = 0, z = 0;
		if (high - low < 2) {
			z += sortAndSplitCount(arr, low, high);
		} else {
			x += getInversionsNo(arr, low, (high - low) / 2 + low + (high - low) % 2);
			y += getInversionsNo(arr, (high - low) / 2 + low + (high - low) % 2, high);
			z += sortAndSplitCount(arr, low, high);
		}
		return x + y + z;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastScanner fs = new FastScanner(System.in);
		int n = fs.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = fs.nextInt();
		}
		System.out.println(getInversionsNo(a, 0, a.length - 1));

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

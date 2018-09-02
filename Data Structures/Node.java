
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Node {

	public static int getTreeHeight(int[] tree) {
		int[] height = new int[tree.length];
		int k;
		int h = 0;

		for (int i = 0; i < tree.length; i++) {

			if (height[i] == 0) {
				k = i;
				h = 0;
				while (k != -1 && height[k] == 0) {
					h++;
					k = tree[k];
				}
				if (k != -1) {
					height[i] = h + height[k];
				}
				k = i;
				while (k != -1 && height[k] == 0) {
					height[k] = h--;
					k = tree[k];
				}
			}
		}
		int max = 0;
		for (int i = 0; i < tree.length; i++) {
			if (height[i] > max) {
				max = height[i];
			}
		}

		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastScanner fs = new FastScanner(System.in);
		int n = fs.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = fs.nextInt();
		}
		System.out.println(getTreeHeight(input));

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


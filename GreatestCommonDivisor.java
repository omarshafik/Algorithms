import java.util.Scanner;

public class GreatestCommonDivisor {

	private static int getGCD(int a, int b) {
		int result = 0;
		int A = 0;
		while (0 == result) {
			A = a % b;
			a = b;
			b = A;
			if (0 == b) {
				result = a;
			}
		}
		return result;
	}

	private static long getLCM(int a, int b) {
		return (((long) a * b )/ getGCD(a, b));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		a = sc.nextInt();
		b = sc.nextInt();
		sc.close();
		//System.out.println(getGCD(a, b));
		System.out.println(getLCM(a, b));
	}

}

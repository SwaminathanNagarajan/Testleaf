package week1.day2;

public class CheckNumberIsPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i < 20; i++) {
			boolean isPrime = true;
			for (int j = 1; j <= i / 2; j++) {
				if (i % j == 0) {
					isPrime = false;
				}

			}
			if (isPrime) {
				System.out.println(i + " is a Prime Number");
			} else {
				System.out.println(i + " is not a Prime Number");
			}

		}

	}

}

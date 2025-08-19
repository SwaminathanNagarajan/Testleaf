package week1.day2;

public class FibonacciSeries {

	public static void main(String[] args) {
		//Declaring first and second int variable
		int firstNumber = 0, secondNumber =1;
		//declaring for loop with condition as 8
		System.out.print("The fibonacci series upto 8 values:");
		for (int i = 0; i < 8; i++) {
			System.out.print(firstNumber + " ");
			int thirdNumber = firstNumber + secondNumber;
			firstNumber = secondNumber;
			secondNumber = thirdNumber;
			
			
		}

	}

}

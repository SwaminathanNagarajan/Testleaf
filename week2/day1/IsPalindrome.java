package week2.day1;

public class IsPalindrome {

	public static void main(String[] args) {
		int input=121, output=0, rem=0;
		for(int i=0;i>0;i++) {
			i=i/10;
		}
		
		if(input==output) {
			System.out.println("The given number is a palindrome");
		}else {
			System.out.println("The given number is not a palindrome");
		}
		

	}

}

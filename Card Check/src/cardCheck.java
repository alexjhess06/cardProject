import java.util.Arrays;
import java.util.Scanner;
public class cardCheck
	{
		static Scanner userInput = new Scanner(System.in); 
		static Long[] cardNum = new Long[16];
		public static void main(String[] args)
			{
				 
				 System.out.println("Enter a credit/debit card number, AMEX not accepted");
				 //long card = userInput.nextLong();
				
				
				 getNum();
			}

		private static void getNum()
			{
			long card = userInput.nextLong();
			for(int i = 0; i < 16; i++) {
				cardNum[i] = card;
				
			}
			System.out.println(Arrays.toString(cardNum));
			}

	}

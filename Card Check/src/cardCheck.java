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
				 doMath();
			}

		private static void getNum()
			{
			long card = userInput.nextLong();
			String cardStr = Long.toString(card);
			
			for(int i = 0; i < 16; i++) {
				char digitChar = cardStr.charAt(i);
	            cardNum[i] = (long) Character.getNumericValue(digitChar);
			}
			System.out.println(Arrays.toString(cardNum));
			}
		private static void doMath()
		{
			for(int i = 0; i < 16; i+=2) {
				cardNum[i] *= 2;
			
			System.out.println(Arrays.toString(cardNum));
			for(Long digit : cardNum) {
				String digitStr = String.valueOf(digit);
				int length = digitStr.length();
				if(length == 1) {
					long a = cardNum[i] / 10;
					long b = cardNum[i] % 10;
					cardNum[i] = a+b;
				}
			}
			}
			System.out.println(Arrays.toString(cardNum));
		}

	}

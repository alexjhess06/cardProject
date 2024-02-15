import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;
public class cardCheck
	{
		static Scanner userInput = new Scanner(System.in); 
		static Long[] cardNum = new Long[16];
		static int[] randCardNum = new int[16];
		static String[] randNums = new String[100];
		static long total = 0;
		static int giveGet = 0;
		static int valid = 0;
		static boolean checkValidity = false;
		public static void main(String[] args)
			{
				 System.out.println("Would you like to (1)generate random card numbers or (2)check a card number?");
				 giveGet = userInput.nextInt();
				 if(giveGet == 2) {
				 System.out.println("Enter a credit/debit card number, AMEX not accepted");
				 getNum();
				 doMath();
				 isValid();
				 }
				if(giveGet==1) {
					checkValidity = true;
					while(checkValidity == true) {
					genNums();
					doMath();
					isValid();
					}
				}
				
				
				 
			}

		private static void genNums()
			{
				
			for(int i = 0; i < 16; i++) {
				int rand = (int)(Math.random() * 10);
				randCardNum[i] = rand;
				randCardNum.toString();
			}
				//System.out.println(Arrays.toString(randCardNum));
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
			//----------------------------------------GIVEN CARDS---------------------------------------------//
			if(giveGet == 2) {
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
			for(int i = 0; i < 16; i++) {
				total = total + cardNum[i];
			}
			System.out.println(total);
			}
			//------------------------------------------RAND CARDS--------------------------------------------------------//
			if(giveGet == 1) {
				for(int i = 0; i < 16; i+=2) {
					randCardNum[i] *= 2;
				
				//System.out.println(Arrays.toString(randCardNum));
				for(int digit : randCardNum) {
					String digitStr = String.valueOf(digit);
					int length = digitStr.length();
					if(length == 1) {
						int a = randCardNum[i] / 10;
						int b = randCardNum[i] % 10;
						randCardNum[i] = a+b;
					}
				}
				}
				//System.out.println(Arrays.toString(randCardNum));
				for(int i = 0; i < 16; i++) {
					total = total + randCardNum[i];
				}
				System.out.println(total);
				total = 0;
			}
		}
		private static void isValid()
		{
			if(total % 10 == 0) {
				System.out.println("This is possibly a valid credit card number!");
					valid++;
					for(int i : randCardNum) {
						 String str = randCardNum.toString();
						 randNums[i] = str;
						}
				if(valid == 100) {
					checkValidity = false;
					System.out.println("Here is your 100 random potentially valid credit card numbers! \n" + randNums);
				}
			}
			else {
				System.out.println("This credit card number is invalid!");
			}
		}

	}

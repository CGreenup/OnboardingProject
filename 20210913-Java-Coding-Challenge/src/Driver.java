import java.util.ArrayList;
import java.util.List;

public class Driver {
	public static void main(String[] args) {
		String testString = "png";
		String encodedString = Converter.encryptRot13(testString);
		System.out.println(Converter.encryptRot13(encodedString));
		System.out.println(encodedString);
		
		System.out.println(Converter.dumbDecimalToOctal(234567));
		System.out.println(Converter.myDecimalToOctal(-234567));
	}
}


class Converter{
	public static String encryptRot13(String input) {
		char[] inputArray = input.toCharArray();
		char[] outputArray = new char[inputArray.length];
		
		for(int i = 0; i < inputArray.length; i++) {
			char encodedCharacter = inputArray[i];
			
			if(Character.isLetter(encodedCharacter)) {
				int startIndex;
				int characterOffset;
				if(Character.isUpperCase(encodedCharacter)) {
					startIndex = 'A';
				}else {
					startIndex = 'a';
				}
				characterOffset = (encodedCharacter - startIndex + 13) % 26;
				encodedCharacter = (char) (startIndex + characterOffset);
			}
			outputArray[i] = encodedCharacter;
		}
		
		return new String(outputArray);
	}
	
	public static String dumbDecimalToOctal(int input) {
		return (Integer.toOctalString(input));
	}
	
	//This method is assuming an integer input.
	public static String myDecimalToOctal(int input) {
		List<Integer> middleList = new ArrayList<Integer>();
		
		int result = Math.abs(input);
		
		while(result > 0) {
			middleList.add(result % 8);
			result /= 8;
		}
		
		//Converting the list of integers into an array of chars
		int length = middleList.size();
		char[] outputArray = new char[length];
		for(int i = 0; i < length; i++) {
			char numberToChar = (char) (middleList.get(length - i - 1) + '0');
			outputArray[i] = numberToChar;
		}
		
		return ( (input < 0 ? "-" : "") + new String(outputArray));
	}
}
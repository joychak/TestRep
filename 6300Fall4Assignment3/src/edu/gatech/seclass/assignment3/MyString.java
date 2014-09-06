package edu.gatech.seclass.assignment3;


/**
 * MyString class that implements the MyStringInterface
 */
public class MyString implements MyStringInterface{

	//the current string variable
	private String stringvalue;
	
	/**
	 * This Setter sets the value of the current string.
	 * @param  str  input string
	 */
	public void setString(String str) {
		stringvalue = str;
	}

	/**
	 * This Getter returns the current string.
	 * @return      the current value of the string
	 */
	public String getString() {
		return stringvalue;
	}

	/**
	 * Returns a string that consists of all and only the vowels in the current string.
	 * The returned contains each occurrence of a vowel in the current string
	 * 
	 * If the current string value is null then return NullPointerException (Current value of string is Null).
	 * If the current string is empty then do nothing.
	 * 
	 * @return      The string with vowels only
	 */
	public String getVowels() {
		
		String returnString = "";
		
		//if the string value is null then return NullPointerException
		if (stringvalue == null)
		{
			throw new NullPointerException("Current value of string is Null");
		}
		else if (stringvalue.length() > 0) //If the string is empty then do nothing
		{
			char[] currentCharArray = stringvalue.toCharArray();
			for (int i=0;i<stringvalue.length();i++)
			{
				String currentChar = String.valueOf(currentCharArray[i]);
				if (currentChar == "a" || currentChar == "e" || currentChar == "i" || currentChar == "o" ||
						currentChar == "u" || currentChar == "A" || currentChar == "E" || currentChar == "I"
						|| currentChar == "O" || currentChar == "U")
				{
					returnString = returnString + currentChar;
				}
			}
		}
		return returnString;
	}

	/**
	 * Returns a string that consists of the substring between start and end indexes (both included) 
	 * in the current string.
	 * Index 1 corresponds to the first character in the current string.
	 *
	 * @param  start  	start index
	 * @param  end 		end index
	 * @return      	the sub string value
	 */
	public String getSubstring(int start, int end) {
		
		return null;
	}

	/**
	 * Returns the index of the first occurrence of a character in the current string.
	 * Here, index 1 corresponds to the first character in the current string.
	 * 
	 * If the current string value is null then return NullPointerException (Current value of string is Null).
	 * If the current string is empty then do nothing.
	 * If the input character is null then return NullPointerException ("Input character is Null")
	 * If the char doesn't present then return -1
	 * 
	 * @param  c	the input character
	 * @return		the index of the first occurrence of the input character
	 */
	public int indexOf(char c) {
		int returnIndex = -1; //if the char doesn't present then return -1
		
		//if the string value is null then return NullPointerException
		if (stringvalue == null)
		{
			throw new NullPointerException("Current value of string is Null");
		}
		else if (c == '\u0000') //if the input character is null then return NullPointerException
		{
			throw new NullPointerException("Input character is Null");
		}
		else if (stringvalue.length() > 0) //If the string is empty then do nothing
		{
			char[] currentCharArray = stringvalue.toCharArray();
			for (int i=0;i<stringvalue.length();i++)
			{
				if (currentCharArray[i] == c)
				{
					returnIndex = i+1;
					break;
				}
			}
		}
		return returnIndex;
	}

	/**
	 * Removes all occurrences of the specified character from the current string.
	 * If the input character doesn't present then return the same string.
	 * If the current string value is null then return NullPointerException (Current value of string is Null).
	 * If the current string is empty then do nothing.
	 * If the input character is null then return NullPointerException ("Input character is Null")
	 * If the input char doesn't present in the current string then do nothing
	 * 
	 * @param  c 	The input character
	 */
	public void removeChar(char c) {
		//if the string value is null then return NullPointerException
		if (stringvalue == null)
		{
			throw new NullPointerException("Current value of string is Null");
		}
		else if (c == '\u0000') //if the input character is null then return NullPointerException
		{
			throw new NullPointerException("Input character is Null");
		}
		else if (stringvalue.length() > 0) //If the string is empty then do nothing (i.e.nothing to remove)
		{
			int charOccureranceCount = stringvalue.split(String.valueOf(c)).length;
			if  (charOccureranceCount > 0) //Do nothing if the input char doesn't present in the current string
			{
				for (int i=1; i<= charOccureranceCount; i++)
				{
					stringvalue = stringvalue.replace(String.valueOf(c), "");
				}
			}
		}
	}

	/**
	 * Invert the current string.
	 * If the current string value is null then return NullPointerException (Current value of string is Null).
	 * If the current string is empty then do nothing.
	 */
	public void invert() {
		//if the string value is null then return NullPointerException
		if (stringvalue == null)
		{
			throw new NullPointerException("Current value of string is Null");
		}
		else if (stringvalue.length() > 0) //If the string is empty then do nothing
		{
			char[] currentCharArray = stringvalue.toCharArray();
			char[] newCharArray = new char[currentCharArray.length];
			for (int i=1;i<=stringvalue.length();i++)
			{
				newCharArray[i-1] = currentCharArray[currentCharArray.length-i];
			}
		}
	}
}

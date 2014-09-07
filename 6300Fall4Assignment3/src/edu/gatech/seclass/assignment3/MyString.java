package edu.gatech.seclass.assignment3;


/**
 * MyString class that implements the MyStringInterface
 */
public class MyString implements MyStringInterface{

	//The exception messages
	public static final String NULL_STRING_EXCEPTION = "Current value of string is Null";
	public static final String INPUT_CHAR_NULL = "Input character is Nulll";
	public static final String INDEX_LESS_THAN_1 = "Input index is less than 1";
	public static final String INDEX_GREATER_THAN_LENGTH = "Input index is greater than string length";
	public static final String START_INDEX_GREATER_THAN_END = "Start index is greater than end index";
	
	//the current string variable
	private String currentStringValue;
	
	//Empty constructor
	public MyString() {}
	
	//Overloaded constructor to populate the current string value
	public MyString(String str){
		currentStringValue = str.trim(); //remove the empty chars at the beginning and end of string
	}
	
	/**
	 * This Setter sets the value of the current string.
	 * @param  str  input string
	 */
	public void setString(String str) {
		currentStringValue = str.trim(); //remove the empty chars at the beginning and end of string
	}

	/**
	 * This Getter returns the current string.
	 * @return      the current value of the string
	 */
	public String getString() {
		return currentStringValue;
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
		if (currentStringValue == null)
		{
			throw new NullPointerException(NULL_STRING_EXCEPTION);
		}
		else if (currentStringValue.length() > 0) //If the string is empty then do nothing
		{
			char[] currentCharArray = currentStringValue.toCharArray();
			for (int i=0;i<currentStringValue.length();i++)
			{
				String currentChar = String.valueOf(currentCharArray[i]);
				if (currentChar.equals("a") || currentChar.equals("A") 
						|| currentChar.equals("e") || currentChar.equals("E") 
						|| currentChar.equals("i") || currentChar.equals("I")
						|| currentChar.equals("o") || currentChar.equals("O") 
						|| currentChar.equals("u") || currentChar.equals("U") )
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
	 * If the current string value is null then return NullPointerException (Current value of string is Null).
	 * if start or end < 1 then return IndexOutOfBoundsException (Input index is less than 1)
	 * if start or end > string length then return IndexOutOfBoundsException (Input index is greater than string length)
	 * if start > end then return IndexOutOfBoundsException (Start index is greater than end index)
	 *
	 * @param  start  	start index
	 * @param  end 		end index
	 * @return      	the sub string value
	 */
	public String getSubstring(int start, int end) {
		
		//if the string value is null then return NullPointerException
		if (currentStringValue == null)
		{
			throw new NullPointerException(NULL_STRING_EXCEPTION);
		}
		else if(start < 1 || end < 1)
		{
			throw new IndexOutOfBoundsException(INDEX_LESS_THAN_1);
		}
		else if (start > currentStringValue.length() || end > currentStringValue.length())
		{
			throw new IndexOutOfBoundsException(INDEX_GREATER_THAN_LENGTH);
		}
		else if(start > end)
		{
			throw new IndexOutOfBoundsException(START_INDEX_GREATER_THAN_END);
		}
		else
		{
			return currentStringValue.substring(start-1, end);
		}
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
		if (currentStringValue == null)
		{
			throw new NullPointerException(NULL_STRING_EXCEPTION);
		}
		else if (c == '\u0000') //if the input character is null then return NullPointerException
		{
			throw new NullPointerException(INPUT_CHAR_NULL);
		}
		else if (currentStringValue.length() > 0) //If the string is empty then do nothing
		{
			char[] currentCharArray = currentStringValue.toCharArray();
			for (int i=0;i<currentStringValue.length();i++)
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
		if (currentStringValue == null)
		{
			throw new NullPointerException(NULL_STRING_EXCEPTION);
		}
		else if (c == '\u0000') //if the input character is null then return NullPointerException
		{
			throw new NullPointerException(INPUT_CHAR_NULL);
		}
		else if (currentStringValue.length() > 0) //If the string is empty then do nothing (i.e.nothing to remove)
		{
			int charOccureranceCount = currentStringValue.split(String.valueOf(c)).length;
			if  (charOccureranceCount > 0) //Do nothing if the input char doesn't present in the current string
			{
				for (int i=1; i<= charOccureranceCount; i++)
				{
					currentStringValue = currentStringValue.replace(String.valueOf(c), "");
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
		if (currentStringValue == null)
		{
			throw new NullPointerException(NULL_STRING_EXCEPTION);
		}
		else if (currentStringValue.length() > 0) //If the string is empty then do nothing
		{
			char[] currentCharArray = currentStringValue.toCharArray();
			String newCurrentString = "";
			for (int i=1;i<=currentStringValue.length();i++)
			{
				newCurrentString += String.valueOf(currentCharArray[currentCharArray.length-i]);
			}
			currentStringValue = newCurrentString;
		}
	}
}

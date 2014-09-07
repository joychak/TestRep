package edu.gatech.seclass.assignment3;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class MyStringTest {
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	//==============================================================================
	// TEST GetVowels function
	//==============================================================================

	//Test-case: Current string value is null 
	//Expected result: NullPointerException (Current value of string is Null).
	@Test 
	public void testGetVowels_for_null_currentString() {
		expectedEx.expect(NullPointerException.class);
	    expectedEx.expectMessage(MyString.NULL_STRING_EXCEPTION);
	    
		MyString testClass = new MyString();
		testClass.getVowels();
	}
	
	//Test: The current string is empty 
	//Expected result: Empty string
	@Test 
	public void testGetVowels_for_empty_currentString() {
		
		MyString testClass = new MyString();
		testClass.setString("");
		assertEquals(testClass.getVowels(), "");
	}

	//Test: The current string has words without vowel and empty space between words
	//Expected result: An empty string
	@Test 
	public void testGetVowels_for_word_with_emptySpace_but_noVowel() {
		
		MyString testClass = new MyString();
		testClass.setString("bbb ccc");
		assertEquals(testClass.getVowels(), "");
	}

	//Test: The current string has 2 words with vowels but having empty space between words
	//Expected result: string with only vowels that includes removal of empty space too
	@Test 
	public void testGetVowels_for_word_with_emptySpace_and_vowels() {
		
		MyString testClass = new MyString();
		testClass.setString("Hello World");
		assertEquals(testClass.getVowels(), "eoo");
	}

	//Test: The current string has vowels with repetition (i.e. same vowel multiple times)
	//Expected result: String with all the vowels only
	@Test 
	public void testGetVowels_for_words_with_vowel_repetition() {
		
		MyString testClass = new MyString();
		testClass.setString("Heelloo Woorld");
		assertEquals(testClass.getVowels(), "eeoooo");
	}
	
	//Test: The current string has all the vowels with upper case and lower case
	//Expected result: String with all the vowels only
	@Test 
	public void testGetVowels_for_string_with_all_vowels_upper_and_lower() {
		
		MyString testClass = new MyString();
		testClass.setString("1Aa2Ee3Ii4Oo5Uu6");
		assertEquals(testClass.getVowels(), "AaEeIiOoUu");
	}


	//Test: The current string has only vowels (all vowels with upper and lower case)
	//Expected result: The same string
	@Test 
	public void testGetVowels_for_string_with_vowels_only() {
		
		MyString testClass = new MyString();
		testClass.setString("AaEeIiOoUu");
		assertEquals(testClass.getVowels(), "AaEeIiOoUu");
	}
	
	
	//==============================================================================
	//   TEST GetSubstring function
	//==============================================================================

	//Test-case: Current string value is null 
	//Expected result: NullPointerException (Current value of string is Null).
	@Test
	public void testGetSubstring_for_null_currentString() {
		expectedEx.expect(NullPointerException.class);
	    expectedEx.expectMessage(MyString.NULL_STRING_EXCEPTION);
	    
		MyString testClass = new MyString();
		testClass.getSubstring(1, 2);
	}

	//Test-case: start index less than 1
	//Expected result: IndexOutOfBoundsException (Input index is less than 1)
	@Test
	public void testGetSubstring_startIndex_less_than_1() {
		expectedEx.expect(IndexOutOfBoundsException.class);
	    expectedEx.expectMessage(MyString.INDEX_LESS_THAN_1);
	    
		MyString testClass = new MyString();
		testClass.setString("Test Data");
		testClass.getSubstring(0, 2);
	}

	//Test-case: end index less than 1
	//Expected result: IndexOutOfBoundsException (Input index is less than 1)
	@Test
	public void testGetSubstring_endIndex_less_than_1() {
		expectedEx.expect(IndexOutOfBoundsException.class);
	    expectedEx.expectMessage(MyString.INDEX_LESS_THAN_1);
	    
		MyString testClass = new MyString();
		testClass.setString("Test Data");
		testClass.getSubstring(1, 0);
	}

	//Test-case: start index greater than length
	//Expected result: IndexOutOfBoundsException (Input index is greater than string length)
	@Test
	public void testGetSubstring_startIndex_greater_than_length() {
		expectedEx.expect(IndexOutOfBoundsException.class);
	    expectedEx.expectMessage(MyString.INDEX_GREATER_THAN_LENGTH);
	    
		String data = "Test Data";
	    MyString testClass = new MyString();
		testClass.setString(data);
		testClass.getSubstring(data.length()+1, data.length());
	}

	//Test-case: end index greater than length
	//Expected result: IndexOutOfBoundsException (Input index is greater than string length)
	@Test
	public void testGetSubstring_endIndex_greater_than_length() {
		expectedEx.expect(IndexOutOfBoundsException.class);
	    expectedEx.expectMessage(MyString.INDEX_GREATER_THAN_LENGTH);
	    
	    String data = "Test Data";
	    MyString testClass = new MyString();
	    testClass.setString(data);
		testClass.getSubstring(1, data.length()+1);
	}

	//Test-case: start index greater than end index
	//Expected result: IndexOutOfBoundsException (Start index is greater than end index)
	@Test
	public void testGetSubstring_startIndex_greater_than_endIndex() {
		expectedEx.expect(IndexOutOfBoundsException.class);
	    expectedEx.expectMessage(MyString.START_INDEX_GREATER_THAN_END);
	    
	    String data = "Test Data";
		MyString testClass = new MyString();
		testClass.setString(data);
		testClass.getSubstring(2, 1);
	}

	//Test-case: empty current string
	//Expected result: IndexOutOfBoundsException (Input index is greater than string length)
	@Test
	public void testGetSubstring_empty_currentString() {
		expectedEx.expect(IndexOutOfBoundsException.class);
	    expectedEx.expectMessage(MyString.INDEX_GREATER_THAN_LENGTH);
	    
	    String data = "";
		MyString testClass = new MyString();
		testClass.setString(data);
		testClass.getSubstring(1, 1);
	}

	//Test-case: valid start (greater than 1) and end index (less than string length)
	//Expected result: between start and end indexes (both included)
	@Test
	public void testGetSubstring_valid_start_and_end_index() {
	    
		String data = "Test Data";
		MyString testClass = new MyString();
		testClass.setString(data);
		assertEquals(testClass.getSubstring(2,7), "est Da");
	}

	//Test-case: start and end equal to 1
	//Expected result: 1st char of the string
	@Test
	public void testGetSubstring_startAndEnd_equal_to_1() {
	    
		String data = "Test Data";
		MyString testClass = new MyString();
		testClass.setString(data);
		assertEquals(testClass.getSubstring(1,1), "T");
	}
	
	//Test-case: start and end equal to the length of the string
	//Expected result: last char of the string
	@Test
	public void testGetSubstring_startAndEnd_equal_to_stringLength() {
	    
		String data = "Test Data";
		MyString testClass = new MyString();
		testClass.setString(data);
		assertEquals(testClass.getSubstring(data.length(),data.length()), "a");
	}

	//Test-case: start = 1 and end = length of the string
	//Expected result: The same string
	@Test
	public void testGetSubstring_startEquals1_and_endEqualsLength() {
	    
		String data = "Test Data";
		MyString testClass = new MyString();
		testClass.setString(data);
		assertEquals(testClass.getSubstring(1,data.length()), data);
	}

	
	//==============================================================================
	//   TEST GetSubstring function
	//==============================================================================
	
	//Test-case: Current string value is null 
	//Expected result: NullPointerException (Current value of string is Null).
	@Test
	public void testIndexOf_for_null_currentString() {
		expectedEx.expect(NullPointerException.class);
	    expectedEx.expectMessage(MyString.NULL_STRING_EXCEPTION);
	    
		MyString testClass = new MyString();
		testClass.indexOf('c');
	}
	
	//Test-case: null input character 
	//Expected result: NullPointerException (Input character is Null).
	@Test
	public void testIndexOf_for_null_inputChar() {
		expectedEx.expect(NullPointerException.class);
	    expectedEx.expectMessage(MyString.INPUT_CHAR_NULL);
	    
	    String data = "Test Data";
		MyString testClass = new MyString();
		testClass.setString(data);
		testClass.indexOf('\u0000');
	}
	
	//Test-case: empty input string
	//Expected result: -1
	@Test
	public void testIndexOf_for_empty_currentString() {
		
	    String data = "";
		MyString testClass = new MyString();
		testClass.setString(data);
		assertEquals(testClass.indexOf('c'), -1);
	}

	//Test-case: input char doesn't present in the input string
	//Expected result: -1
	@Test
	public void testIndexOf_for_inputChar_not_present() {
		
	    String data = "Test Data";
		MyString testClass = new MyString();
		testClass.setString(data);
		assertEquals(testClass.indexOf('x'), -1);
	}

	//Test-case: input char at index 1
	//Expected result: 1
	@Test
	public void testIndexOf_for_inputChar_at_Index1() {
		
	    String data = "Test Data";
		MyString testClass = new MyString();
		testClass.setString(data);
		assertEquals(testClass.indexOf('T'), 1);
	}

	//Test-case: input char at index equal length
	//Expected result: current string length
	@Test
	public void testIndexOf_for_inputChar_at_IndexEqualLength() {
		
	    String data = "Test";
		MyString testClass = new MyString();
		testClass.setString(data);
		assertEquals(testClass.indexOf('t'), data.length());
	}
	
	//Test-case: input char appears more than one
	//Expected result: index of the first occurrence
	@Test
	public void testIndexOf_for_inputChar_appears_multipleTimes() {
		
	    String data = "Hello";
		MyString testClass = new MyString();
		testClass.setString(data);
		assertEquals(testClass.indexOf('l'), 3);
	}
	

	//==============================================================================
	//   TEST RemoveChar function
	//==============================================================================
	
	//Test-case: Current string value is null 
	//Expected result: NullPointerException (Current value of string is Null).
	@Test
	public void testRemoveChar_for_null_currentString() {
		expectedEx.expect(NullPointerException.class);
	    expectedEx.expectMessage(MyString.NULL_STRING_EXCEPTION);
	    
		MyString testClass = new MyString();
		testClass.removeChar('c');
	}
	
	//Test-case: null input character 
	//Expected result: NullPointerException (Input character is Null).
	@Test
	public void testRemoveChar_for_null_inputChar() {
		expectedEx.expect(NullPointerException.class);
	    expectedEx.expectMessage(MyString.INPUT_CHAR_NULL);
	    
	    String data = "Test Data";
		MyString testClass = new MyString();
		testClass.setString(data);
		testClass.removeChar('\u0000');
	}
	
	//Test-case: empty current string
	//Expected result: empty current string
	@Test
	public void testRemoveChar_for_empty_currentString() {
		
	    String data = "";
		MyString testClass = new MyString();
		testClass.setString(data);
		testClass.removeChar('c');
		assertEquals(testClass.getString(), "");
	}

	//Test-case: input char not present in the current string
	//Expected result: no change in the current string
	@Test
	public void testRemoveChar_for_char_notPresent() {
		
	    String data = "Test Data";
		MyString testClass = new MyString();
		testClass.setString(data);
		testClass.removeChar('c');
		assertEquals(testClass.getString(), data);
	}
	
	//Test-case: input char present in the current string (single occurrence)
	//Expected result: remove the single occurrence of the char in the current string
	@Test
	public void testRemoveChar_for_char_present_oneTime() {
		
	    String data = "Test Data";
		MyString testClass = new MyString();
		testClass.setString(data);
		testClass.removeChar('e');
		assertEquals(testClass.getString(), "Tst Data");
	}
	
	//Test-case: input char present in the current string (multiple occurrence)
	//Expected result: remove the all occurrences of the char in the current string
	@Test
	public void testRemoveChar_for_char_present_multipleTimes() {
		
	    String data = "Test Data";
		MyString testClass = new MyString();
		testClass.setString(data);
		testClass.removeChar('t');
		assertEquals(testClass.getString(), "Tes Daa");
	}

	//Test-case: input char present in the current string at front
	//Expected result: remove the first char of the current string
	@Test
	public void testRemoveChar_for_char_at_front() {
		
	    String data = "Test Data";
		MyString testClass = new MyString();
		testClass.setString(data);
		testClass.removeChar('T');
		assertEquals(testClass.getString(), "est Data");
	}

	//Test-case: input char present in the current string at end
	//Expected result: remove the last char of the current string
	@Test
	public void testRemoveChar_for_char_at_end() {
		
	    String data = "Test Val";
		MyString testClass = new MyString();
		testClass.setString(data);
		testClass.removeChar('l');
		assertEquals(testClass.getString(), "Test Va");
	}


	//==============================================================================
	//   TEST Invert function
	//==============================================================================
	
	//Test-case: Current string value is null 
	//Expected result: NullPointerException (Current value of string is Null).
	@Test
	public void testInvert_for_null_currentString() {
		expectedEx.expect(NullPointerException.class);
	    expectedEx.expectMessage(MyString.NULL_STRING_EXCEPTION);
	    
		MyString testClass = new MyString();
		testClass.invert();
	}
		
	//Test-case: empty current string
	//Expected result: empty current string
	@Test
	public void testInvert_for_empty_currentString() {
		
	    String data = "";
		MyString testClass = new MyString();
		testClass.setString(data);
		testClass.invert();
		assertEquals(testClass.getString(), "");
	}

	//Test-case: current string with single char
	//Expected result: current string remains same
	@Test
	public void testInvert_for_string_with_single_char () {
		
	    String data = "A";
		MyString testClass = new MyString();
		testClass.setString(data);
		testClass.invert();
		assertEquals(testClass.getString(), data);
	}

	//Test-case: current string with multiple char
	//Expected result: current string value gets inverted
	@Test
	public void testInvert_for_string_with_multiple_char () {
		
	    String data = "Test Data";
		MyString testClass = new MyString();
		testClass.setString(data);
		testClass.invert();
		assertEquals(testClass.getString(), "ataD tseT");
	}
	
	
	
}
package proj4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The Converter class converts mathematical expressions from prefix notation to postfix notation.
 * 
 * @author Aidan Goroway
 * @version 1.12
 */
public class Converter {
	
	private Scanner myReader;
	private final String[] tokenList = {"+","-","*","/","^","(",")",";"};
	private final int NUMBER_OF_TOKEN_TYPES = 8;

	/**
	 * Non-default constructor; Gradescope needs this to run tests
	 * @param infile path to the input file 
	 */
    public Converter(String infile)
    {
		try {
            myReader = new Scanner(new File(infile));
    	} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
	}

	/**
	 * The main conversion method. Converts from prefix notation to postfix notation, using any numbers or variables.
	 */
	public void convert() {

		while (myReader.hasNext()) {

			String nextExpression = myReader.next();
			String prefix = nextExpression.substring(0,nextExpression.length() - 1) + " --> ";
			String postFix = "";
			String stringedChar = "";
			Stack<Token> postFixStack = new Stack<Token>();

			for (char c : nextExpression.toCharArray()) {

				stringedChar = String.valueOf(c);
				boolean tokenMatch = false;
				Token t = null;
				int tokenListIndex = 0;

				while (!tokenMatch){ // runs while there are still tokens to check
					if (tokenList[tokenListIndex].equals(stringedChar)){ // if there is a match
						switch (stringedChar) {
							case "+" -> t = new Plus();
							case "-" -> t = new Minus();
							case "*" -> t = new Multiply();
							case "/" -> t = new Divide();
							case "^" -> t = new Exponent();
							case "(" -> t = new LeftParen();
							case ")" -> t = new RightParen();
							case ";" -> t = new Semicolon();
						}
						tokenMatch = true;
					}
					tokenListIndex += 1;
					if (tokenListIndex == NUMBER_OF_TOKEN_TYPES){
						break;
					}
				}

				if (tokenMatch){ // if char is a token
					postFix += t.handle(postFixStack);
				}
				else { // if char is a variable
					postFix += stringedChar;
				}
			}
			System.out.println(prefix + postFix);
		}       
	}
}

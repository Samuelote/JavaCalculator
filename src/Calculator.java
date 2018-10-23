
/*
 * *****************************************************
 * Author: Samuel Wood
 * Title: Simple Calculator!
 * Description: This program is a basic integer calculator class. 
 * ******************************************************
 */
public class Calculator {

	public int calculate(int number1, int number2, String operator) {

		
		if (operator.codePointAt(0) == "+".codePointAt(0)) {
			return number1+number2;
		} else if (operator.codePointAt(0) == "-".codePointAt(0)) {
			return number1-number2;
		} else if (operator.codePointAt(0) == "*".codePointAt(0)) {
			return number1*number2;
		} else if (operator.codePointAt(0) == "/".codePointAt(0)) {
			return number1/number2;
		}
		
		return 698282;
		
	}
}
	
	

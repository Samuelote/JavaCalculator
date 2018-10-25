import java.util.ArrayList;
/*
 * *****************************************************
 * Author: Samuel Wood
 * Title: Eval Class
 * Description: This is an evalution class modeled after 
 * 				Javascript's eval function. It takes a string
 * 				and evaluates the equation, following the order
 * 				of operations.
 * ******************************************************
 */
public class Eval {

	private static String problem;
	private static double finalAnswer = 0;
	public Eval(String problem)
	{
		this.problem = problem;
	}
	
    public Double start()
    {  
        for (int i = 0; i < this.problem.length(); i++){
            String item = Character.toString(this.problem.charAt(i));
            if (item.equals("/") || item.equals("*")) {
                this.problem = this.problem.replace(
                		getPhrase(i, item),
                		multiplyOrDivide(getPhrase(i, item))
                		);
            }
        }
        findAnswer(this.problem);
        
        return finalAnswer;
    }
    
    //Finds each phrase in order of operations
    private static String getPhrase(int idx, String operator){
    	String phrase = operator;
        for (int i = idx-1; i > -1; i--){
            String item = Character.toString(problem.charAt(i));
            if (!isNumeric(item) && !item.equals(".")) break;
            phrase = item + phrase;
        }
        
        for (int i = idx+1; i < problem.length(); i++){
            String item = Character.toString(problem.charAt(i));
            if (!isNumeric(item) && !item.equals(".")) break;
            phrase += item;
        }
        return phrase;

    }
    
    //Calculates each phrase
    private static String multiplyOrDivide(String phrase) {
	    String number1 = "";
	    String number2 = "";
	    String operator = "";
	    Boolean next = false;
	    for (int i = 0; i < phrase.length(); i++){
	        String item = Character.toString(phrase.charAt(i));
	        if (!isNumeric(item)) {
	            next = true;
	            operator = item;
	        }
            if (next == false){
                number1 += item;
            } else if (isNumeric(item)) {
                number2 += item;
            }
	    }
        
        double num1 = Double.parseDouble(number1);
        double num2 = Double.parseDouble(number2);
        if (operator.codePointAt(0) == "*".codePointAt(0)) {
			return Double.toString(num1*num2);
		} else if (operator.codePointAt(0) == "/".codePointAt(0)) {
			return Double.toString(num1/num2);
		} else {
			return "ERROR";
		}
		
	}
    
    //Calculates final answer 
    private static void findAnswer(String str) {
    	String num = "";
    	String op = "";
    	System.out.println(str+"\n");
    	for (int i = 0; i < str.length(); i++) {
            String item = Character.toString(str.charAt(i));
			if ((isNumeric(item) || item.equals("."))) {
				num += item;
				if (i == str.length()-1) {
					addOrSubtract(Double.parseDouble(num), op);
				}
			} else if (op.equals("")){
				addOrSubtract(Double.parseDouble(num), "+");
				num = "";
				op = item;
			} else {
				addOrSubtract(Double.parseDouble(num), op);
				num = "";
				op = item;
			}
    		
    	}
    }
    
    //General calculation for final addition and subtraction
    private static void addOrSubtract(double number, String operator ) {
		if (operator.codePointAt(0) == "+".codePointAt(0)) {
			finalAnswer += number;
		} else {
			finalAnswer -= number;
		}
	}
    //Determines if it's a number
    private static boolean isNumeric(String str)
    {
      return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }


}

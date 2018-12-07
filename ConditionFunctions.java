package utils;

public class ConditionFunctions {
	
	public static boolean integerValidation(int i,int j, String operator){
		boolean result = false;
		if(operator.equals(">")){
			if(i>j){
				result = true;
			}
		}
		else if(operator.equals("<")){
			if(i<j){
				result = true;
			}
		}
		else if(operator.equals("=")){
			if(i==j){
				result = true;
			}
		}
		
		
		return result;
	}
	
	public static boolean stringValidation(String a,String b,String operator){
		boolean result = false;
		String c = removeQuotes(b);
		
		if(a.equals(c)){
			result = true;
		}
		
		return result;
	}
	
	public static String removeQuotes(String s){
		
		return s.substring(1, s.length()-1);
		
	}

}

package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import step2.Restriction;

public class StringFunctions {
	
	public static String[] wordSplit(String strQuery){
		String[] strArray = strQuery.split(" ");
		return strArray;
		
	}
	
	public static String getFileName(String strQuery){
		String fileName = "";
		String[] strArray = wordSplit(strQuery);
			for(String s:strArray){
				if(s.endsWith(".csv")){
					fileName = s;
					break;
				}
			}
			
			if(fileName.isEmpty()){
				fileName = "No file exists with .csv extension";
			}
			
			return fileName;
	}
	
	public static String getBasePart(String strQuery){
			String[] strArray = strQuery.split("where");
			
			return strArray[0].trim();
						
			
	}
	
	public static String getFilterPart(String strQuery){
		try{
			String[] words = splitWithWhere(strQuery);
			return words[1];
		}catch(Exception e){
			return " ";
		}
		
	}	
		
		public static String[] splitWithWhere(String strInputString){
			String[] words = strInputString.split("(?i)where");
			return words;
		}
	
		
		
				
		
	
	
	public static String[] getConditions(String strQuery){
		String strFilter = getFilterPart(strQuery);
		String[] strArray = strFilter.split(" and | or | not");
		return strArray;
		
		
	}
	
	public static List<String> getLogicalOperators(String strQuery){
		
		List<String> ar1 = new ArrayList<String>();
		String filterString = getFilterPart(strQuery);
		String[] filterWords = filterString.split(" ");
				
		for(String s:filterWords){
			if(s.equalsIgnoreCase("and") || s.equalsIgnoreCase("or") || s.equalsIgnoreCase("not"))
			ar1.add(s);
		}

		return ar1;
		
	}
	
	public static List<String> getSelectedFields(String strQuery){
		List<String> arr1 = new ArrayList<String>();
		String a = getStringRegex1(strQuery, "select", "from");
//		String[] words = wordSplit(strQuery);
//		String selectedFieldString = words[1];
//		String[] selectedFields = selectedFieldString.split(",");
//		for(String s:selectedFields){
//			arr1.add(s);
//		}
		
		String[] strArray = a.split(",");
		for(String s:strArray){
			arr1.add(s.trim());
		}
		
		return arr1;
			
	}
	
	public static List<String> getOrderByFields(String strQuery){
		List<String> arr1 = new ArrayList<String>();
		if(strQuery.contains("order by")){
			String[] words = strQuery.split("(?i)order by");
			String newString = words[1];
			
			String[] orderByFields = newString.split(",");
			for(String s:orderByFields){
				arr1.add(s.trim());
			}
		}
		
		
		return arr1;
					
	}
	
	public static List<String> getGroupByFields(String strQuery){
		List<String> arr1 = new ArrayList<String>();
		
		String[] words = strQuery.split("(?i)group by");
		try{
			String newString = words[1];
			String[] groupByFields = newString.split(",");
			for(String s:groupByFields){
				arr1.add(s.trim());
			}
			
			return arr1;
		}catch(Exception e){
			return arr1;
		}
		
		
			
	}
	
	public static List<String> getAggregateFunctions(String strInputString){
		List<String> arr1 = getSelectedFields(strInputString);
		List<String> arr2 = new ArrayList<String>();
		for(String s:arr1){
			if(s.toLowerCase().startsWith("min") || s.toLowerCase().startsWith("max")|| s.toLowerCase().startsWith("avg") || s.toLowerCase().startsWith("count") || s.toLowerCase().startsWith("count")){
				arr2.add(s);
			}
		}
		
		return arr2;
		
	}
	
	public static String getRestrictionStringOnly(String strQuery) {
		String s = getFilterPart(strQuery);
		try {
			String[] s1 = s.split("order by");
			return s1[0].trim();
		}catch(Exception e) {
			return e.getMessage();
		}
	}
	
	
	public static List<String> getRestrictionsList(String strQuery){
		List<String> ar1 = new ArrayList<String>();
		
		String s1 = getRestrictionStringOnly(strQuery);
		String[] s2 = s1.split(" and | or | not");
		for(String s3:s2) {
			
			ar1.add(s3.trim());
		}
		return ar1;
	}

	public static Restriction splitRestrictionString(String s) {
		Restriction objRest = new Restriction();
		String[] s1 = null;
		if(s.contains(">")) {
			 s1 = s.split(">");
			 objRest.setPropertyName(s1[0].trim());
			 objRest.setCondition(">");
			 objRest.setPropertyValue(ConditionFunctions.removeQuotes(s1[1].trim()));
			
		}
		if(s.contains("<")) {
			 s1 = s.split("<");
			 objRest.setPropertyName(s1[0].trim());
			 objRest.setCondition("<");
			 objRest.setPropertyValue(ConditionFunctions.removeQuotes(s1[1].trim()));
			
		}
		if(s.contains("=")) {
			s1 = s.split("=");
			objRest.setPropertyName(s1[0].trim());
			 objRest.setCondition("=");
			 objRest.setPropertyValue(ConditionFunctions.removeQuotes(s1[1].trim()));
				
		}
		return objRest;


	}

		public static String getAField(String[] s,String strString){
		for(String t:s){
			if(t.equals(strString)){
				return t;
				}
			
			}
			return "";
		
		}
		
		
		public static boolean comp(String s1,String s2,String c){
			boolean res = false;
			int x = s1.compareTo(s2);
			
			if((x==0 && c.equals("="))||(x>=1 && c.equals(">")) || (x<=-1 && c.equals("<"))){
				res=true;
			}
			
			return res;
			
		}
		
		public static List<Integer> whereParser(List<List<Integer>> lp,List<String> s){
			
			List<Integer> res = new ArrayList<>();
			res.addAll(lp.get(0));
			for(int i=0;i<s.size();i++){
				
				List<Integer> temp2 = lp.get(i+1);
				
				List<Integer> temp3 = new ArrayList<>();
				if(s.get(i).equals("and")){
					temp3.addAll(andList(res, temp2));
				}else if(s.get(i).equals("or")){
					temp3.addAll(orList(res, temp2));
				}
				
				res.removeAll(res);
				res.addAll(temp3);
				temp3.removeAll(temp3);
				
				
			}
			
		return res;
		
			
		}
		
		
		public static List<Integer> comp(List<Integer> l1,List<Integer> l2,String c){
			List<Integer> res = new ArrayList<>();
			if(c.equals("and")){
				res = andList(l1, l2);
			}else if(c.equals("or")){
				res = orList(l1, l2);
			}
			
			return res;
			

		}
		
		public static List<Integer> andList(List<Integer> l1,List<Integer> l2){
			List<Integer> res = new ArrayList<>(l1);
			res.retainAll(l2);
			
			return res;
			
		}
		
		public static List<Integer> orList(List<Integer> l1,List<Integer> l2){
			List<Integer> l3 = new ArrayList<>(l1);
			l3.addAll(l2);
			List<Integer> res = new ArrayList<>(new HashSet<>(l3));
			
			return res;
			
		}
		
		
		public static String getStringRegex1(String baseString,String starting,String ending){
			String pattern1 = starting;
			String pattern2 = ending;
			String text = baseString;
			String a = "";

			Pattern p = Pattern.compile(Pattern.quote(pattern1) + "(.*?)" + Pattern.quote(pattern2));
			Matcher m = p.matcher(text);
			while (m.find()) {
			  a = m.group(1);
			}
			
			return a;
		}
		
		
		public static String getAggregareFields(String baseString){
			String s1 = getStringRegex1(baseString, "select", "from");
			
			return s1;
			
		}
		
		



}

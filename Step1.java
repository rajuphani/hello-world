package step1;

import java.util.ArrayList;
import java.util.List;

import utils.StringFunctions;

public class Step1 {
	
	private static String inputString1 = "select * from ipl.csv where season > 2014 and city = 'Bangalore'";
	private static String inputString2 = "select * from ipl.csv where season > 2014 and city = 'Bangalore'";
	private static String inputString3 = "select * from ipl.csv where season > 2014 and city = 'Bangalore'";
	private static String inputString4 = "select * from ipl.csv where season > 2014 and city = 'Bangalore'";
	private static String inputString5 = "select season,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' or date > '31-12-2014'";
	private static String inputString6 = "select city,winner,player_match from ipl.csv where season > 2014 and city = 'Bangalore'";
	private static String inputString7 = "select * from ipl.csv where season > 2016 and city= 'Bangalore' order by win_by_runs";
	private static String inputString8 = "select team1, sum(win_by_runs) from ipl.csv where season > 2016 and city= 'Bangalore' group by team1";
	private static String inputString9 = "select avg(win_by_wickets),min(win_by_runs) from ipl.csv"; 

	public static void main(String[] args) {
		
		
		
		System.out.println("****************************************************************");
		//a. Write a program to read the query string as input and split them into words. Print the output on console as given below:
		System.out.println("a. Write a program to read the query string as input and split them into words. Print the output on console as given below:");
		String[] str = StringFunctions.wordSplit(inputString1);
		for(String s1:str){
			System.out.println(s1);
		}
		System.out.println("****************************************************************");
		
		
		
		//b. Further enhance your program to now extract certain parts of the same query:
		//        i. Get only file name from the query string.
		System.out.println("i. Get only file name from the query string.");
		String str1 = StringFunctions.getFileName(inputString1);
		System.out.println(str1);
		System.out.println("****************************************************************");
		
		
		//ii. Get only base part(before `where` word) of the query from the given query string. 
		System.out.println("ii. Get only base part(before `where` word) of the query from the given query string. ");
		String str2 = StringFunctions.getBasePart(inputString2);
		System.out.println(str2);
		System.out.println("****************************************************************");
		
		
		// iii. Get only filter part(after `where` word) of the query from the given query string. 
		System.out.println(" iii. Get only filter part(after `where` word) of the query from the given query string. ");
		String str3 = StringFunctions.getFilterPart(inputString3);
		System.out.println(str3);	
		System.out.println("******************************************************");
		
		
		// iv. As there will be multiple conditions, seperate each condition and display in different line.
		System.out.println(" iv. As there will be multiple conditions, seperate each condition and display in different line.");
		String[] str4 = StringFunctions.getConditions(inputString4);
		for(String s1:str4){
			System.out.println(s1.trim());
		}
		System.out.println("******************************************************");
		
		
		//v.  Extract the logical operators in sequence from the given query string. 
		System.out.println("v.  Extract the logical operators in sequence from the given query string. ");
		List<String> str5 = StringFunctions.getLogicalOperators(inputString5);
		for(String s1:str5){
			System.out.println(s1.trim());
		}
		System.out.println("******************************************************");
		
		
		//vi. Extract the selected fields/information from the given query.
		System.out.println("vi. Extract the selected fields/information from the given query.");
		List<String> str6 = StringFunctions.getSelectedFields(inputString6);
		for(String s1:str6){
			System.out.println(s1.trim());
		}
		System.out.println("****************************************************************");
		
		
		//vii. Extract the order by field from the given string.
		System.out.println("vii. Extract the order by field from the given string.");
		List<String> str7 = StringFunctions.getOrderByFields(inputString7);
		for(String s:str7){
			System.out.println(s.trim());
		}
		System.out.println("****************************************************************");
		
		
		//viii. Extract the group by field from the given string.
		System.out.println("viii. Extract the group by field from the given string.");
		List<String> str8 = StringFunctions.getGroupByFields(inputString8);
		for(String s:str8){
			System.out.println(s.trim());
		}
		System.out.println("****************************************************************");
		
		
		//ix. User may required the information like who is getting maximum salary or minimum age etc.. these are called aggregate functions (minimum, maximum, count, average, sum)
		System.out.println("ix. User may required the information like who is getting maximum salary or minimum age etc.. these are called aggregate functions (minimum, maximum, count, average, sum)");
		List<String> str9 = StringFunctions.getAggregateFunctions(inputString9);
		for(String s:str9){
			System.out.println(s.trim());
		}
		System.out.println("****************************************************************");

	}
	



}

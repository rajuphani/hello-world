package utils;

import java.awt.HeadlessException;
import java.util.LinkedHashMap;
import java.util.Map;

public class CSVFunctions1 {
	
	static String header = "id, season, city, date, team1, team2, toss_winner, toss_decision, result, dl_applied, winner, win_by_runs, win_by_wickets, player_of_match, venue, umpire1, umpire2, umpire3";
	static String base = "1, 2008, Bangalore, 2008-04-18, Kolkata Knight Riders, Royal Challengers Bangalore, Royal Challengers Bangalore, field, normal, 0, Kolkata Knight Riders, 140, 0, BB McCullum, M Chinnaswamy Stadium, Asad Rauf, RE Koertzen, ";
	
	public static void main(String[] args){
		LinkedHashMap<String, String> mp = getMapper(header, base);
		
		for(Map.Entry<String, String> mp1:mp.entrySet()){
			System.out.println(mp1.getKey() + ":" + mp1.getValue());
		}
	}
	
	public static LinkedHashMap<String, String> getMapper(String s1,String s2){
		LinkedHashMap<String,String> mp = new LinkedHashMap<String, String>();
		String[] str1 = csvStringSplit(s1);
		String[] str2 = csvStringSplit(s2);
		int i=0;
		if(str1.length==str2.length){
			for(String s:str1){
				mp.put(s.trim(), str2[i].trim());
				i++;
			}
		}
		else{
			System.out.println("Plaese cjeck CSV file. Header count and Records count does not match");
		}
		
		return mp;
	}
	
	public static String[] csvStringSplit(String s1){
		String[] s2 = s1.split(",");
		return s2;
	}
	

	
	public static LinkedHashMap<Integer, LinkedHashMap<String, String>> idMapper(LinkedHashMap<String, String> mp){
		LinkedHashMap<Integer, LinkedHashMap<String, String>> mp1  = new LinkedHashMap<Integer, LinkedHashMap<String,String>>();
		
		int i = Integer.parseInt(mp.get("id"));
		mp1.put(i, mp);
		return mp1;
	}
	



}
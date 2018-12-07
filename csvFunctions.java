package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class csvFunctions {
	
	

	
	
	//Method to read a csv file
		public static List<String> csvReader(String csvFile){
			ArrayList<String> lst = new ArrayList<String>();
			BufferedReader br = null;
			String line = "";
			String cvsSplitBy = ",";
		
			try {

				br = new BufferedReader(new FileReader(csvFile));
				while ((line = br.readLine()) != null) {
					lst.add(line);
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}	
			}
		
			
			return lst;
		}
	
	
	
	public static LinkedHashMap<String, String> getMapperBaseClass(String header,String base){
		LinkedHashMap<String, String> mp = new LinkedHashMap<String, String>();
		String[] arrHeader = header.split(","); 
		String[] newArrHeader = new String[arrHeader.length];
		for(int i=0;i<newArrHeader.length;i++){
			newArrHeader[i] = arrHeader[i].trim();
		}
				
		String[] arrBase = base.split(",");
		String[] newArrBase = new String[arrBase.length];
		for(int i=0;i<arrBase.length;i++){
			if(arrBase[i].equals(" ")){
				newArrBase[i] = returnDataClass(arrBase[i]);
				
			}
			else{
				newArrBase[i] = returnDataClass(arrBase[i].trim());
				
			}
			
			
			
		}
		
		for(int i=0;i<newArrBase.length;i++){
				
				mp.put(newArrHeader[i], newArrBase[i]);
			}
		
			
		return mp;
	}
	
	
	public static LinkedHashMap<String, String> getMapperBaseClass2(String header,String base){
		LinkedHashMap<String, String> mp = new LinkedHashMap<String, String>();
		String[] arrHeader = header.split(","); 
		String[] newArrHeader = new String[arrHeader.length];
		for(int i=0;i<newArrHeader.length;i++){
			newArrHeader[i] = arrHeader[i].trim();
		}
				
		String[] arrBase = base.split(",");
		String[] newArrBase = new String[arrBase.length];
		for(int i=0;i<arrBase.length;i++){
			if(arrBase[i].equals(" ")){
				newArrBase[i] = returnDataClass2(arrBase[i]);
				
			}
			else{
				newArrBase[i] = returnDataClass2(arrBase[i].trim());
				
			}
			
			
			
		}
		
		for(int i=0;i<newArrBase.length;i++){
				
				mp.put(newArrHeader[i], newArrBase[i]);
			}
		
			
		return mp;
	}
	
	
	public static LinkedHashMap<String, String> getMapperValue(String header,String base){
		LinkedHashMap<String, String> mp = new LinkedHashMap<String, String>();
		String[] arrHeader = header.split(","); 
		String[] newArrHeader = new String[arrHeader.length];
		for(int i=0;i<newArrHeader.length;i++){
			newArrHeader[i] = arrHeader[i].trim();
		}
			
		String[] arrBase = base.split(",");
		String[] newArrBase = new String[arrBase.length];
		for(int i=0;i<arrBase.length;i++){
			if(arrBase[i].equals(" ")){
				newArrBase[i] = returnDataValue(arrBase[i]);
				
			}
			else{
				newArrBase[i] = returnDataValue(arrBase[i].trim());
				
			}
				
			
		}
		
		
			for(int i=0;i<newArrBase.length;i++){
				
				mp.put(newArrHeader[i], newArrBase[i]);
			}
		
		
		return mp;
	}
	
	
	public static String returnDataClass(String s){
		if(!Character.isDigit(s.charAt(0))){
			
			return s.getClass().getName();
		}
		else if(s.contains("-")){
			return s.getClass().getName();
		}
		else{
			
			Integer b = Integer.parseInt(s);
			return b.getClass().getName();
		}
	}
	
	
	public static String returnDataClass2(String s){
		if(!Character.isDigit(s.charAt(0))){
			
			return s.getClass().getName();
		}
		else if(s.contains("-")){
			Date date1 = null;;
			 try {
				date1=new SimpleDateFormat("yyyy-MM-dd").parse(s);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			return date1.getClass().getName();
		}
		else{
			
			Integer b = Integer.parseInt(s);
			return b.getClass().getName();
		}
	}
	
	public static String returnDataValue(String s){
		if(!Character.isDigit(s.charAt(0))){
			
			return s;
		}
		else if(s.contains("-")){
			return s;
		}
		else{
			
			Integer b = Integer.parseInt(s);
			return b.toString();
		}
	}
	
	
	public static String getMapperValue(LinkedHashMap<String, String> hm,String s){
		for(Map.Entry<String, String> me:hm.entrySet()){
			if(me.getKey().equalsIgnoreCase(s)){
				return me.getValue();
			}
		}
		return "";
	}
	
	public static String getMapperDataType(LinkedHashMap<String, String> hm,String s){
		for(Map.Entry<String, String> me:hm.entrySet()){
			if(me.getKey().equalsIgnoreCase(s)){
				return me.getValue().getClass().getSimpleName();
			}
		}
		return "";
	}


}

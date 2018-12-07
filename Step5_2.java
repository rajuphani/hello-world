package step5;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import step2.QueryParser;
import step2.Restriction;
import utils.StringFunctions;
import utils.csvFunctions;

public class Step5_2 {

	public static void main(String[] args) {
		
		String baseQuery = "select city, win_by_runs, season from data/ipl.csv where season > 2014 and city = 'Bangalore'";
		
		QueryParser qp = new QueryParser();
		List<String> op = qp.parseQuery(baseQuery).getLogicalOperators();
		
		List<String> fields = qp.parseQuery(baseQuery).getFields();
		
		System.out.println(fields);
		
		List<Restriction> r1 = qp.parseQuery(baseQuery).getRestrictions();
		
		LinkedHashMap<Integer, LinkedHashMap<String,String>> lh = new LinkedHashMap<>();
		
		
		String csvFile = "test1.csv";
		//mapping all lines of CSV file to an array list
		List<String> ar1 = csvFunctions.csvReader(csvFile);
		

		
		List<Integer> idList = new ArrayList<>();
		List<List<Integer>> idList1 = new ArrayList<>();
		
		
		for(int i=1;i<ar1.size();i++){
			LinkedHashMap<String,String> temp = csvFunctions.getMapperValue(ar1.get(0), ar1.get(i));
			lh.put(Integer.parseInt(temp.get("id")), csvFunctions.getMapperValue(ar1.get(0), ar1.get(i)));
						
		}
		
		for(Restriction r:r1){
			
			List<Integer> idList2 = new ArrayList<>();
			for(Map.Entry<Integer, LinkedHashMap<String, String>> m1:lh.entrySet()){
				LinkedHashMap<String, String> m2 = m1.getValue();
				for(Map.Entry<String, String> m3:m2.entrySet()){
					if(r.getPropertyName().equals(m3.getKey())){
						if(StringFunctions.comp(m3.getValue(), r.getPropertyValue(), r.getCondition())){	
							idList2.add(m1.getKey());
														
							break;
						}
						break;
					}
				}
			}
			
			idList1.add(idList2);
		}
		
	
		

		List<Integer> res1 = StringFunctions.whereParser(idList1, op);
		
			
		
		List<String> ar2 = new ArrayList<>();
		
		for(int i=0;i<res1.size();i++){
			for(int j=1;j<ar1.size();j++){
				String t1 = ar1.get(j);
				String t2 = Character.toString(t1.charAt(0));
				String t3 = Integer.toString(res1.get(i));
				
				if(t2.equals(t3)){
					ar2.add(ar1.get(j));
				}
				
				
			}
			
		
			
			
			
		}
		
	
		
		
		//creating a JSON object
				JSONObject objJSON = new JSONObject();
				
				//creating a variable index to hold record number in JSON file
				int index = 1;
				
				if(ar2.size()>0){
					for(int i=0;i<ar2.size();i++){
						//creating a JSON object
						JSONObject objJSON1 = new JSONObject();
						//creating a JSON Array object
						JSONArray objJSARRAY = new JSONArray();
						//Creating a linked hash map and mapping header with each attribute value of the CSV file
						LinkedHashMap<String, String> mp = csvFunctions.getMapperValue(ar1.get(0), ar2.get(i));
						System.out.println("ar1: " + ar1.get(0) + "ar2" + ar2.get(i)) ;
						//Looping through entry set of linked hash map
						for(Map.Entry<String, String> me:mp.entrySet()){
							if(fields.contains(me.getKey())){
								objJSON1.put(me.getKey(), me.getValue());
								
							}
						}
						
						//adding jSon object created from fields to JSON Array
						objJSARRAY.add(objJSON1);
						
						//adding contents of JSON Array to a JSON Object
						for(int j=0;j<objJSARRAY.size();j++){
							objJSON.put(index, objJSARRAY.get(j));
						}
						
						index++;
						
					}
					
					//Printing Query results in the console
					System.out.println(objJSON);
					
					//code to write JSON object to a JSON file
					try {
						FileWriter fw = new FileWriter("step5_2.json");
						fw.write(objJSON.toJSONString());
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
				
				
		
		
		
			
	}
		

		
	
				
		
	}
	
	
	

	



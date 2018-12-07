package step6;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import step2.QueryParser;
import utils.csvFunctions;

public class Step6_1 {
	
	
	public static void main(String[] args) {
		
		
		
		String baseQuery = "select season,city,winner,team1,team2 from test1.csv order by id";
		
		QueryParser qp = new QueryParser();
		
		List<String> fields = qp.parseQuery(baseQuery).getFields();
		
				
		
		List<String> ord = qp.parseQuery(baseQuery).getOrder_by_field();
		String ord1 = ord.get(0);
		
		String csvFile = "test1.csv";
		//mapping all lines of CSV file to an array list
		List<String> ar1 = csvFunctions.csvReader(csvFile);	
		
		LinkedHashMap<String, LinkedHashMap<String, String>> lm = new LinkedHashMap<>();
		LinkedHashMap<String, LinkedHashMap<String, String>> lm1 = new LinkedHashMap<>();
		LinkedHashMap<String, LinkedHashMap<String, String>> lm2 = new LinkedHashMap<>();
		
		
	
		if(ar1.size()>0){
			for(int i=1;i<ar1.size();i++){
				
				LinkedHashMap<String, String> mp = csvFunctions.getMapperValue(ar1.get(0), ar1.get(i));
				lm.put(mp.get("id"), mp);
				lm1.put(mp.get("id"), csvFunctions.getMapperValue(ar1.get(0), ar1.get(i)));
							
			}
								
		}
		
		
		LinkedHashMap<String, String> beforeSort = new LinkedHashMap<>();
		
		
		
		for(String s:ord){
			for(Map.Entry<String, LinkedHashMap<String, String>> me1:lm.entrySet()){
				LinkedHashMap<String, String> me2 = me1.getValue();
				for(Map.Entry<String, String> me3 : me2.entrySet()){
					if(me3.getKey().equals(s)){
						beforeSort.put((me2.get("id")), me3.getValue());
						
					}
				}
			}
			
		}
		
		
		
		LinkedHashMap<String, String> afterSort = sortByValue(beforeSort);
		
		
		
		
		
		for(Map.Entry<String, String> me1:afterSort.entrySet()){
			for(Map.Entry<String, LinkedHashMap<String, String>> me2:lm1.entrySet()){
				if(me1.getKey().equals(me2.getKey())){
					lm2.put(me1.getKey(), me2.getValue());
				}
			}
		}
		
	
		
		JSONObject objJSON = new JSONObject();
		
		int index = 1;
		
		for(Map.Entry<String, LinkedHashMap<String, String>> me1:lm2.entrySet()){
			LinkedHashMap<String, String> temp = me1.getValue();
			//creating a JSON object
			JSONObject objJSON1 = new JSONObject();
			//creating a JSON Array object
			JSONArray objJSARRAY = new JSONArray();
			for(Map.Entry<String, String> me2:temp.entrySet()){
				
				if(fields.contains(me2.getKey())){
					objJSON1.put(me2.getKey(), me2.getValue());
				}
			}
			
			objJSARRAY.add(objJSON1);
			
			for(int i=0;i<objJSARRAY.size();i++){
				objJSON.put(index, objJSARRAY.get(i));
			}
			
			index++;
			
		}
		
		//Printing Query results in the console
		System.out.println(objJSON.toJSONString());
		
		//code to write JSON object to a JSON file
		try {
			FileWriter fw = new FileWriter("Step6_1.json");
			fw.write(objJSON.toJSONString());
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
			
			
	}
	
	 public static LinkedHashMap<String, String> sortByValue(LinkedHashMap<String, String> hm) 
	    { 
	        
	        List<Map.Entry<String, String> > list = 
	               new ArrayList<Map.Entry<String, String> >(hm.entrySet()); 
	  
	     
	        Collections.sort(list, new Comparator<Map.Entry<String, String> >() { 
	            public int compare(Map.Entry<String, String> o1,  
	                               Map.Entry<String, String> o2) 
	            { 
	                return (o1.getValue()).compareTo(o2.getValue()); 
	            } 
	        }); 
	          
	       
	        LinkedHashMap<String, String> temp = new LinkedHashMap<String, String>(); 
	        for (Map.Entry<String, String> aa : list) { 
	            temp.put(aa.getKey(), aa.getValue()); 
	        } 
	        return temp; 
	    } 
	
	
		

}

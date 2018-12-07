package step5;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import step2.QueryParser;
import utils.csvFunctions;

public class Step5_1 {
	
	//1. Filter the data based on selected fields.
	
public static void main(String[] args) {
		
	
		
		String baseQuery = "select season,city,winner,team1,team2 from test1.csv";
		
		
		
		//creating an object of Query Parser class
		QueryParser qp = new QueryParser();
		
		List<String> fields = qp.parseQuery(baseQuery).getFields();
		
		String csvFile = "test1.csv";
		//mapping all lines of CSV file to an array list
		List<String> ar1 = csvFunctions.csvReader(csvFile);
		
		//creating a JSON object
		JSONObject objJSON = new JSONObject();
		
		//creating a variable index to hold record number in JSON file
		int index = 1;
		
		if(ar1.size()>0){
			for(int i=1;i<ar1.size();i++){
				//creating a JSON object
				JSONObject objJSON1 = new JSONObject();
				//creating a JSON Array object
				JSONArray objJSARRAY = new JSONArray();
				//Creating a linked hash map and mapping header with each attribute value of the CSV file
				LinkedHashMap<String, String> mp = csvFunctions.getMapperValue(ar1.get(0), ar1.get(i));
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
				FileWriter fw = new FileWriter("step5_1.json");
				fw.write(objJSON.toJSONString());
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
		
		
		
	}
}

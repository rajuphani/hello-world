package step6;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;

import step2.QueryParser;
import step2.Restriction;
import utils.IPLData;
import utils.Setters;
import utils.csvFunctions;

public class Step6_3 {
	
public static void main(String[] args) {
		
		String baseQuery = "select city,count(*) from data/ipl.csv group by city";
		
		QueryParser qp = new QueryParser();
		
		String csvFile = "test1.csv";
		//mapping all lines of CSV file to an array list
		List<String> ar1 = csvFunctions.csvReader(csvFile);
		
		List<String> op = qp.parseQuery(baseQuery).getLogicalOperators();
		
		List<Restriction> r1 = qp.parseQuery(baseQuery).getRestrictions();
		
		LinkedHashMap<Integer, LinkedHashMap<String,String>> lh = new LinkedHashMap<>();
		
		
		
		List<IPLData> arr2 = new ArrayList<>();
	
		for(int i=1;i<ar1.size();i++){
			LinkedHashMap<String,String> temp = csvFunctions.getMapperValue(ar1.get(0), ar1.get(i));
			arr2.add(Setters.dataEntry(temp));
			
		}
		
		//System.out.println(arr2);
		
		
		Map<String, Long> count = arr2.stream().collect(
                Collectors.groupingBy(IPLData::getCity,Collectors.counting()));
		

	      	        
	        JSONObject objJSON = new JSONObject();
	        objJSON.putAll(count);
	        System.out.println(objJSON.toJSONString());
	        
	      //code to write JSON object to a JSON file
			try {
				FileWriter fw = new FileWriter("Step6_3.json");
				fw.write(objJSON.toJSONString());
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
				
		
	}
	

}
